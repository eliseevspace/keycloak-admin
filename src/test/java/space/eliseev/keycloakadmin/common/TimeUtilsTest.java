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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
class TimeUtilsTest {

    private static final long TIME_TRUE = 1658091600000L;
    private static final long TIME_FALSE = 1658137290001L;
    private ZonedDateTime zonedDateTime;
    private LocalDate localDate;

    @BeforeEach
    void setUp() {
        zonedDateTime = ZonedDateTime.of(2022, 7, 18, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
        localDate = LocalDate.of(2022, 7, 18);
    }

    @Test
    void toZonedDateTime() {
        assertEquals(zonedDateTime, TimeUtils.toZonedDateTime(TIME_TRUE));
        assertNotEquals(zonedDateTime, TimeUtils.toZonedDateTime(TIME_FALSE));
    }

    @Test
    void toLong() {
        assertEquals(TIME_TRUE, TimeUtils.toLong(zonedDateTime));
        assertNotEquals(TIME_FALSE, TimeUtils.toLong(zonedDateTime));
    }

    @Test
    void localDateToLong() {
        assertEquals(TIME_TRUE, TimeUtils.localDateToLong(localDate));
        assertNotEquals(TIME_FALSE, TimeUtils.localDateToLong(localDate));
    }
}