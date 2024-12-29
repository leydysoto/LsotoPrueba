package com.desarrolladora.leydy.Barberia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "No puede ser nulo")
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    @Column(name = "description", nullable = false)
    private String description;

    @NotBlank(message = "No puede estar en blanco")
    @NotNull(message = "No puede ser nulo")
    @Column(name = "image", nullable = false)
    private String image;


    @NotNull(message = "No puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio total debe ser mayor o igual a 0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull(message = "No puede ser nulo")
    @Min(value = 0, message = "Debe de ser un valor positivo")
    @Max(value = 100, message = "No puede exceder el 100%")
    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Min(value = 1, message = "Debe de ser un valor positivo")
    @NotNull(message = "No puede ser nulo")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotNull(message = "No puede ser nulo")
    @Column(name = "state",nullable = false)
    private Boolean state=true;

    @NotNull(message = "No puede ser nulo")
    @Min(value =30,message ="la duracion debe ser 30 min")
    @Column(name ="duration",nullable = false)//en min
    private Integer duration;

    @NotNull(message ="no puede ser nulo")
    @ManyToOne(optional = false)
    @JoinColumn(name="categoria_id",referencedColumnName = "id")
    private Category category;


}
