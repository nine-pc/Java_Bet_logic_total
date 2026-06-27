package com.example.bet.wallet.entity;

import com.example.bet.common.enums.TransactionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table("transactions")
public record Transaction(

        @Id
        Long id,

        Long userId,

        BigDecimal amount,

        TransactionType type,

        LocalDateTime createdAt

) {
}
