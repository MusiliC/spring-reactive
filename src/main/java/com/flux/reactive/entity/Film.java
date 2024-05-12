package com.flux.reactive.entity;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "film")
public class Film {

    @Id
    @Column(value = "film_id")
    private Integer filmId;

    private String title;

    private String description;

    @Column(value = "release_year")
    private Integer releaseYear;

    @Column(value = "language_id")
    private Integer languageId;

    @Column(value = "original_language_id")
    private Integer originalLanguageId;

    @Column(value = "rent_duration")
    private double rentalDuration;

    @Column(value = "rental_rate")
    private double rentalRate;

    @Column(value = "replacement_cost")
    private double replacementCost;

    private  String rating;

    @Column(value = "special_features")
    private  String specialFeatures;

    @Column(value = "last_update")
    private LocalDateTime lastUpdate;

    @Transient
    private String languageName;
}