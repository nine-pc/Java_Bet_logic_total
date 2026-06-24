package com.example.bet.bet.service;

import com.example.bet.bet.dto.PlaceBetRequest;
import com.example.bet.bet.dto.PlaceBetResponse;
import com.example.bet.bet.entity.BetSlip;
import com.example.bet.bet.repository.BetSlipRepository;
import com.example.bet.outcome.entity.Outcome;
import com.example.bet.outcome.repository.OutComeRepository;
import com.example.bet.user.entity.User;
import com.example.bet.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BetPlacementService {

    private final UserRepository userRepository;
    private final OutComeRepository outComeRepository;
    private final BetSlipRepository betSlipRepository;

    public BetPlacementService(
            UserRepository userRepository,
            OutComeRepository outComeRepository,
            BetSlipRepository betSlipRepository
    ) {
        this.userRepository = userRepository;
        this.outComeRepository = outComeRepository;
        this.betSlipRepository = betSlipRepository;
    }

    @Transactional
    public PlaceBetResponse placeBet(PlaceBetRequest request) {
        validateRequest(request);

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(user.balance().compareTo(request.stake()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        Outcome outcome = outComeRepository.findById(request.outcomeIds().get(0))
                .orElseThrow(() -> new RuntimeException("Outcome not found"));

        if(!Boolean.TRUE.equals(outcome.active())) {
            throw new RuntimeException("Outcome is not active");
        }

        BigDecimal totalOdds = outcome.odds();
        BigDecimal potentialPayout = request.stake().multiply(totalOdds);

        BetSlip betSlip = new BetSlip(
                null,
                user.id(),
                request.stake(),
                totalOdds,
                potentialPayout,
                "PENDING",
                LocalDateTime.now()
        );

        BetSlip savedBetSlip = betSlipRepository.save(betSlip);

        User updatedUser = new User(
                user.id(),
                user.username(),
                user.balance().subtract(request.stake()),
                user.createdAt()
        );

        userRepository.save(updatedUser);

        return new PlaceBetResponse(
                savedBetSlip.id(),
                totalOdds,
                potentialPayout
        );
    }

    private void validateRequest(PlaceBetRequest request) {
        if(request.userId() == null) {
            throw new RuntimeException("userId is required");
        }

        if(request.stake() == null || request.stake().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("stake must be positive");
        }

        if(request.outcomeIds() == null || request.outcomeIds().isEmpty()) {
            throw new RuntimeException("At least one outcome is required");
        }
    }
}
