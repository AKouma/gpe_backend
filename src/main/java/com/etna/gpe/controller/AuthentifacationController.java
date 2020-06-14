package com.etna.gpe.controller;

import com.etna.gpe.dto.AuthenDto;
import com.etna.gpe.dto.AuthenResponseDto;
import com.etna.gpe.service.OrganizationService;
import com.etna.gpe.service.ParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authen")
public class AuthentifacationController {

    @Autowired
    ParticularService particularService;
    
    @Autowired
    OrganizationService organizationService;

    @PostMapping("/login_organization")
    AuthenResponseDto loginOrganization(@RequestBody AuthenDto authenDto) {
    	if(authenDto == null || authenDto.getEmail() == null || authenDto.getPassword() == null )
    		return null; // have to return miss paramters exception
        return
                organizationService.getOrganizationByEmailAndPassword(authenDto.getEmail(), authenDto.getPassword());
    }

    @PostMapping("/login_particular")
    AuthenResponseDto loginParticular(@RequestBody AuthenDto authenDto) {
    	if(authenDto == null || authenDto.getEmail() == null || authenDto.getPassword() == null )
    		return null; // have to return miss paramters exception
        return
        		particularService.getParticularByEmailAndPassword(authenDto.getEmail(), authenDto.getPassword());
    }
}
