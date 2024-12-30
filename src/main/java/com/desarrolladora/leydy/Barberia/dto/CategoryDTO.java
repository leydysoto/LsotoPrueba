package com.desarrolladora.leydy.Barberia.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDTO {

    private Long id;
    private  String name;
    private String description;
    private Boolean state;
}
