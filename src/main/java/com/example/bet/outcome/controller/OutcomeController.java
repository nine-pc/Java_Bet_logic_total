package com.example.bet.outcome.controller;

import com.example.bet.outcome.dto.OutcomeResponse;
import com.example.bet.outcome.service.OutcomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
public class OutcomeController {

    private final OutcomeService outcomeService;

    public  OutcomeController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @GetMapping("/{marketId}/outcomes")
    public ResponseEntity<List<OutcomeResponse>> getOutcomes(
            @PathVariable Long marketId
    ) {
        return ResponseEntity.ok(
                outcomeService.getOutcomes(marketId)
        );
    }
}
