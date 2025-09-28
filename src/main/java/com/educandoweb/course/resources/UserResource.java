package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Define que este método responde a requisições HTTP POST para criar um novo usuário
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {  
    // Chama o serviço para inserir o usuário no banco de dados
    // O método 'insert' do UserService usa repository.save(obj)
    obj = services.insert(obj);    
    // Cria a URI do novo recurso criado
    // Exemplo: se o usuário criado tem id = 5, a URI será /users/5
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // pega o caminho atual (/users)
            .path("/{id}") // adiciona /{id} à URI
            .buildAndExpand(obj.getId()) // substitui {id} pelo id do usuário criado
            .toUri(); // converte para URI
    // Retorna a resposta HTTP 201 Created
    // Adiciona a URI do recurso criado no cabeçalho Location
    // Retorna também o objeto User no corpo da resposta
    return ResponseEntity.created(uri).body(obj);
}

    // Define que este método responde a requisições HTTP DELETE para deletar um usuário
    // A URL deve conter o ID do usuário a ser deletado, por exemplo: /users/5
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    // Chama o serviço para deletar o usuário do banco de dados pelo ID
    // O UserService provavelmente usa repository.deleteById(id)
    services.delete(id);
    // Retorna uma resposta HTTP 204 No Content
    // Significa que a operação foi bem-sucedida, mas não há conteúdo para retornar
    return ResponseEntity.noContent().build();
}


}