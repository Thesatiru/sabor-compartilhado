package com.example.sabor_compartilhado.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
}
