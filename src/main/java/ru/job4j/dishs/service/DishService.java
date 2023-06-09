package ru.job4j.dishs.service;

import ru.job4j.dishs.dto.DishDto;
import ru.job4j.dishs.mapper.DishMapper;
import ru.job4j.dishs.model.Dish;
import ru.job4j.dishs.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public DishDto save(Dish dish) {
        Dish builder = Dish.builder()
                .name(dish.getName())
                .description(dish.getDescription())
                .build();
        dishRepository.save(builder);
        log.info("Dishes added! ");
        return dishMapper.toDto(builder);
    }

    public void deleteById(Long id) {
        Dish dish = getDishByIdOrElseThrow(id);
        dishRepository.delete(dish);
    }

    public DishDto update(Dish dish) {
        Dish entity = getDishByIdOrElseThrow(dish.getId());
        Dish builder = Dish.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
        dishRepository.save(builder);
        return dishMapper.toDto(builder);
    }

    public DishDto getById(Long id) {
        Dish dish = getDishByIdOrElseThrow(id);
        return dishMapper.toDto(dish);
    }

    public List<DishDto> getAllDishs() {
        List<Dish> dishs = dishRepository.findAll();
        return dishMapper.toDto(dishs);
    }

    private Dish getDishByIdOrElseThrow(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("This dish with id: " + id + " is not exists");
                    return new NoSuchElementException("Dish is not exists");
                });
    }
}
