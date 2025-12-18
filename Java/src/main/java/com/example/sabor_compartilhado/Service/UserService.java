package com.example.sabor_compartilhado.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sabor_compartilhado.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    
}
