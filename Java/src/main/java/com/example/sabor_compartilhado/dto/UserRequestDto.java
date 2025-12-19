package com.example.sabor_compartilhado.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate birthDate;

}
