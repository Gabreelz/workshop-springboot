package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.Services.OrderServices;
import com.educandoweb.course.entities.Order;

// Controlador REST que expõe os recursos relacionados a "User".
@RestController 
@RequestMapping(value = "/orders") // Define o caminho base da API: http://localhost:8080/orders
public class OrderResource {

    // Injeta automaticamente a classe de serviço para ser usada aqui
    @Autowired
    private OrderServices services;

    // Mapeia requisições GET para o endpoint /users
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        
        // Chama o serviço para buscar todos os usuários no banco
        List<Order> list = services.findAll();
        
        // Retorna resposta HTTP 200 OK com a lista no corpo da resposta
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}