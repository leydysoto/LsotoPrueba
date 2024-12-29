package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="barbers")
public class Barber {
    @Email
    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    @Id
    @Column(name="email", unique =true,nullable =false,updatable = false)
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

    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en vacio")
    @Size(max = 20, message = "El color no puede exceder los 20 caracteres")
    @Column(name = "color")
    private String color;

    @NotNull(message = "El campo no puede ser nulo")
    @Column(name = "state")
    private Boolean state;


    @Column(name = "payment_amount")
    private Double paymentAmount;


    @NotNull(message = "No puede ser nulo")
    @Min(value = 0, message = "Debe de ser un valor positivo")
    @Max(value = 100, message = "No puede exceder el 100%")
    @Column(name = "discount", nullable = false)
    private Integer discount; //si es por descuento se le calcula al precio del servicio que realiza (su trabajo se ve mediante las orders que tiene en el futurao de tipo servicio)

    @NotNull(message = "No puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local;

    @NotNull(message = "No puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;

}
