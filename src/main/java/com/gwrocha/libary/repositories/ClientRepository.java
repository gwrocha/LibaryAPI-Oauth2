package com.gwrocha.libary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwrocha.libary.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	public Optional<Client> findByHashId(String hashId);
	
}
