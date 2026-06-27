package com.example.bet.bet.entity;

import com.example.bet.common.enums.SelectionResult;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("bet_selections")
public record BetSelection(
        @Id
        Long id,

        Long betSlipId,

        Long outcomeId,

        BigDecimal odds,

        SelectionResult result
) {
}
