package com.example.bet.event.dto;

import com.example.bet.common.enums.EventStatus;

import java.time.LocalDateTime;

public record EventResponse(

        Long id,
        String homeTeam,
        String awayTeam,
        LocalDateTime startTime,
        EventStatus status
) {
}
