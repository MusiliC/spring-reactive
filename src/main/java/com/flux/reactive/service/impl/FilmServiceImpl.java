package com.flux.reactive.service.impl;

import com.flux.reactive.entity.Film;
import com.flux.reactive.entity.Language;
import com.flux.reactive.model.FilmDto;
import com.flux.reactive.repository.FilmRepository;
import com.flux.reactive.repository.LanguageRepository;
import com.flux.reactive.service.FilmService;
import java.util.List;
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

    private final LanguageRepository languageRepository;

    public FilmServiceImpl(FilmRepository filmRepository, LanguageRepository languageRepository) {
        this.filmRepository = filmRepository;
        this.languageRepository = languageRepository;
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
                .zipWith(languageRepository.findAll().collectList())
                .flatMap(t -> {
                    List<Film> filmList = t.getT1().getT1();
                    Long totalCount = t.getT1().getT2();
                    List<Language> languages = t.getT2();
                    for (Film film : filmList) {
                        for (Language language : languages) {
                            if (film.getLanguageId().equals(language.getLanguageId())) {
                                film.setLanguageName(language.getName());
                                break;
                            }
                        }
                    }
                    Page<Film> page = new PageImpl<>(filmList, pageRequest, totalCount);
                    return Mono.just(page);
                });
    }

    @Override
    public Mono<Page<FilmDto>> getFilmsDto(PageRequest pageRequest) {
        return filmRepository.findAllBy(pageRequest.getPageSize(), pageRequest.getOffset())
                .collectList()
                .zipWith(filmRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }
}
