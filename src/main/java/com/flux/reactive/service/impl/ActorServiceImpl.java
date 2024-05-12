package com.flux.reactive.service.impl;

import com.flux.reactive.entity.Actor;
import com.flux.reactive.exceptions.ActorNotFoundException;
import com.flux.reactive.repository.ActorRepository;
import com.flux.reactive.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Flux<Actor> listAll() {
        return actorRepository.findAll();
    }

    @Override
    public Mono<Actor> findActorId(Integer actorId) {
        return actorRepository.findById(actorId)
                .switchIfEmpty(Mono.error(new ActorNotFoundException("Actor not found")));
    }

    @Override
    public Mono<Page<Actor>> findActorsPaginated(PageRequest pageRequest) {
        return actorRepository.findAllBy(pageRequest.withSort(Sort.by("actorId").ascending()))
                .collectList()
                .zipWith(actorRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }

    @Override
    public Mono<Actor> createActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
