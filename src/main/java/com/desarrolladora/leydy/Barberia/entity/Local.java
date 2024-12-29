package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="locals")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "No puede ser nulo")
    @Size(max = 100, message = "La Nombre del local no puede exceder los 100 caracteres")
    @Column(name = "names", nullable = false, unique = true)
    private String name;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede ser blanco")
    @Size(max = 100, message = "La Nombre del local no puede exceder los 100 caracteres")
    @Column(name = "location", nullable = false)
    private String location;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "La descripción no puede estar vacia")
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    @Column(name = "description", length =255,nullable= false)
    private String description;

    @NotNull(message = "No puede ser nulo")
    @Column(name = "state")
    private boolean state =true;
}
