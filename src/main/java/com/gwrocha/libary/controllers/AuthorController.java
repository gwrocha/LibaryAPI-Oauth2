package com.gwrocha.libary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.libary.models.Author;
import com.gwrocha.libary.repositories.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;
	
	@GetMapping
	public List<Author> getAll(){
		return authorRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		authorRepo.deleteById(id);
	}
	
}
