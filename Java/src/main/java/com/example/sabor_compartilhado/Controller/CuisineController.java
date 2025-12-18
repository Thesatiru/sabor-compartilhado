package com.example.sabor_compartilhado.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sabor_compartilhado.Model.Cuisine;
import com.example.sabor_compartilhado.Service.CuisineService;
import com.example.sabor_compartilhado.dto.CuisineDto;


@RestController
@RequestMapping("/api/cuisines")
@CrossOrigin(origins = "*")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @GetMapping
    public List<Cuisine> getAll(){
        return cuisineService.listAll();
    }

    @PostMapping
    public Cuisine create(@RequestBody CuisineDto cuisineDto){
        return cuisineService.save(cuisineDto);
    }
}
