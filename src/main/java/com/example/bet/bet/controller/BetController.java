package com.example.bet.bet.controller;

import com.example.bet.bet.dto.BetSlipResponse;
import com.example.bet.bet.dto.CancelBetResponse;
import com.example.bet.bet.dto.PlaceBetResponse;
import com.example.bet.bet.dto.PlaceBetRequest;
import com.example.bet.bet.service.BetPlacementService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    private final BetPlacementService betPlacementService;

    public BetController(BetPlacementService betPlacementService) {
        this.betPlacementService = betPlacementService;
    }

    @PostMapping
    public ResponseEntity<PlaceBetResponse> placeBet(
            @Valid @RequestBody PlaceBetRequest request
    ) {
        PlaceBetResponse response =
                betPlacementService.placeBet(request);

        return  ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BetSlipResponse>> getUserBets(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                betPlacementService.getUserBets(userId)
        );
    }

    @PostMapping("/{betId}/cancel")
    public ResponseEntity<CancelBetResponse> cancelBet(
            @PathVariable Long betId
    ) {
        return ResponseEntity.ok(
                betPlacementService.cancelBet(betId)
        );
    }
}
