package com.example.sabor_compartilhado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sabor_compartilhado.Model.Cuisine;
import com.example.sabor_compartilhado.Repository.CuisineRepository;
import com.example.sabor_compartilhado.dto.CuisineDto;

@Service
public class CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;

    public List<Cuisine> listAll(){
        return cuisineRepository.findAll();
    }

    public Cuisine save(CuisineDto dto){
        Cuisine cuisine = new Cuisine();
        cuisine.setName(dto.getName());

        return cuisineRepository.save(cuisine);
    }
}
