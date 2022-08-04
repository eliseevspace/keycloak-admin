/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 * This source code is Aleksandr Eliseev's Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.model.dto.UserDto;
import space.eliseev.keycloakadmin.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о пользователях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user", produces = "application/json; charset=UTF-8")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id) {

        final Optional<UserDto> user = userService.getById(id);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {

        final Optional<UserDto> user = userService.getByUsername(username);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {

        final Optional<UserDto> user = userService.getByEmail(email);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
