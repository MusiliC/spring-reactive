package com.flux.reactive.service;

import com.flux.reactive.entity.Film;
import com.flux.reactive.model.FilmDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmService {
    Flux<Film> listAll();

    Mono<Page<Film>> getFilmsPage(PageRequest pageRequest);

    Mono<Page<FilmDto>> getFilmsDto(PageRequest pageRequest);
}
