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
import space.eliseev.keycloakadmin.model.dto.EventDto;
import space.eliseev.keycloakadmin.model.entity.Event;

/**
 * Маппер события
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Mapper(componentModel = "spring", imports = TimeUtils.class)
public interface EventMapper {

    @Mapping(target = "eventTime", expression = "java(TimeUtils.longToString(event.getEventTime()))")
    @Mapping(target = "username", expression = "java(event.getUser().getUsername())")
    EventDto eventToEventDto(Event event);

//    @Mapping(target = "eventTime", expression = "java(TimeUtils.toLong(eventDto.getEventTime()))")
//    Event eventDtoToEvent(EventDto eventDto);
}