package com.flux.reactive.repository;

import com.flux.reactive.entity.Film;
import com.flux.reactive.model.FilmDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface FilmRepository extends ReactiveCrudRepository<Film, Integer> {

    Flux<Film> findAllBy(Pageable pageable);

    @Query("select f.*, l.name  from film f join language l on f.language_id=l.language_id order by f.film_id limit :limit offset :offset")
    Flux<FilmDto> findAllBy(Integer limit, Long offset);

}
