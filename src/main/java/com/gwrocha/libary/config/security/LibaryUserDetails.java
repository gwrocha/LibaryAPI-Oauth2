package com.gwrocha.libary.config.security;

import static com.gwrocha.libary.models.enums.StatusUser.ACCOUNT_EXPIRED;
import static com.gwrocha.libary.models.enums.StatusUser.ACCOUNT_LOCKED;
import static com.gwrocha.libary.models.enums.StatusUser.ACTIVE;
import static com.gwrocha.libary.models.enums.StatusUser.CREDENTIALS_EXPIRED;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gwrocha.libary.models.User;
import com.gwrocha.libary.models.enums.Role;

public class LibaryUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public LibaryUserDetails() {}
	
	public LibaryUserDetails(User user) {
		this.setUser(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Function<String, GrantedAuthority> toGrantedAuthority = role -> () -> role;
		
		return user.getRoles().stream()
			.map(Role::name)
			.map(role -> "ROLE_" + role)
			.map(toGrantedAuthority)
			.collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.getStatus().equals(ACCOUNT_EXPIRED);
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.getStatus().equals(ACCOUNT_LOCKED);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.getStatus().equals(CREDENTIALS_EXPIRED);
	}

	@Override
	public boolean isEnabled() {
		return getUser().getStatus().equals(ACTIVE);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
