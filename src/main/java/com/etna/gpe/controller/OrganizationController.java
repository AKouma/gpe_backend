package com.etna.gpe.controller;

import com.etna.gpe.dto.OrganizationDto;
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
    void createOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.createOrUpdateuOrganization(organizationDto);
    }

    @GetMapping("/get_organization")
    OrganizationDto getParticularByEmail(@RequestParam(value = "email") String email) {
        return
                organizationService.getOrganizationByEmail(email);
    }

    @PostMapping("delete_organization")
    void
    deleteparticular(@RequestParam(value = "email") String email) {
        organizationService.deleteOrganization(email);
    }

}
