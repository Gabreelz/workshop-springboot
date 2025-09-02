package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository já fornece métodos prontos (findAll, findById, save, delete...)
    // Não precisa implementar nada aqui
}
