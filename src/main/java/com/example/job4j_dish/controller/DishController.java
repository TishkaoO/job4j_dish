package com.example.job4j_dish.controller;

import com.example.job4j_dish.dto.DishDto;
import com.example.job4j_dish.model.Dish;
import com.example.job4j_dish.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishs")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping
    public List<DishDto> getAllDishs() {
        return dishService.getAllDishs();
    }

    @PostMapping("/save")
    public ResponseEntity<DishDto> save(@RequestBody Dish dish) {
        DishDto saveDish = dishService.save(dish);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        dishService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/update")
    public ResponseEntity<DishDto> update(@RequestBody Dish dish) {
        DishDto updateDish = dishService.update(dish);
        return ResponseEntity.ok(updateDish);
    }

    @GetMapping("/{id}")
    public DishDto getById(@PathVariable Long id) {
        return dishService.getById(id);
    }
}
