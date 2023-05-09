package com.example.job4j_dish.service;

import com.example.job4j_dish.dto.DishDto;
import com.example.job4j_dish.model.Dish;

import java.util.List;

public interface DishService {

    DishDto save(Dish dish);

    void deleteById (Long id);

    DishDto update(Dish dish);

    DishDto getById(Long id);

    List<DishDto> getAllDishs();
}
