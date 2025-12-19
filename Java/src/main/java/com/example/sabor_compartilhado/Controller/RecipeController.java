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

import com.example.sabor_compartilhado.Service.RecipeService;
import com.example.sabor_compartilhado.dto.RecipeRequestDto;
import com.example.sabor_compartilhado.dto.RecipeResponseDto;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService; 

    @GetMapping
    public List<RecipeResponseDto> getAll(){
        return recipeService.listAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody RecipeRequestDto dto){
        recipeService.save(dto);
        return ResponseEntity.status(201).body("Receita cadastrada com sucesso!");
    }


}
