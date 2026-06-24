package com.example.bet.settlement.controller;

import com.example.bet.settlement.dto.SettlementRequest;
import com.example.bet.settlement.service.SettlementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settlements")
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(
            SettlementService settlementService
    ) {
        this.settlementService = settlementService;
    }

    @PostMapping
    public ResponseEntity<String> settle(
            @RequestBody SettlementRequest request
    ) {
        settlementService
                .settleWinningOutCome(request.OutcomeId());

        return ResponseEntity.ok("Settlement completed");
    }
}
