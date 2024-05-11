package com.flux.reactive.repository;

import com.flux.reactive.entity.Actor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ActorRepository  extends ReactiveCrudRepository<Actor, Integer> {
}
