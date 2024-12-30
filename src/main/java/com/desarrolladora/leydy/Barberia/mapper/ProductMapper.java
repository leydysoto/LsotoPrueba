package com.desarrolladora.leydy.Barberia.mapper;

import com.desarrolladora.leydy.Barberia.dto.ProductDTO;
import com.desarrolladora.leydy.Barberia.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses ={CategoryMapper.class})
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);
}
