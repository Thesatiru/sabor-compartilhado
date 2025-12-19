package com.example.sabor_compartilhado.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RecipeRequestDto {
    private String name;
    private String resume;
    private String description;
    private Integer timePrerationMinutes;
    private LocalDateTime publicationDate;
    private Long cuisineId;
}
