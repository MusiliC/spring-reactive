package com.flux.reactive.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
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
@Table(value = "language")
public class Language {

    @Id
    @Column(value = "language_id")
    private Integer languageId;

    private String name;

    @Column(value = "last_update")
    private LocalDateTime lastUpdate;
}
