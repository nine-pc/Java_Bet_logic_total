package com.example.bet.event.dto;

import java.time.LocalDateTime;

public record EventResponse(

        Long id,
        String homeTeam,
        String awayTeam,
        LocalDateTime startTime,
        String status
) {
}
