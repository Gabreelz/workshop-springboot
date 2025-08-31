package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.User;

// Repository: camada de acesso a dados
@Repository 
public interface UserRepositories extends JpaRepository<User, Long> {
    // Não precisa escrever nada aqui, o JpaRepository já traz métodos prontos:
    // save, findById, findAll, delete, etc.
}
