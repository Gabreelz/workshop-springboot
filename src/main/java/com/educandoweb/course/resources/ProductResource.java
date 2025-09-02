package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.Services.ProductService;
import com.educandoweb.course.entities.Product;

@RestController // Define que essa classe é um controlador REST
@RequestMapping(value = "/products") // Define o endpoint base da API (/products)
public class ProductResource {

    @Autowired // Injeta automaticamente a dependência (ProductService)
    private ProductService service;

    @GetMapping // Mapeia requisições GET em /products
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll(); // Busca todos os produtos
        return ResponseEntity.ok().body(list); // Retorna 200 OK + lista no corpo
    }

    @GetMapping(value = "/{id}") // Mapeia GET com parâmetro /products/{id}
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id); // Busca produto pelo id
        return ResponseEntity.ok().body(obj); // Retorna 200 OK + produto no corpo
    }
}