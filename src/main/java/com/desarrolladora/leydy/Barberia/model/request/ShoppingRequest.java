package com.desarrolladora.leydy.Barberia.model.request;

import com.desarrolladora.leydy.Barberia.entity.Client;
import com.desarrolladora.leydy.Barberia.entity.Orders;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShoppingRequest {

    @NotNull(message = "El correo del paciente no puede ser nulo")
    @NotBlank(message = "El correo del paciente no puede estar en blanco")
    @Email(message = "El correo del paciente debe ser válido")
    private String clientEmail;//----para shopping y orders

    @Size(min = 1, message = "Debe haber al menos una orden en la lista")
    List<OrdersRequest> orders;

}
