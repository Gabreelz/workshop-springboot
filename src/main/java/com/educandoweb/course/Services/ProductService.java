package com.educandoweb.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service // Indica que essa classe é um serviço (regras de negócio)
public class ProductService {

    @Autowired // Injeta o repositório
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll(); // Busca todos os produtos no banco
    }

    public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); // Retorna Optional
		return obj.get(); // Pega o objeto do Optional (lança exceção se não achar)
	}
}