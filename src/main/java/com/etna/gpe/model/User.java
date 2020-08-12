package com.etna.gpe.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

	  public static enum UserRole {
	        ROLE_USER,
	        ROLE_ADMIN
	    }

	    public User() {
	    }
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "user_role")
	    private UserRole role = UserRole.ROLE_USER;

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		} 
}
