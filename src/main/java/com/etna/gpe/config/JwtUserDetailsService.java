package com.etna.gpe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.etna.gpe.dto.JwtUserDetails;
import com.etna.gpe.model.Particular;
import com.etna.gpe.model.User;
import com.etna.gpe.repository.OrganizationRepository;
import com.etna.gpe.repository.ParticularRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	 @Autowired
	    private ParticularRepository particularRepository;
	 
	 @Autowired
	    private OrganizationRepository organizationRepository;

	@Override
	public JwtUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = null;
		Particular particular = particularRepository.findParticularByParticularEmail(email);
		if(particular == null)
			user = organizationRepository.getOrganizationByOrganizationEmail(email);
		else
			user = particular;
		
		return user != null ? new JwtUserDetails(user) : null;
	}

}
