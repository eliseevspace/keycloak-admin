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
import space.eliseev.keycloakadmin.model.entity.Realm;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о realm
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
public interface RealmService {

    /**
     * Получить список всех realm
     *
     * @return список всех realm
     */
    List<Realm> getAll();

    /**
     * Получить realm по идентификатору
     *
     * @param id Идентификатор realm
     * @return realm
     */
    Optional<Realm> getById(@NonNull String id);

    /**
     * Получить realm по имени
     *
     * @param name Имя realm
     * @return realm
     */
    Optional<Realm> getByName(@NonNull String name);
}