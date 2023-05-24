package ru.job4j.dishs.dto;

import lombok.*;

@Builder
@Data
public class DishDto {
    private String name;
    private double price;
}
