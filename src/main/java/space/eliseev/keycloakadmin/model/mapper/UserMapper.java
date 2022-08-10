/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import space.eliseev.keycloakadmin.common.TimeUtils;
import space.eliseev.keycloakadmin.model.dto.UserDto;
import space.eliseev.keycloakadmin.model.entity.User;

/**
 * Маппер пользователя
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Mapper(componentModel = "spring", imports = TimeUtils.class)
public interface UserMapper {

    @Mapping(target = "createdTimestamp", expression = "java(TimeUtils.toZonedDateTime(user.getCreatedTimestamp()))")
    UserDto userToUserDto(User user);

    @Mapping(target = "createdTimestamp", expression = "java(TimeUtils.toLong(userDto.getCreatedTimestamp()))")
    User userDtoToUser(UserDto userDto);
}