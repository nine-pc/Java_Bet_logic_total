package com.example.bet.outcome.service;

import com.example.bet.outcome.dto.OutcomeResponse;
import com.example.bet.outcome.entity.Outcome;
import com.example.bet.outcome.repository.OutComeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutcomeService {

    private final OutComeRepository outComeRepository;

    public OutcomeService(OutComeRepository outComeRepository) {
        this.outComeRepository = outComeRepository;
    }

    public List<OutcomeResponse> getOutcomes(Long marketId) {

        return outComeRepository.findByMarketId(marketId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private OutcomeResponse toResponse(Outcome outcome) {
        return new OutcomeResponse(
                outcome.id(),
                outcome.marketId(),
                outcome.name(),
                outcome.odds(),
                outcome.active()
        );
    }
}
