package com.example.bet.bet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record PlaceBetRequest(

        @NotNull
        Long userId,

        @Positive
        BigDecimal stake,

        @NotEmpty
        List<Long> outcomeIds
) {
}
