package com.educandoweb.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Categories;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
   
    @Autowired
	private CategoryRepository repository;

	public List<Categories> findAll() {
        return repository.findAll();
	}
	
	public Categories findById(Long id) {
		Optional<Categories> obj = repository.findById(id);
		return obj.get();
    }
}
