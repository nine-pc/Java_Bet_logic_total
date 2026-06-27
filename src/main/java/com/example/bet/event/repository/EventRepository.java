package com.example.bet.event.repository;

import com.example.bet.event.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long>{
}
