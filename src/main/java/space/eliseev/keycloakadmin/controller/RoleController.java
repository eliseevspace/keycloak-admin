/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.model.entity.Role;
import space.eliseev.keycloakadmin.service.RoleService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о ролях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/role", produces = "application/json; charset=UTF-8")
public class RoleController {

    private final RoleService roleService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Role> getById(@PathVariable String id) {

        final Optional<Role> role = roleService.getById(id);

        return role
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getAllByName/{name}")
    public ResponseEntity<List<Role>> getAllByName(@PathVariable String name) {
        return new ResponseEntity<>(roleService.getAllByName(name), HttpStatus.OK);
    }
}