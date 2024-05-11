package com.flux.reactive.service;

import com.flux.reactive.entity.Actor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {
    Flux<Actor> listAll();

    Mono<Actor> findActorId(Integer actorId);
}
