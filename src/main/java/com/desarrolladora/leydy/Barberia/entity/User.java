package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name="users")
public class User {
    @Email
    @NotNull(message ="email no puede ser null")
    @NotBlank(message ="email no puede  estar en blanco")
    @Id
    @Column(name="email",unique=true)
    private String email;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Size(max = 100, message = "La Contraseña no puede exceder los 100 caracteres")
    @Column(name = "password")
    private String password;

    @NotNull(message ="names no puede ser null")
    @NotBlank(message ="names no puede  estar en blanco")
    @Column(name ="names", length =50,nullable=false)
    private String names;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Column(name = "lastnames",length = 200, nullable = false)
    private String lastNames;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Size(max = 9, message = "El Número no puede exceder los 9 caracteres")
    @Column(name = "phone",length=9, nullable = false)
    private String phone;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Column(name = "rol")
    private String rol;

}
