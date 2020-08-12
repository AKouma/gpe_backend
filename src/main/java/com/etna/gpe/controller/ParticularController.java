package com.etna.gpe.controller;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.ParticularDto;
import com.etna.gpe.service.ParticularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/particular")
public class ParticularController {

	@Autowired
	ParticularService particularService;

	@GetMapping("/all_particular")
	@ResponseStatus(HttpStatus.OK)
	List<ParticularDto> getAllParticular() {
		return particularService.getAllParticular();
	}

	@PostMapping("/create_particular")
	@ResponseStatus(HttpStatus.CREATED)
	ParticularDto createParticular(@RequestBody ParticularDto particularDto) {
		if (particularDto == null)
			throw new ParametersNotFound();
		return particularService.createOrUpdateuParticular(particularDto);
	}

	@GetMapping("/get_particular")
	@ResponseStatus(HttpStatus.OK)
	ParticularDto getParticularByEmail(@RequestParam(value = "email") String email) {
		if (email == null || email.isEmpty())
			throw new ParametersNotFound();
		return particularService.getParticularByEmail(email);
	}

	// todo post a requestbodyn and not delete really but put boolean to true
	@PostMapping("/delete_particulier")
	@ResponseStatus(HttpStatus.RESET_CONTENT)
	void deleteparticular(@RequestParam(value = "email") String email) {
		if (email == null || email.isEmpty())
			throw new ParametersNotFound();
		particularService.deleteParticular(email);
	}

}
