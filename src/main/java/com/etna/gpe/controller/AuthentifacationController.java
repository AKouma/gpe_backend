package com.etna.gpe.controller;

import com.etna.gpe.dto.OrganizationDto;
import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.service.OrganizationService;
import com.etna.gpe.service.ParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authen")
public class AuthentifacationController {

    @Autowired
    ParticularService particularService;
    
    @Autowired
    OrganizationService organizationService;

    @GetMapping("/login_organization")
    OrganizationDto loginOrganization(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        return
                organizationService.getOrganizationByEmailAndPassword(email, password);
    }

    @GetMapping("/login_particular")
    ParticularDto loginParticular(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        return
                particularService.getParticularByEmailAndPassword(email, password);
    }
}
