package com.gwrocha.libary.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String hashId;
	
	private String resource;

	@Column( columnDefinition =  "boolean default true")
	private boolean secretRequired;
	
	private String secret;
	
	@Column( columnDefinition =  "boolean default true")
	private boolean isScoped;
	
	private String scope;
	
	private String grantType;
	
	private String redirectUri;
	
	private String role;
	
	private Integer accessTokenValidity;
	
	private Integer refreshTokenValidity;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public boolean isScoped() {
		return isScoped;
	}

	public void setScoped(boolean isScoped) {
		this.isScoped = isScoped;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSecretRequired(boolean secretRequired) {
		this.secretRequired = secretRequired;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}
	
	public String getHashId() {
		if(hashId == null && id != null)
			hashId = String.valueOf(id.toString().hashCode());
		return hashId;
	}

	public boolean isSecretRequired() {
		return secretRequired;
	}
	
	public void generateHashId(){
		if(hashId == null && id != null)
			hashId = String.valueOf(id.toString().hashCode());
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}
	
}
