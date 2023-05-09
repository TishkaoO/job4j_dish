package ru.job4j.dishs.mapper;

import ru.job4j.dishs.dto.DishDto;
import ru.job4j.dishs.model.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    DishDto toDto(Dish dish);

    List<DishDto> toDto(List<Dish> dishs);

    Dish toEntity(DishDto dto);

    List<Dish> toEntity(List<DishDto> dtos);
}
