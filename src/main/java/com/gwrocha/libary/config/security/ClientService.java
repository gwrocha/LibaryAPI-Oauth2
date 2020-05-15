package com.gwrocha.libary.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.gwrocha.libary.models.Client;
import com.gwrocha.libary.repositories.ClientRepository;

@Primary
@Service
public class ClientService implements ClientDetailsService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Optional<Client> client = clientRepository.findByHashId(clientId);
		return client.map(LibaryClientDetails::new)
				.orElseThrow(() -> new AuthenticationServiceException("Client not found."));
	}

}
