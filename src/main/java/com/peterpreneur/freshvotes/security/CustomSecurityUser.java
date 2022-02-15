package com.peterpreneur.freshvotes.security;



import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import com.peterpreneur.freshvotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails {
	
	private static final long serialVersionUID = 2415303909064316732L;
	
	public CustomSecurityUser() {};

	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return this.getAuthorities();
	}

	@Override
	public String getPassword() {
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}