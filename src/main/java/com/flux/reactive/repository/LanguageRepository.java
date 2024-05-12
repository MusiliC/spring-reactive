package com.flux.reactive.repository;

import com.flux.reactive.entity.Language;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LanguageRepository extends ReactiveCrudRepository<Language, Integer> {
}
