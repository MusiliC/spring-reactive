package com.flux.reactive.repository;

import com.flux.reactive.entity.Actor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface ActorRepository  extends ReactiveCrudRepository<Actor, Integer> {

    Flux<Actor> findAllBy(Pageable pageable);

}
