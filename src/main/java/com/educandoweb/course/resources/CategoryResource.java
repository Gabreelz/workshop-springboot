package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.Services.CategoryService;
import com.educandoweb.course.entities.Categories;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired 
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Categories>> findAll() {
		List<Categories> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categories> findById(@PathVariable Long id) {
		Categories obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
