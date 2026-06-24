package com.example.bet.bet.controller;
import com.example.bet.bet.dto.PlaceBetResponse;
import com.example.bet.bet.dto.PlaceBetRequest;
import com.example.bet.bet.service.BetPlacementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    private final BetPlacementService betPlacementService;

    public BetController(BetPlacementService betPlacementService) {
        this.betPlacementService = betPlacementService;
    }

    @PostMapping
    public ResponseEntity<PlaceBetResponse> placeBet(
            @RequestBody PlaceBetRequest request
    ) {
        PlaceBetResponse response =
                betPlacementService.placeBet(request);

        return  ResponseEntity.ok(response);
    }
}
