package com.flux.reactive.entity;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "actor")
public class Actor {

    @Id
    @Column(value = "actor_id")
    private Integer actorId;

    @Column(value = "first_name")
    @Max(45)
    @NotNull
    private String firstName;

    @Column(value = "last_name")
    @Max(45)
    @NotNull
    private String lastName;

    @Column(value = "last_update")
    private LocalDateTime lastUpdate;

}
