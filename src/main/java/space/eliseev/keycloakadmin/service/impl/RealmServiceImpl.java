/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 *  This source code is Aleksandr Eliseev's Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package space.eliseev.keycloakadmin.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.model.entity.Realm;
import space.eliseev.keycloakadmin.repository.RealmRepository;
import space.eliseev.keycloakadmin.service.RealmService;

import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link RealmService}
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@Service
@RequiredArgsConstructor
public class RealmServiceImpl implements RealmService {

    private final RealmRepository realmRepository;

    @Override
    public List<Realm> getAll() {
        return realmRepository.findAll();
    }

    @Override
    public Optional<Realm> getById(@NonNull final String id) {
        return realmRepository.findById(id);
    }

    @Override
    public Optional<Realm> getByName(@NonNull final String name) {
        return realmRepository.findByName(name);
    }
}