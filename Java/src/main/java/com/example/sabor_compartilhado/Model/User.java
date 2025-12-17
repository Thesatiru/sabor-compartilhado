package com.example.sabor_compartilhado.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private LocalDate birthDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
