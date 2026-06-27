package com.example.bet.market.service;

import com.example.bet.market.dto.MarketResponse;
import com.example.bet.market.entity.Market;
import com.example.bet.market.repository.MarketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository ) {
        this.marketRepository = marketRepository;
    }

    public List<MarketResponse> getMarkets(Long eventId) {

        return marketRepository.findByEventId(eventId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private MarketResponse toResponse(Market market) {

        return new MarketResponse(
                market.id(),
                market.eventId(),
                market.name()
        );
    }
}
