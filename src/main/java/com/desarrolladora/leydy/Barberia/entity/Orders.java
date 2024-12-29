package com.desarrolladora.leydy.Barberia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")//compra servicios o productos(llamado productos)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //------------fecha y horario del servicio a recibir-------------//
    @NotNull(message = "La fecha de la cita no puede ser nula")
    @Column(name="appointment_date",nullable = false)
    private LocalDate appointmentDate;

    @NotNull(message = "La hora de la cita no puede ser nula")
    @Column(name ="appointment_time",nullable = false)
    private LocalTime appointmentTime;
    //----------------------------------------------//
    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "La cantidad no puede ser nula")
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull(message ="no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private  Product product;

    @NotNull(message ="no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "email")
    private Client client;

    @NotNull(message ="no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "barber_id", referencedColumnName = "email")
    private Barber barber;

    @NotNull(message ="no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "shopping_id", referencedColumnName = "id")
    @JsonIgnore
    private Shopping shopping;
}
