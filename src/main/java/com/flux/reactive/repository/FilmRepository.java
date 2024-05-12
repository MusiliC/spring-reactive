package com.flux.reactive.repository;

import com.flux.reactive.entity.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface FilmRepository extends ReactiveCrudRepository<Film, Integer> {

    Flux<Film> findAllBy(Pageable pageable);

}
