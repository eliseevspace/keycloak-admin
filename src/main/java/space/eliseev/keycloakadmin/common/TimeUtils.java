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

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Утилитный класс для работы с датой
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@UtilityClass
public class TimeUtils {

    public static ZonedDateTime toZonedDateTime(@NonNull final Long value) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.of("Europe/Moscow"));
    }

    public static Long toLong(@NonNull final ZonedDateTime value) {
        return value.toInstant().toEpochMilli();
    }
}