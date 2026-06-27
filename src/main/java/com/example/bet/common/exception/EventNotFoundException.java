package com.example.bet.common.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long eventId) {
        super("Event not found. id=" + eventId);
    }
}
