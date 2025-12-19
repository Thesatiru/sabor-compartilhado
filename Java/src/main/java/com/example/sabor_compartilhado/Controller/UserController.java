package com.example.sabor_compartilhado.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sabor_compartilhado.Service.UserService;
import com.example.sabor_compartilhado.dto.UserRequestDto;
import com.example.sabor_compartilhado.dto.UserResponseDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.listAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserRequestDto dto){
        userService.save(dto);

        return ResponseEntity.status(201).body("Usuário cadastrado com sucesso!");
    }

}
