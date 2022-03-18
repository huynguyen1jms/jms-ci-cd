package com.jmp.springboot.service.impl;

import com.jmp.springboot.model.Event;
import com.jmp.springboot.repository.EventRepository;
import com.jmp.springboot.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public Event getEvent(long id) {
        return null;
    }

    @Override
    public Event deleteEvent(long id) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return null;
    }
}
