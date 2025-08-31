package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.Services.UserServices;

// Controlador REST que expõe os recursos relacionados a "User".
@RestController 
@RequestMapping(value = "/users") // Define o caminho base da API: http://localhost:8080/users
public class UserResource {

    // Injeta automaticamente a classe de serviço para ser usada aqui
    @Autowired
    private UserServices services;

    // Mapeia requisições GET para o endpoint /users
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        
        // Chama o serviço para buscar todos os usuários no banco
        List<User> list = services.findAll();
        
        // Retorna resposta HTTP 200 OK com a lista no corpo da resposta
        // O Spring converte automaticamente a lista de User em JSON
        return ResponseEntity.ok().body(list);
    }

}