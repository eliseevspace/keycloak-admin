/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.model.dto.EventDto;
import space.eliseev.keycloakadmin.model.mapper.EventMapper;
import space.eliseev.keycloakadmin.repository.EventRepository;
import space.eliseev.keycloakadmin.service.EventService;

import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link EventService}
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDto> getAll() {
        return eventRepository
                .findAll()
                .stream()
                .map(eventMapper::eventToEventDto)
                .toList();
    }

    @Override
    public Optional<EventDto> getById(@NonNull final String id) {
        return eventRepository
                .findById(id)
                .map(eventMapper::eventToEventDto);
    }

    @Override
    public List<EventDto> getAllByUsername(@NonNull final String username) {
        return eventRepository
                .findAllByUsername(username)
                .stream()
                .map(eventMapper::eventToEventDto)
                .toList();
    }

    @Override
    public List<EventDto> getAllBetween(@NonNull final Long startInclusive,
                                        @NonNull final Long endExclusive) {
        return eventRepository
                .findAllBetween(startInclusive, endExclusive)
                .stream()
                .map(eventMapper::eventToEventDto)
                .toList();
    }

    @Override
    public List<EventDto> getAllByUsernameAndBetween(@NonNull final String username,
                                                     @NonNull final Long startInclusive,
                                                     @NonNull final Long endExclusive) {
        return eventRepository
                .findAllByUsernameAndBetween(username, startInclusive, endExclusive)
                .stream()
                .map(eventMapper::eventToEventDto)
                .toList();
    }
}