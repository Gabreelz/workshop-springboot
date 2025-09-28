package com.educandoweb.course.Services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.Services.exceptions.DatabaseException;
import com.educandoweb.course.Services.exceptions.ResourceNotFoundException;
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
        
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
		return repository.save(obj);
	}

    public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

    public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
