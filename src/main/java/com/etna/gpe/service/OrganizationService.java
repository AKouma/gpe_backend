package com.etna.gpe.service;

import com.etna.gpe.config.JwtTokenUtil;
import com.etna.gpe.controller.AuthentifacationController;
import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.controller.customexception.ServerError;
import com.etna.gpe.dto.AuthenResponseDto;
import com.etna.gpe.dto.OrganizationDto;
import com.etna.gpe.model.Organization;
import com.etna.gpe.repository.OrganizationRepository;
import com.etna.gpe.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	EventService eventService;

	public List<OrganizationDto> getAllOrganization() {
		Iterator<Organization> it = organizationRepository.findAll().iterator();
		List<OrganizationDto> organizationDto = new ArrayList<>();
		while (it.hasNext()) {
			OrganizationDto dto = new OrganizationDto(it.next());
			if (!dto.isOrganizationIsDeleted())
				organizationDto.add(dto);
		}
		return organizationDto;
	}

	public OrganizationDto getorganizationById(OrganizationDto dto) {
		Optional<Organization> optional = organizationRepository.findById(dto.getOrganizationId());
		return optional.map(OrganizationDto::new).orElseGet(OrganizationDto::new);
	}

	public OrganizationDto getOrganizationByEmail(@NonNull String email, boolean isCreation) {
		Organization organization = organizationRepository.getOrganizationByOrganizationEmail(email);
		if (organization == null && !isCreation)
			throw new ResourceNotExist();
		return organization != null && !organization.isOrganizationIsDeleted() ? new OrganizationDto(organization) : null;
	}

	public AuthenResponseDto getOrganizationByEmailAndPassword(@NonNull String email, @NonNull String password) {
		AuthenResponseDto authenResponseDto = new AuthenResponseDto();
		// request account
		Organization organization = organizationRepository.getOrganizationByOrganizationEmail(email);
		// account not exist
		if (organization == null || !StringUtils.verifyHash(password, organization.getOrganizationPassword()) || organization.isOrganizationIsDeleted())
			throw new ResourceNotExist();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password,
				Collections.emptyList());
		// authenticate the user
		Authentication authentication = authenticationManager.authenticate(authRequest);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		authenResponseDto.setToken(jwtTokenUtil.generateToken(email));
		// save user unhash credentials
		AuthentifacationController.users.put(email, password);
		// convert to dto
		authenResponseDto.setOrganizationDto(new OrganizationDto(organization));
		// here we set all events that organization made
		authenResponseDto.setEvents(eventService.getAllEventsUserMade(organization));
		// her we set all events that organization participate has benevols
		authenResponseDto.setEvents(eventService.getAllEventUserParticipate(organization));
		
		return authenResponseDto;
	}

	public OrganizationDto createOrUpdateuOrganization(@NonNull OrganizationDto organizationDto) {
		OrganizationDto dto = getOrganizationByEmail(organizationDto.getOrganizationEmail(), true);
		boolean isNew = false;
		if (dto == null || dto.isOrganizationIsDeleted()) {
			dto = new OrganizationDto();
			isNew = true;
		}
		setDto(organizationDto, dto);

		dto.setOrganizationPassword(StringUtils.hashBcrypt(dto.getOrganizationPassword()));

		Organization organization = organizationRepository.save(new Organization(dto, isNew));

		if (organization == null)
			throw new ServerError();

		dto = new OrganizationDto(organization);

		return dto;
	}

	public void deleteOrganization(@NonNull String email) {
		OrganizationDto dtoToDelete = getOrganizationByEmail(email, false);
		if (dtoToDelete != null && !dtoToDelete.isOrganizationIsDeleted()) {
			dtoToDelete.setOrganizationIsDeleted(true);
			organizationRepository.save(new Organization(dtoToDelete, false));
		} else {
			throw new ResourceNotExist();
		}
	}

	private void setDto(OrganizationDto organization, OrganizationDto dto) {
		dto.setOrganizationChiefName(
				organization.getOrganizationChiefName() != null ? organization.getOrganizationChiefName()
						: dto.getOrganizationChiefName());
		dto.setOrganizationCreateDate(
				organization.getOrganizationCreateDate() != null ? organization.getOrganizationCreateDate()
						: dto.getOrganizationCreateDate());
		dto.setOrganizationCreationDate(
				organization.getOrganizationCreationDate() != null ? organization.getOrganizationCreationDate()
						: dto.getOrganizationCreationDate());
		dto.setOrganizationDescription(
				organization.getOrganizationDescription() != null ? organization.getOrganizationDescription()
						: dto.getOrganizationDescription());
		dto.setOrganizationEmail(organization.getOrganizationEmail() != null ? organization.getOrganizationEmail()
				: dto.getOrganizationEmail());
		dto.setOrganizationLocation(
				organization.getOrganizationLocation() != null ? organization.getOrganizationLocation()
						: dto.getOrganizationLocation());
		dto.setOrganizationLogo(organization.getOrganizationLogo() != null ? organization.getOrganizationLogo()
				: dto.getOrganizationLogo());
		dto.setOrganizationName(organization.getOrganizationName() != null ? organization.getOrganizationName()
				: dto.getOrganizationName());
		dto.setOrganizationPassword(
				organization.getOrganizationPassword() != null ? organization.getOrganizationPassword()
						: dto.getOrganizationPassword());
		dto.setOrganizationPhoneNumber(
				organization.getOrganizationPhoneNumber() != null ? organization.getOrganizationPhoneNumber()
						: dto.getOrganizationPhoneNumber());
		dto.setOrganizationUpdateDate(
				organization.getOrganizationUpdateDate() != null ? organization.getOrganizationUpdateDate()
						: dto.getOrganizationUpdateDate());
		dto.setOrganizationWebSite(organization.getOrganizationWebSite() != null ? organization.getOrganizationWebSite()
				: dto.getOrganizationWebSite());
		dto.setOrganizationMatricule(
				organization.getOrganizationMatricule() != null ? organization.getOrganizationMatricule()
						: dto.getOrganizationMatricule());
		dto.setOrganizationChiefFirstname(
				organization.getOrganizationChiefFirstname() != null ? organization.getOrganizationChiefFirstname()
						: dto.getOrganizationChiefFirstname());
	}
}
