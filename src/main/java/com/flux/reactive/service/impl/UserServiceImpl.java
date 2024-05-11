package com.flux.reactive.service.impl;

import com.flux.reactive.entity.User;
import com.flux.reactive.repository.UserRepository;
import com.flux.reactive.service.UserService;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Flux<User> getUsers() {
      return   userRepository.findAll();
    }
}
