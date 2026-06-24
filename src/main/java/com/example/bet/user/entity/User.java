package com.example.bet.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("users")
public record User(
    @Id
    Long id,

    String username,

    BigDecimal balance,

    LocalDateTime createdAt
) {

}