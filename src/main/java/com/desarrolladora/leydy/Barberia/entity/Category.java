package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "El campo no puede ser nulo")
    @Column(name="name", unique =true,nullable =false)
    private  String name;

    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "El campo no puede ser nulo")
    @Column(name="description")
    private String description;

    @NotNull(message = "El campo no puede ser nulo")
    @Column(name = "state",nullable = false)
    private Boolean state =true;
}
