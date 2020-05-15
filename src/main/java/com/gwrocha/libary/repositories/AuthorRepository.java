package com.gwrocha.libary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwrocha.libary.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	public Author findByName(String name);
	
}
