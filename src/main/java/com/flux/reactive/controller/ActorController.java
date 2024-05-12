package com.flux.reactive.controller;


import com.flux.reactive.entity.Actor;
import com.flux.reactive.service.ActorService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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

    @GetMapping("/all")
    public Mono<Page<Actor>> getActorsPaginated(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return actorService.findActorsPaginated(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("{actorId}")
    public Mono<Actor> findActorById(@PathVariable Integer actorId) {
        return actorService.findActorId(actorId);
    }

    @PostMapping
    public Mono<Actor> createActor(@RequestBody @Valid Actor actor) {
        return actorService.createActor(actor);
    }
}
