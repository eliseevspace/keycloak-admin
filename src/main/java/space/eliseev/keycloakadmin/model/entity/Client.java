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
 * Клиент
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "full_scope_allowed")
    private Boolean fullScopeAllowed;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "not_before")
    private Integer notBefore;

    @Column(name = "public_client")
    private Boolean publicClient;

    @Column(name = "secret")
    private String secret;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "bearer_only")
    private Boolean bearerOnly;

    @Column(name = "management_url")
    private String managementUrl;

    @Column(name = "surrogate_auth_required")
    private Boolean surrogateAuthRequired;

    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "node_rereg_timeout")
    private Integer nodeReregTimeout;

    @Column(name = "frontchannel_logout")
    private Boolean frontchannelLogout;

    @Column(name = "consent_required")
    private Boolean consentRequired;

    @Column(name = "name")
    private String name;

    @Column(name = "service_accounts_enabled")
    private Boolean serviceAccountsEnabled;

    @Column(name = "client_authenticator_type")
    private String clientAuthenticatorType;

    @Column(name = "root_url")
    private String rootUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "registration_token")
    private String registrationToken;

    @Column(name = "standard_flow_enabled")
    private Boolean standardFlowEnabled;

    @Column(name = "implicit_flow_enabled")
    private Boolean implicitFlowEnabled;

    @Column(name = "direct_access_grants_enabled")
    private Boolean directAccessGrantsEnabled;

    @Column(name = "always_display_in_console")
    private Boolean alwaysDisplayInConsole;
}