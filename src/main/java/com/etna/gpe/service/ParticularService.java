package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.etna.gpe.config.JwtTokenUtil;
import com.etna.gpe.controller.AuthentifacationController;
import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.controller.customexception.ServerError;
import com.etna.gpe.dto.AuthenResponseDto;
import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.model.Particular;
import com.etna.gpe.repository.ParticularRepository;
import com.etna.gpe.utils.StringUtils;

@Service
public class ParticularService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	ParticularRepository particularRepository;

	@Autowired
	EventService eventService;

	public List<ParticularDto> getAllParticular() {
		Iterator<Particular> it = particularRepository.findAll().iterator();
		List<ParticularDto> particulars = new ArrayList<>();
		while (it.hasNext()) {
			ParticularDto dto = new ParticularDto(it.next());
			particulars.add(dto);
		}
		return particulars;
	}

	public ParticularDto getparticularById(ParticularDto dto) {
		Optional<Particular> optional = particularRepository.findById(dto.getParticularId());
		// resource not exist
		if (optional == null)
			throw new ResourceNotExist();

		return optional.map(ParticularDto::new).orElseGet(ParticularDto::new);
	}

	public ParticularDto getParticularByEmail(@NonNull String email) {
		Particular particular = particularRepository.findParticularByParticularEmail(email);
		// resource not exist
		if (particular == null)
			throw new ResourceNotExist();

		return new ParticularDto(particular);
	}

	public AuthenResponseDto getParticularByEmailAndPassword(@NonNull String email, @NonNull String password) {
		AuthenResponseDto authenResponseDto = new AuthenResponseDto();
		Particular particular = particularRepository.findParticularByParticularEmail(email);
		// resource not exist
		if (particular == null || !StringUtils.verifyHash(password, particular.getParticularPassword()))
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
		authenResponseDto.setParticularDto(new ParticularDto(particular));
		// here we set all events that organization made
		authenResponseDto.setEvents(eventService.getAllEventsUserMade(particular));
		// her we set all events that organization participate has benevols
		// Todo
		return authenResponseDto;
	}

	public ParticularDto createOrUpdateuParticular(@NonNull ParticularDto particularDto) {
		boolean isNew = false;
		ParticularDto dto = null;

		try {
			dto = getParticularByEmail(particularDto.getParticularEmail());
		} catch (ResourceNotExist e) {
			// new account
			if (dto == null) {
				dto = new ParticularDto();
				isNew = true;
			}
		}
		setDto(particularDto, dto);

		dto.setParticularPassword(StringUtils.hashBcrypt(dto.getParticularPassword()));

		Particular particular = particularRepository.save(new Particular(dto, isNew));

		if (particular == null)
			throw new ServerError();

		dto = new ParticularDto(particular);
		return dto;
	}

	public void deleteParticular(@NonNull String email) {
		ParticularDto dtoToDelete = getParticularByEmail(email);
		if (dtoToDelete != null) {
			dtoToDelete.setParticularIsDeleted(true);
			particularRepository.save(new Particular(dtoToDelete, false));
		} else {
			throw new ResourceNotExist();
		}
	}

	private void setDto(@NonNull ParticularDto particularDto, ParticularDto dto) {
		dto.setParticularEmail(particularDto.getParticularEmail());
		dto.setParticularPassword(particularDto.getParticularPassword());
		dto.setParticularPhonenumber(
				particularDto.getParticularPhonenumber() != null ? particularDto.getParticularPhonenumber()
						: dto.getParticularPhonenumber());
		dto.setParticularLocation(particularDto.getParticularLocation() != null ? particularDto.getParticularLocation()
				: dto.getParticularLocation());
		dto.setParticularName(particularDto.getParticularName() != null ? particularDto.getParticularName()
				: dto.getParticularName());
		dto.setParticularFirstName(
				particularDto.getParticularFirstName() != null ? particularDto.getParticularFirstName()
						: dto.getParticularFirstName());
	}

}
