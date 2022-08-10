/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import space.eliseev.keycloakadmin.model.entity.Event;
import space.eliseev.keycloakadmin.model.entity.User;

import java.util.Optional;

/**
 * Утилитный класс для работы с объектами
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@UtilityClass
public class ObjectUtils {

    /**
     * Получить логин пользователя из события
     *
     * @param event Событие
     * @return логин пользователя
     */
    public String getUsername(@NonNull Event event) {
        return Optional.ofNullable(event.getUser())
                .map(User::getUsername)
                .orElse(null);
    }
}