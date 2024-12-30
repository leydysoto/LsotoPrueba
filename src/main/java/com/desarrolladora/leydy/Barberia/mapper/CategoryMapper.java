package com.desarrolladora.leydy.Barberia.mapper;

import com.desarrolladora.leydy.Barberia.dto.CategoryDTO;
import com.desarrolladora.leydy.Barberia.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface CategoryMapper {

    CategoryDTO ToCategoryDTO(Category category);
}
