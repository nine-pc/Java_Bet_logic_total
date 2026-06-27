package com.example.bet.event.service;

import com.example.bet.event.dto.EventResponse;
import com.example.bet.event.entity.Event;
import com.example.bet.event.repository.EventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAllEvents() {

        return StreamSupport
                .stream(eventRepository.findAll().spliterator(), false)
                .map(this::toResponse)
                .toList();
    }

    public EventResponse getEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return toResponse(event);
    }

    private EventResponse toResponse(Event event) {
        return new EventResponse(
                event.id(),
                event.homeTeam(),
                event.awayTeam(),
                event.startTime(),
                event.status()
        );
    }
}
