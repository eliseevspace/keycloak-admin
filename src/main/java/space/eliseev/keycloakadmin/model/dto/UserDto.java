/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.model.dto;

import lombok.Builder;
import lombok.Data;
import space.eliseev.keycloakadmin.model.entity.User;

import java.time.ZonedDateTime;

/**
 * DTO пользователя {@link User}
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Data
@Builder
public class UserDto {

    private String email;
    private Boolean emailVerified;
    private Boolean enabled;
    private String firstName;
    private String lastName;
    private String realmName;
    private String username;
    private ZonedDateTime createdTimestamp;
    private Integer notBefore;
}
