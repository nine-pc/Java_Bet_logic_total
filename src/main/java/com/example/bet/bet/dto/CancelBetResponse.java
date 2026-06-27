package com.example.bet.bet.dto;

import com.example.bet.common.enums.BetStatus;

public record CancelBetResponse(

        Long betId,

        BetStatus status
) {
}
