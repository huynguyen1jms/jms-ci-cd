package com.jmp.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jmp.springboot.model.Event;
import com.jmp.springboot.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/event")
@Controller
public class EventServiceController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventService eventService;

    @Autowired
    private ObjectWriter objectWriter;

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public ResponseEntity<String> getEventsById(@RequestParam(name = "id") long id) throws JsonProcessingException {

        Event event = eventService.getEvent(id);
        if (event == null) {
            LOGGER.info("event not found");
            return ResponseEntity.notFound().build();
        }

        String responseJson = objectWriter.writeValueAsString(event);

        return ResponseEntity.ok(responseJson);
    }

    @RequestMapping(value = "/get-by-title", method = RequestMethod.GET)
    public ResponseEntity<String> getEventsByTitle(@RequestParam(name = "title") String title) throws JsonProcessingException {

        List<Event> events = eventService.getAllEventsByTitle(title);
        if (events == null || events.isEmpty()) {
            LOGGER.info("event not found");
            return ResponseEntity.notFound().build();
        }

        String responseJson = objectWriter.writeValueAsString(events);

        return ResponseEntity.ok(responseJson);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<String> getAllEvents() throws JsonProcessingException {

        List<Event> events = eventService.getAllEvents();
        if (events == null) {
            LOGGER.info("events not found");
            return ResponseEntity.notFound().build();
        }

        String responseJson = objectWriter.writeValueAsString(events);

        return ResponseEntity.ok(responseJson);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createEvent(@RequestBody Event event) throws JsonProcessingException {
        event = eventService.createEvent(event);

        String responseJson = objectWriter.writeValueAsString(event);

        return ResponseEntity.ok(responseJson);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvent(@RequestBody Event event) throws JsonProcessingException {
        event = eventService.updateEvent(event);

        String responseJson = objectWriter.writeValueAsString(event);

        return ResponseEntity.ok(responseJson);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event.getId());

        return ResponseEntity.ok("Deleted");
    }
}
