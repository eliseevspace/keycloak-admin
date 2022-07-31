/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.keycloakadmin.entity.Event;
import space.eliseev.keycloakadmin.service.EventService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о событиях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/event", produces = "application/json; charset=UTF-8")
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Event>> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {

        final Optional<Event> event = eventService.getById(id);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getAllByUserId/{userId}")
    public ResponseEntity<List<Event>> getAllByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(eventService.getAllByUserId(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllBetween")
    public ResponseEntity<List<Event>> getAllBetween(@RequestParam Long startInclusive,
                                                     @RequestParam Long endExclusive) {
        return new ResponseEntity<>(eventService.getAllBetween(startInclusive, endExclusive), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllByUserIdAndBetween/{userId}")
    public ResponseEntity<List<Event>> getAllByUserIdAndBetween(@PathVariable String userId,
                                                                @RequestParam Long startInclusive,
                                                                @RequestParam Long endExclusive) {
        return new ResponseEntity<>(eventService.getAllByUserIdAndBetween(userId, startInclusive, endExclusive), HttpStatus.OK);
    }
}