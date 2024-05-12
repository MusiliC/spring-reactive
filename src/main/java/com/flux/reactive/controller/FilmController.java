package com.flux.reactive.controller;


import com.flux.reactive.entity.Actor;
import com.flux.reactive.entity.Film;
import com.flux.reactive.service.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public Flux<Film> getAllFilms() {
        return filmService.listAll();
    }

    @GetMapping("/all")
    public Mono<Page<Film>> getFilmsPaginated(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                @RequestParam(value = "pageSize",  defaultValue = "10") Integer pageSize) {
        return filmService.getFilmsPage(PageRequest.of(pageNumber, pageSize));
    }
}
