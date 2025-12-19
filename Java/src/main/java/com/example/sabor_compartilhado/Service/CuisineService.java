package com.example.sabor_compartilhado.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sabor_compartilhado.Model.Cuisine;
import com.example.sabor_compartilhado.Repository.CuisineRepository;
import com.example.sabor_compartilhado.dto.CuisineRequestDto;
import com.example.sabor_compartilhado.dto.CuisineResponseDto;

@Service
public class CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;

    public List<CuisineResponseDto> listAll(){
        List<Cuisine> cuisines = cuisineRepository.findAll();

        return cuisines.stream().map(cuisine ->{
            CuisineResponseDto dto = new CuisineResponseDto();
            dto.setId(cuisine.getId());
            dto.setName(cuisine.getName());

            return dto;
        }).collect(Collectors.toList());
    }

    public void save(CuisineRequestDto dto){
        Cuisine cuisine = new Cuisine();
        cuisine.setName(dto.getName());

        cuisineRepository.save(cuisine);
    }
}
