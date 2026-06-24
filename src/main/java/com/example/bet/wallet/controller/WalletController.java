package com.example.bet.wallet.controller;

import com.example.bet.wallet.dto.DepositRequest;
import com.example.bet.wallet.dto.DepositResponse;
import com.example.bet.wallet.dto.TransactionResponse;
import com.example.bet.wallet.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<DepositResponse> deposit(@RequestBody DepositRequest request) {
        return ResponseEntity.ok(walletService.deposit(request));
    }

    @GetMapping("/{userId}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactions(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                walletService.getTransactions(userId)
        );
    }
}
