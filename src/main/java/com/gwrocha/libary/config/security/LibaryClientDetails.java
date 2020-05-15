package com.gwrocha.libary.config.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.gwrocha.libary.models.Client;

public class LibaryClientDetails implements ClientDetails {

	private static final long serialVersionUID = 1L;

	private Client client;
	
	public LibaryClientDetails(Client client) {
		this.setClient(client);
	}

	@Override
	public String getClientId() {
		return client.getHashId();
	}

	@Override
	public Set<String> getResourceIds() {
		return new HashSet<String>(Arrays.asList(client.getResource()));
	}

	@Override
	public boolean isSecretRequired() {
		return client.isSecretRequired();
	}

	@Override
	public String getClientSecret() {
		return client.getSecret();
	}

	@Override
	public boolean isScoped() {
		return client.isScoped();
	}

	@Override
	public Set<String> getScope() {
		return new HashSet<String>(Arrays.asList(client.getScope()));
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return new HashSet<String>(Arrays.asList(client.getGrantType().split(";")));
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return new HashSet<String>(Arrays.asList(client.getRedirectUri()));
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		GrantedAuthority grantedAuthority = () -> client.getRole();
		return Arrays.asList(grantedAuthority);
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return client.getAccessTokenValidity();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return client.getRefreshTokenValidity();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return Collections.emptyMap();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
