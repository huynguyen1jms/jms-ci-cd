package com.jmp.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getEventsById() {
        return ResponseEntity.ok("Java mentoring program");
    }
}
