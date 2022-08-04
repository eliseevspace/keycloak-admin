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
import space.eliseev.keycloakadmin.model.entity.Event;

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
    List<Event> getAll();

    /**
     * Получить событие по идентификатору
     *
     * @param id Идентификатор события
     * @return событие
     */
    Optional<Event> getById(@NonNull String id);

    /**
     * Получить список событий по идентификатору пользователя
     *
     * @param userId Идентификатор пользователя
     * @return список событий
     */
    List<Event> getAllByUserId(@NonNull String userId);

    /**
     * Получить список событий за период
     *
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    List<Event> getAllBetween(@NonNull Long startInclusive, @NonNull Long endExclusive);

    /**
     * Получить список событий по идентификатору пользователя за период
     *
     * @param userId         Идентификатор пользователя
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    List<Event> getAllByUserIdAndBetween(@NonNull String userId, @NonNull Long startInclusive, @NonNull Long endExclusive);
}