package com.example.bet.user.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserResponse(
    Long id,
    String username,
    BigDecimal balance,
    LocalDateTime createdAt
) {
}
