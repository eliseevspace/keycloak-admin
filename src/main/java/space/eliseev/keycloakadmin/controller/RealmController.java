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
import space.eliseev.keycloakadmin.model.entity.Realm;
import space.eliseev.keycloakadmin.service.RealmService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о realm
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/realm", produces = "application/json; charset=UTF-8")
public class RealmController {

    private final RealmService realmService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Realm>> getAll() {
        return new ResponseEntity<>(realmService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Realm> getById(@PathVariable String id) {

        final Optional<Realm> realm = realmService.getById(id);

        return realm
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Realm> getByName(@PathVariable String name) {

        final Optional<Realm> realm = realmService.getByName(name);

        return realm
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}