package com.etna.gpe.utils;

import java.util.List;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;
import com.etna.gpe.model.User;


public class Userutils {
	
	public static User getUserFromCrediential(List<User> users, String passwordUnEncoded) {
		User userResult = null;
		String password = null;
		for(User user : users) {
			if(user instanceof Particular)
				password = ((Particular) user).getParticularPassword();
			if(user instanceof Organization)
				password = ((Organization) user).getOrganizationPassword();
			
			if(StringUtils.verifyHash(passwordUnEncoded, password)) {
				userResult = user;	
				break;
			}
		}
		return userResult;
	}
	
	  public static boolean isConnected() {
	        SecurityContext securityContext = SecurityContextHolder.getContext();
	        return securityContext.getAuthentication().isAuthenticated();
	    }
	  
	  public static org.springframework.security.core.userdetails.UserDetails getCurrentUser(){
	        SecurityContext securityContext = SecurityContextHolder.getContext();
	        Object details = securityContext.getAuthentication().getPrincipal();
	    	if(details instanceof org.springframework.security.core.userdetails.UserDetails)
	    	    return (org.springframework.security.core.userdetails.UserDetails) details;
	    	else
	    	    return null;
	    }
	  
		/*
		 * public static User getUserFromUserdetails(UserRepository userRepository) {
		 * return userRepository.findByUsername(getCurrentUser().getUsername()); }
		 */
}
