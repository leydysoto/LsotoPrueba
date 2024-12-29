package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shopping")
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El correo del paciente no puede ser nulo")
    @NotBlank(message = "El correo del paciente no puede estar en blanco")
    @Email(message = "El correo del paciente debe ser válido")
    @Column(name = "client_email", nullable = false)
    private String clientEmail;

    @NotNull(message = "El tiempo total no puede ser nulo")
    @Column(name = "total_time", nullable = false)
    private LocalTime totalTime;

    @NotNull(message = "El precio total no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio total debe ser mayor o igual a 0")
    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @OneToMany(mappedBy = "shopping", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Orders> orders;//detalle de la compra del producto o servicio
}
