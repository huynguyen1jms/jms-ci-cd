package com.jmp.springboot.service;

import com.jmp.springboot.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event getEvent(long id);

    Event deleteEvent(long id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}
