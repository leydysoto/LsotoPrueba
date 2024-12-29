package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
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
@Table(name="clients")
public class Client {
    @Email
    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Id
    @Column(name="email", unique =true,nullable =false, updatable = false)
    private  String email;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Column(name = "names",length = 50, nullable = false)
    private String names;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Column(name = "lastnames", length =200, updatable = false )
    private String lastNames;

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Size(max = 9, message = "El Número no puede exceder los 9 caracteres")
    @Column(name = "phone",length = 9, nullable = false)
    private String phone;


    @NotNull(message = "El campo no puede ser nulo")
    @Column(name = "state")
    private Boolean state;

    @NotNull(message = "No puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;


}
