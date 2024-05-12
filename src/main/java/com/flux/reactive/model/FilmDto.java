package com.flux.reactive.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {

    private Integer filmId;

    private String title;

    private String description;

    private Integer releaseYear;

    @JsonProperty("languageName")
    private String name;
}
