package ru.job4j.dishs.service;

import ru.job4j.dishs.dto.DishDto;
import ru.job4j.dishs.model.Dish;

import java.util.List;

public interface DishService {

    DishDto save(Dish dish);

    void deleteById(Long id);

    DishDto update(Dish dish);

    DishDto getById(Long id);

    List<DishDto> getAllDishs();
}
