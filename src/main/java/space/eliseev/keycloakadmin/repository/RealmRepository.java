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
import org.springframework.stereotype.Repository;
import space.eliseev.keycloakadmin.model.entity.Realm;

import java.util.Optional;

/**
 * Получение информации о realm
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Repository
public interface RealmRepository extends JpaRepository<Realm, String> {

    /**
     * Найти realm по имени
     *
     * @param name Имя realm
     * @return realm
     */
    Optional<Realm> findByName(String name);
}