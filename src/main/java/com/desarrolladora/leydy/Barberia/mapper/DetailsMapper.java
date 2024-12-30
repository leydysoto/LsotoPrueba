package com.desarrolladora.leydy.Barberia.mapper;

import com.desarrolladora.leydy.Barberia.dto.DetailsDTO;
import com.desarrolladora.leydy.Barberia.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface DetailsMapper {
    @Mapping(source="product.category.name",target="nameCategory")
    @Mapping(source="product.category.description",target="descriptionCategory")
    DetailsDTO toDetailsDTO(Product product);

}
