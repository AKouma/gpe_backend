package com.etna.gpe.controller;

import com.etna.gpe.dto.OrganizationDto;
import com.etna.gpe.model.Organization;
import com.etna.gpe.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/all_organization")
    List<OrganizationDto> getAllOrganization() {
        return organizationService.getAllOrganization();
    }

    @PostMapping("/create_organization")
    Organization createOrganization(@RequestBody OrganizationDto organizationDto) {
        return organizationService.createOrUpdateuOrganization(organizationDto);
    }

    @GetMapping("/get_organization")
    OrganizationDto getParticularByEmail(@RequestParam(value = "email") String email) {
        return
                organizationService.getOrganizationByEmail(email);
    }

    //todo post a requestbodyn and not delete really but put boolean to true
    @PostMapping("delete_organization")
    void
    deleteparticular(@RequestParam(value = "email") String email) {
        organizationService.deleteOrganization(email);
    }

}
