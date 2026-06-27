package com.example.bet.event.entity;

import com.example.bet.common.enums.EventStatus;
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

        EventStatus status,

        LocalDateTime createdAt
) {
}
