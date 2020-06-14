package com.etna.gpe.service;

import com.etna.gpe.dto.AuthenResponseDto;
import com.etna.gpe.dto.OrganizationDto;
import com.etna.gpe.model.Organization;
import com.etna.gpe.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    
    @Autowired
    EventService eventService;

    public List<OrganizationDto> getAllOrganization() {
        Iterator<Organization> it = organizationRepository.findAll().iterator();
        List<OrganizationDto> organizationDto = new ArrayList<>();
        while (it.hasNext()) {
            OrganizationDto dto = new OrganizationDto(it.next());
            organizationDto.add(dto);
        }
        return organizationDto;
    }

    public OrganizationDto getorganizationById(OrganizationDto dto) {
        Optional<Organization> optional = organizationRepository.findById(dto.getOrganizationId());
        return optional.map(OrganizationDto::new).orElseGet(OrganizationDto::new);
    }


    public OrganizationDto getOrganizationByEmail(@NonNull String email) {
        Organization organization = organizationRepository.getOrganizationByOrganizationEmail(email);
        return organization != null ? new OrganizationDto(organization) : new OrganizationDto();
    }

    public AuthenResponseDto getOrganizationByEmailAndPassword(@NonNull String email, @NonNull String password) {
    	AuthenResponseDto authenResponseDto = new AuthenResponseDto();
		Organization organization = organizationRepository
				.getOrganizationByOrganizationEmailAndOrganizationPassword(email, password);
		 authenResponseDto.setOrganizationDto(organization != null ? 
				 new OrganizationDto(organization) : new OrganizationDto());
		 //here we set all events that organization made
		 authenResponseDto.setEvents(eventService.getAllEventsUserMade(organization));
		 //her we set all events that organization participate  has benevols
		 //Todo
		 return authenResponseDto;
    }


    public Organization createOrUpdateuOrganization(@NonNull OrganizationDto organizationDto) {
        OrganizationDto dto = getOrganizationByEmail(organizationDto.getOrganizationEmail());
        boolean isNew = false;
        if (dto == null) {
            dto = new OrganizationDto();
            isNew = true;
        }
        setDto(organizationDto, dto);
        return organizationRepository.save(new Organization(dto, isNew));
    }

    public void deleteOrganization(@NonNull String email) {
        OrganizationDto dtoToDelete = getOrganizationByEmail(email);
        if (dtoToDelete != null) {
            dtoToDelete.setOrganizationIsDeleted(true);
            organizationRepository.save(new Organization(dtoToDelete, false));
        }
    }

    private void setDto(OrganizationDto organization, OrganizationDto dto) {
        dto.setOrganizationChiefName(organization.getOrganizationChiefName() != null ? 
        		organization.getOrganizationChiefName() : dto.getOrganizationChiefName());
        dto.setOrganizationCreateDate(organization.getOrganizationCreateDate() != null ? 
        		organization.getOrganizationCreateDate() : dto.getOrganizationCreateDate());
        dto.setOrganizationCreationDate(organization.getOrganizationCreationDate() != null ? 
        		organization.getOrganizationCreationDate() : dto.getOrganizationCreationDate());
        dto.setOrganizationDeleteDate(organization.getOrganizationDeleteDate() != null ? 
        		organization.getOrganizationDeleteDate() : dto.getOrganizationDeleteDate());
        dto.setOrganizationDescription(organization.getOrganizationDescription() != null ? 
        		organization.getOrganizationDescription() : dto.getOrganizationDescription());
        dto.setOrganizationEmail(organization.getOrganizationEmail() != null ? 
        		organization.getOrganizationEmail() : dto.getOrganizationEmail());
        dto.setOrganizationLocation(organization.getOrganizationLocation() != null ? 
        		organization.getOrganizationLocation() : dto.getOrganizationLocation());
        dto.setOrganizationLogo(organization.getOrganizationLogo() != null ? 
        		organization.getOrganizationLogo() : dto.getOrganizationLogo());
        dto.setOrganizationName(organization.getOrganizationName() != null ? 
        		organization.getOrganizationName() : dto.getOrganizationName());
        dto.setOrganizationPassword(organization.getOrganizationPassword() != null ? 
        		organization.getOrganizationPassword() : dto.getOrganizationPassword());
        dto.setOrganizationPhoneNumber(organization.getOrganizationPhoneNumber() != null ? 
        		organization.getOrganizationPhoneNumber() : dto.getOrganizationPhoneNumber());
        dto.setOrganizationUpdateDate(organization.getOrganizationUpdateDate() != null ? 
        		organization.getOrganizationUpdateDate() : dto.getOrganizationUpdateDate());
        dto.setOrganizationWebSite(organization.getOrganizationWebSite() != null ? 
        		organization.getOrganizationWebSite() : dto.getOrganizationWebSite());
        dto.setOrganizationMatricule(organization.getOrganizationMatricule() != null ?
        		organization.getOrganizationMatricule() : dto.getOrganizationMatricule());
        dto.setOrganizationChiefFirstname(organization.getOrganizationChiefFirstname() != null ? 
        		organization.getOrganizationChiefFirstname() : dto.getOrganizationChiefFirstname());
    }
}
