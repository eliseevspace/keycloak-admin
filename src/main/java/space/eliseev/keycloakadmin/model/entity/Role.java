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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Роль
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Getter
@Setter
@Entity
@Table(name = "keycloak_role")
public class Role extends BaseEntity {

    @Column(name = "client_realm_constraint")
    private String clientRealmConstraint;

    @Column(name = "client_role")
    private Boolean clientRole;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "client")
    private String client;

    @Column(name = "realm")
    private String realm;
}
