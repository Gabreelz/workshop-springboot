package com.educandoweb.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepositories;

// Classe de serviço responsável pela lógica de negócio de "User"
@Service
public class UserServices {

    // Injeta automaticamente o repositório para não precisarmos instanciar manualmente
    @Autowired
    private UserRepositories repository;
    
    // Método para buscar todos os usuários no banco
    public List<User> findAll() {
        return repository.findAll(); 
        // repository.findAll() vem do JpaRepository -> retorna lista com todos os usuários
    }
    
    // Método para buscar usuário por ID
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id); 
        // repository.findById(id) retorna um Optional<User> (pode ou não conter valor)
        
        return obj.get(); 
        // obj.get() pega o valor dentro do Optional.
        // ⚠️ Se o usuário não existir, dá erro (NoSuchElementException).
        // Mais pra frente, podemos melhorar tratando o erro (ex: lançar exceção customizada).
    }

    public User insert(User obj) {
		return repository.save(obj);
	}
}
