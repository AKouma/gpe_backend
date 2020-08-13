package com.etna.gpe.controller;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.OrganizationDto;
import com.etna.gpe.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/all_organization")
    @ResponseStatus(HttpStatus.OK)
    List<OrganizationDto> getAllOrganization() {
        return organizationService.getAllOrganization();
    }

    @PostMapping("/create_organization")
    @ResponseStatus(HttpStatus.CREATED)
    OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto) {
    	if(organizationDto == null)
    		throw new ParametersNotFound();
        return organizationService.createOrUpdateuOrganization(organizationDto);
    }

    @GetMapping("/get_organization")
    @ResponseStatus(HttpStatus.OK)
    OrganizationDto getOrganizationByEmail(@RequestParam(value = "email") String email) {
    	if(email.isEmpty() || email == null)
    		throw new ParametersNotFound();
        return organizationService.getOrganizationByEmail(email, false);
    }

    @GetMapping("delete_organization")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    void deleteparticular(@RequestParam(value = "email") String email) {
    	if(email.isEmpty() || email == null)
    		throw new ParametersNotFound();
        organizationService.deleteOrganization(email);
    }

}
