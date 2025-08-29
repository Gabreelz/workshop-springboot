package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		// Cria manualmente um usuário fictício (não vem do banco ainda).
		
		return ResponseEntity.ok().body(u);
		// Retorna resposta HTTP 200 OK, com o objeto User no corpo.
        // O Spring converte automaticamente o User em JSON.
	}
}
