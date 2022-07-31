/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.eliseev.keycloakadmin.entity.Event;

import java.util.List;

/**
 * Получение информации о событиях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
public interface EventRepository extends JpaRepository<Event, String> {

    /**
     * Найти все события по идентификатору пользователя
     *
     * @param userId Идентификатор пользователя
     * @return список событий
     */
    List<Event> findAllByUserId(String userId);

    /**
     * Найти все события за период
     *
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    @Query("SELECT e FROM Event e WHERE e.eventTime BETWEEN :startInclusive AND :endExclusive")
    List<Event> findAllBetween(Long startInclusive, Long endExclusive);

    /**
     * Найти все события по идентификатору пользователя за период
     *
     * @param userId         Идентификатор пользователя
     * @param startInclusive Дата начала
     * @param endExclusive   Дата конца (исключительно)
     * @return список событий
     */
    @Query("SELECT e FROM Event e WHERE e.userId = :userId AND e.eventTime BETWEEN :startInclusive AND :endExclusive")
    List<Event> findAllByUserIdAndBetween(String userId, Long startInclusive, Long endExclusive);
}