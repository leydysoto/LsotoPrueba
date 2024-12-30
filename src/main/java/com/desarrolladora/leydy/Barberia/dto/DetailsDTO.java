package com.desarrolladora.leydy.Barberia.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DetailsDTO {
    private Long id;
    private String description;
    private String image;
    private Double price;
    private Integer discount;
    private Integer stock;
    private Boolean state;
    private Integer duration;
    private  String nameCategory;
    private String descriptionCategory;
}
