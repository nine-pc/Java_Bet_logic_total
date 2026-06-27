package com.example.bet.event.service;

import com.example.bet.event.dto.EventResponse;
import com.example.bet.event.repository.EventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAllEvents() {

        return ((List<com.example.bet.event.entity.Event>)
                eventRepository.findAll())
                .stream()
                .map(event -> new EventResponse(
                        event.id(),
                        event.homeTeam(),
                        event.awayTeam(),
                        event.startTime(),
                        event.status()
                ))
                .toList();
    }
}
