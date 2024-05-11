package com.flux.reactive.service;

import com.flux.reactive.entity.User;

import reactor.core.publisher.Flux;

public interface UserService {
    Flux<User> getUsers();
}
