package com.desarrolladora.leydy.Barberia.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "No puede ser nulo")
    private String description;

    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "No puede ser nulo")
    private String image;

    @NotNull(message = "No puede ser nulo")
    private String price;

    @NotNull(message = "No puede ser nulo")
    private Integer discount;
    @NotNull(message = "No puede ser nulo")
    private Integer stock;//solo los productos  tendran  stock

    private Boolean state;//se le pasa en el endpoint de actualizar

    @NotNull(message = "No puede ser nulo")
    private Integer duration;

    @NotNull(message = "No puede ser nulo")
    private Long categoryId;


}
