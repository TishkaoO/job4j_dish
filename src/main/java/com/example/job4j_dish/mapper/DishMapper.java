package com.example.job4j_dish.mapper;

import com.example.job4j_dish.dto.DishDto;
import com.example.job4j_dish.model.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    DishDto toDto(Dish dish);

    List<DishDto> toDto(List<Dish> dishs);

    Dish toEntity(DishDto dto);

    List<Dish> toEntity(List<DishDto> dtos);
}
