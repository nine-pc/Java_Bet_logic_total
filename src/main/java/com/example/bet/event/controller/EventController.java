package com.example.bet.event.controller;

import com.example.bet.event.dto.EventResponse;
import com.example.bet.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getEvents() {
        return ResponseEntity.ok(
                eventService.getAllEvents()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEvent(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }
}
