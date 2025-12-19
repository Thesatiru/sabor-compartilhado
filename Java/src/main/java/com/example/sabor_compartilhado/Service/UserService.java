package com.example.sabor_compartilhado.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sabor_compartilhado.Model.User;
import com.example.sabor_compartilhado.Repository.UserRepository;
import com.example.sabor_compartilhado.dto.UserRequestDto;
import com.example.sabor_compartilhado.dto.UserResponseDto;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> listAll(){
        List<User> users= userRepository.findAll();

        return users.stream().map(user -> {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhoneNumber(user.getPhoneNumber());
            dto.setBirthDate(user.getBirthDate());
            dto.setCreatedAt(user.getCreatedAt());

            return dto;
        }).collect(Collectors.toList());
    }

    public void save(UserRequestDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        user.setBirthDate(dto.getBirthDate());

        userRepository.save(user);
    }
}
