package com.etna.gpe.controller;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.AuthenDto;
import com.etna.gpe.dto.AuthenResponseDto;
import com.etna.gpe.service.OrganizationService;
import com.etna.gpe.service.ParticularService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authen")
public class AuthentifacationController {
	
	public static HashMap<String, String> users = new HashMap<String, String>();
	
    @Autowired
    ParticularService particularService;
    
    @Autowired
    OrganizationService organizationService;

    
    @PostMapping("/login_organization")
    @ResponseStatus(HttpStatus.OK)
    AuthenResponseDto loginOrganization(@RequestBody AuthenDto authenDto) {
    	if(authenDto == null || authenDto.getEmail() == null || authenDto.getPassword() == null )
    		  throw new ParametersNotFound();
        return
                organizationService.getOrganizationByEmailAndPassword(authenDto.getEmail(), authenDto.getPassword());
    }

    @PostMapping("/login_particular")
    @ResponseStatus(HttpStatus.OK)
    AuthenResponseDto loginParticular(@RequestBody AuthenDto authenDto) {
    	if(authenDto == null || authenDto.getEmail() == null || authenDto.getPassword() == null )
    		throw new ParametersNotFound();
        return
        		particularService.getParticularByEmailAndPassword(authenDto.getEmail(), authenDto.getPassword());
    }
}
