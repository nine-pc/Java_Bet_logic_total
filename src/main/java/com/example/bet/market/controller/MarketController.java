package com.example.bet.market.controller;

import com.example.bet.market.dto.MarketResponse;
import com.example.bet.market.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/{eventId}/markets")
    public ResponseEntity<List<MarketResponse>> getMarkets(
            @PathVariable Long eventId
    ) {
        return ResponseEntity.ok(
                marketService.getMarkets(eventId)
        );
    }
}
