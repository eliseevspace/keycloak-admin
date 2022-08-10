/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 * This source code is Aleksandr Eliseev's Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.model.dto.UserDto;
import space.eliseev.keycloakadmin.model.mapper.UserMapper;
import space.eliseev.keycloakadmin.repository.UserRepository;
import space.eliseev.keycloakadmin.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link UserService}
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .toList();
    }

    @Override
    public Optional<UserDto> getById(@NonNull final String id) {
        return userRepository
                .findById(id)
                .map(userMapper::userToUserDto);
    }

    @Override
    public Optional<UserDto> getByUsername(@NonNull final String username) {
        return userRepository
                .findByUsername(username)
                .map(userMapper::userToUserDto);
    }

    @Override
    public Optional<UserDto> getByEmail(@NonNull final String email) {
        return userRepository
                .findByEmail(email)
                .map(userMapper::userToUserDto);
    }
}