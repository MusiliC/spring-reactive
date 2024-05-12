package com.flux.reactive.service.impl;

import com.flux.reactive.entity.Film;
import com.flux.reactive.repository.FilmRepository;
import com.flux.reactive.service.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Flux<Film> listAll() {
        return filmRepository.findAll();
    }

    @Override
    public Mono<Page<Film>> getFilmsPage(PageRequest pageRequest) {
        return filmRepository.findAllBy(pageRequest.withSort(Sort.by("filmId").ascending()))
                .collectList()
                .zipWith(filmRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }
}
