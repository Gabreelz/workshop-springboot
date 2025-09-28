package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.Services.UserServices;
import com.educandoweb.course.entities.User;

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

    @PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}