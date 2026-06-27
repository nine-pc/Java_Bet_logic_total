package com.example.bet.wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositRequest(

        @NotNull
        Long userId,

        @Positive
        BigDecimal amount
) {
}
