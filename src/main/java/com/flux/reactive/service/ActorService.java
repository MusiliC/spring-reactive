package com.flux.reactive.service;

import com.flux.reactive.entity.Actor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {
    Flux<Actor> listAll();

    Mono<Actor> findActorId(Integer actorId);

    Mono<Page<Actor>> findActorsPaginated(PageRequest pageRequest);

    Mono<Actor> createActor(Actor actor);
}
