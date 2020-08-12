package com.etna.gpe.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;
import com.etna.gpe.model.User;



public class JwtUserDetails implements org.springframework.security.core.userdetails.UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User currentUser;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public JwtUserDetails(User user){
		currentUser = user;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
		
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		String password = null;
		if(currentUser instanceof Particular)
			password = ((Particular) currentUser).getParticularPassword();
		if(currentUser instanceof Organization)
			password = ((Organization) currentUser).getOrganizationPassword();
		
		return currentUser != null ? password : null;
	}

	@Override
	public String getUsername() {
		String email = null;
		if(currentUser instanceof Particular)
			email = ((Particular) currentUser).getParticularEmail();
		if(currentUser instanceof Organization)
			email = ((Organization) currentUser).getOrganizationEmail();
		return currentUser != null ? email : null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

