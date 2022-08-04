/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Событие
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Getter
@Setter
@Entity
@Table(name = "event_entity")
public class Event extends BaseEntity {

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "details_json")
    private String detailsJson;

    @Column(name = "error")
    private String error;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "event_time")
    private Long eventTime;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String userId;
}