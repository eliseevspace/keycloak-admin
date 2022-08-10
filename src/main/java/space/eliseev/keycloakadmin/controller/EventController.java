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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.keycloakadmin.model.dto.EventDto;
import space.eliseev.keycloakadmin.service.EventService;

import java.time.LocalDate;
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
@Tag(name = "Event API", description = "Получение информации о событиях")
public class EventController {

    private final EventService eventService;

    @Operation(
            summary = "Get all events",
            description = "Получить список всех событий",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<EventDto>> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get event by ID",
            description = "Получить событие по идентификатору",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Event not found")
    })
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<EventDto> getEventById(
            @Parameter(
                    required = true,
                    description = "Идентификатор события")
            @PathVariable String id) {

        final Optional<EventDto> event = eventService.getById(id);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Get all events by username",
            description = "Получить список событий по логину пользователя",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAllByUsername/{username}")
    public ResponseEntity<List<EventDto>> getAllByUsername(
            @Parameter(
                    required = true,
                    description = "Логин пользователя")
            @PathVariable String username) {
        return new ResponseEntity<>(eventService.getAllByUsername(username), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all events for the period",
            description = "Получить список событий за период",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAllBetween")
    public ResponseEntity<List<EventDto>> getAllBetween(
            @Parameter(
                    required = true,
                    description = "Дата начала")
            @RequestParam LocalDate startInclusive,

            @Parameter(
                    required = true,
                    description = "Дата конца (исключительно)")
            @RequestParam LocalDate endExclusive) {
        return new ResponseEntity<>(eventService.getAllBetween(startInclusive, endExclusive), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all events by username for the period",
            description = "Получить список событий по логину пользователя за период",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAllByUsernameAndBetween/{username}")
    public ResponseEntity<List<EventDto>> getAllByUsernameAndBetween(
            @Parameter(
                    required = true,
                    description = "Логин пользователя")
            @PathVariable String username,

            @Parameter(
                    required = true,
                    description = "Дата начала")
            @RequestParam LocalDate startInclusive,

            @Parameter(
                    required = true,
                    description = "Дата конца (исключительно)")
            @RequestParam LocalDate endExclusive) {
        return new ResponseEntity<>(eventService.getAllByUsernameAndBetween(username, startInclusive, endExclusive), HttpStatus.OK);
    }
}