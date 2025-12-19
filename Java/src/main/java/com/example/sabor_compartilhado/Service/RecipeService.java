package com.example.sabor_compartilhado.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sabor_compartilhado.Model.Cuisine;
import com.example.sabor_compartilhado.Model.Recipe;
import com.example.sabor_compartilhado.Repository.CuisineRepository;
import com.example.sabor_compartilhado.Repository.RecipeRepository;
import com.example.sabor_compartilhado.dto.RecipeRequestDto;
import com.example.sabor_compartilhado.dto.RecipeResponseDto;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    public List<RecipeResponseDto> listAll(){
        List<Recipe> recipes = recipeRepository.findAll();

        return recipes.stream().map(recipe ->{
            RecipeResponseDto dto = new RecipeResponseDto();
            dto.setId(recipe.getId());
            dto.setName(recipe.getName());
            dto.setResume(recipe.getResume());
            dto.setDescription(recipe.getDescription());
            dto.setPublicationDate(recipe.getPublicationDate());

            if (recipe.getCuisine() != null) {
                dto.setCuisineId(recipe.getCuisine().getId());
            }
            dto.setTimePrerationMinutes(recipe.getTimePreparationMinutes());

            return dto;
        }).collect(Collectors.toList());
    }

    public void save(RecipeRequestDto dto){
        Recipe recipe = new Recipe();
        recipe.setName(dto.getName());
        recipe.setResume(dto.getResume());
        recipe.setDescription(dto.getDescription());
        recipe.setTimePreparationMinutes(dto.getTimePrerationMinutes());
        Cuisine cuisine = cuisineRepository.findById(dto.getCuisineId()).orElseThrow(()-> new RuntimeException("Culinária não encontrada"));

        recipe.setCuisine(cuisine);

        recipeRepository.save(recipe);
    }
    
}
