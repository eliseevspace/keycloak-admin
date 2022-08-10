/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.model.dto.EventDto;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о событиях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
public interface EventService {

    /**
     * Получить список всех событий
     *
     * @return список событий
     */
    List<EventDto> getAll();

    /**
     * Получить событие по идентификатору
     *
     * @param id Идентификатор события
     * @return событие
     */
    Optional<EventDto> getById(@NonNull String id);

    /**
     * Получить список событий по логину пользователя
     *
     * @param username Логин пользователя
     * @return список событий
     */
    List<EventDto> getAllByUsername(@NonNull String username);

    /**
     * Получить список событий за период
     *
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    List<EventDto> getAllBetween(@NonNull Long startInclusive, @NonNull Long endExclusive);

    /**
     * Получить список событий по логину пользователя за период
     *
     * @param username       Логин пользователя
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    List<EventDto> getAllByUsernameAndBetween(@NonNull String username, @NonNull Long startInclusive, @NonNull Long endExclusive);
}