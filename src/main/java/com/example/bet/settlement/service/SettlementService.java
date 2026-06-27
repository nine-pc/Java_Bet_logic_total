package com.example.bet.settlement.service;

import com.example.bet.bet.entity.BetSelection;
import com.example.bet.bet.entity.BetSlip;
import com.example.bet.bet.repository.BetSelectionRepository;
import com.example.bet.bet.repository.BetSlipRepository;
import com.example.bet.common.enums.BetStatus;
import com.example.bet.common.enums.SelectionResult;
import com.example.bet.common.enums.TransactionType;
import com.example.bet.user.entity.User;
import com.example.bet.user.repository.UserRepository;
import com.example.bet.wallet.entity.Transaction;
import com.example.bet.wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SettlementService {

    private final BetSelectionRepository betSelectionRepository;
    private final BetSlipRepository betSlipRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public SettlementService(
            BetSelectionRepository betSelectionRepository,
            BetSlipRepository betSlipRepository,
            UserRepository userRepository,
            TransactionRepository transactionRepository
    ) {
        this.betSelectionRepository = betSelectionRepository;
        this.betSlipRepository = betSlipRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void settleWinningOutCome(Long outcomeId) {

        List<BetSelection> selections =
                betSelectionRepository.findByOutcomeId(outcomeId);

        for(BetSelection selection: selections) {

            BetSelection updatedSelection =
                    new BetSelection(
                            selection.id(),
                            selection.betSlipId(),
                            selection.outcomeId(),
                            selection.odds(),
                            SelectionResult.WIN
                    );

            betSelectionRepository.save(updatedSelection);

            BetSlip betSlip =
                    betSlipRepository.findById(selection.betSlipId())
                            .orElseThrow();

            BetSlip updatedBetSlip =
                    new BetSlip(
                            betSlip.id(),
                            betSlip.userId(),
                            betSlip.stake(),
                            betSlip.totalOdds(),
                            betSlip.potentialPayout(),
                            BetStatus.WON,
                            betSlip.createdAt()
                    );

            betSlipRepository.save(updatedBetSlip);

            User user =
                    userRepository.findById(betSlip.userId())
                            .orElseThrow();

            User updatedUser =
                    new User(
                            user.id(),
                            user.username(),
                            user.balance()
                                    .add(betSlip.potentialPayout()),
                            user.createdAt()
                    );

            userRepository.save(updatedUser);

            transactionRepository.save(
                    new Transaction(
                            null,
                            user.id(),
                            betSlip.potentialPayout(),
                            TransactionType.BET_WON,
                            LocalDateTime.now()
                    )
            );
        }
    }
}
