package com.example.sabor_compartilhado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sabor_compartilhado.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
