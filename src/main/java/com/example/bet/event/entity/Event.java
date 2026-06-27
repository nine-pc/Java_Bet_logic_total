package com.example.bet.event.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("events")
public record Event(

        @Id
        Long id,

        String homeTeam,

        String awayTeam,

        LocalDateTime startTime,

        String status,

        LocalDateTime createdAt
) {
}
