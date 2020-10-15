package com.etna.gpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.MessageDto;
import com.etna.gpe.service.Tchatservice;

@RestController
@RequestMapping("/messaging")
public class TchatController {
	
	
	@Autowired
	Tchatservice tchatservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	List<MessageDto> addMessage(@RequestBody MessageDto messageDto) {
		if (messageDto == null)
			throw new ParametersNotFound();
		return tchatservice.addMessage(messageDto);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<MessageDto> addMessage(@RequestParam int communityId) {
		if (communityId < 0)
			throw new ParametersNotFound();
		return tchatservice.allMessage(communityId);
	} 

	/*
	 * @GetMapping
	 * 
	 * @ResponseStatus(HttpStatus.OK) ParticularDto
	 * getParticularByEmail(@RequestParam(value = "email") String email) { if (email
	 * == null || email.isEmpty()) throw new ParametersNotFound(); return
	 * particularService.getParticularByEmail(email); }
	 * 
	 * @GetMapping
	 * 
	 * @ResponseStatus(HttpStatus.RESET_CONTENT) void
	 * deleteparticular(@RequestParam(value = "email") String email) { if (email ==
	 * null || email.isEmpty()) throw new ParametersNotFound();
	 * particularService.deleteParticular(email); }
	 */

}
