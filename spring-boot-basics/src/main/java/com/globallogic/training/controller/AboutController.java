package com.globallogic.training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/about")
public final class AboutController {

    @GetMapping
    public ResponseEntity<String> about() {
        return ResponseEntity.ok().body("Hello from Spring Boot Basics! Time: " + LocalDateTime.now());
    }
}