package com.flux.reactive.controller;


import com.flux.reactive.entity.Actor;
import com.flux.reactive.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public Flux<Actor> getActors() {
        return actorService.listAll();
    }

    @GetMapping("{actorId}")
    public Mono<Actor> findActorById(@PathVariable Integer actorId) {
        return actorService.findActorId(actorId);
    }
}
