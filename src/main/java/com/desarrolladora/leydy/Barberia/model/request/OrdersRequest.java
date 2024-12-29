package com.desarrolladora.leydy.Barberia.model.request;

import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.entity.Shopping;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrdersRequest {

    @NotNull(message ="no puede ser nulo")
    @NotBlank(message = " no puede estar en blanco")
    private String appointmentDate;

    @NotNull(message ="no puede ser nulo")
    @NotBlank(message = " no puede estar en blanco")
    private String appointmentTime;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message ="no puede ser nulo")
    @NotBlank(message = " no puede estar en blanco")
    private String clientEmail;

    @NotNull(message ="no puede ser nulo")
    @NotBlank(message = " no puede estar en blanco")
    private String barberEmail;

    @NotNull(message ="no puede ser nulo")
    private Long productId;

}
