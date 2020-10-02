package com.etna.gpe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.AddParticipantDto;
import com.etna.gpe.dto.EventDto;
import com.etna.gpe.dto.EventSearchResponseDto;
import com.etna.gpe.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("/search_events")
	@ResponseStatus(HttpStatus.OK)
	EventSearchResponseDto searchEvents(@RequestParam(required = false) String placeCriteria
			,@RequestParam(required = false) String titleCriteria,
			@RequestParam(required = false) String categoryCriteria, 
			@RequestParam(required = false) String descriptionCriteria, 
			@RequestParam(required = false) String eventMakerCriteria,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateCriteria1,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateCriteria2,
			@RequestParam int pageRequested) {
		return eventService.searchEvents(placeCriteria, titleCriteria, categoryCriteria,
				descriptionCriteria, eventMakerCriteria, dateCriteria1, dateCriteria2, pageRequested);
	}

	@PostMapping("/create_event")
	@ResponseStatus(HttpStatus.CREATED)
	EventDto addEvent(@RequestBody EventDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.createEventOrUpdate(dto);
	}
	
	@GetMapping("/deleted_events")
	@ResponseStatus(HttpStatus.RESET_CONTENT)
	void deletedEvent(@RequestParam int eventId) {
		eventService.deletedEvent(eventId);
	}
	
	@GetMapping("/event_id")
	@ResponseStatus(HttpStatus.OK)
	void findById(@RequestParam int eventId) {
		eventService.findById(eventId);
	}
	
	@PostMapping("/add_participant_event")
	@ResponseStatus(HttpStatus.OK)
	EventDto addParticipantToEvent(@RequestBody AddParticipantDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.addParticipantToEvent(dto);
	}
	
	@PostMapping("/remove_participant_event")
	@ResponseStatus(HttpStatus.OK)
	EventDto removeParticipantToEvent(@RequestBody AddParticipantDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.removeParticipantToEvent(dto);
	}
	
	@PostMapping("/add_organization_to_event")
	@ResponseStatus(HttpStatus.OK)
	EventDto addOrganizationAsParticipantToEvent(@RequestBody AddParticipantDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.addOrganizationAsParticipantToEvent(dto);
	}
	
	@PostMapping("/remove_organization_to_event")
	@ResponseStatus(HttpStatus.OK)
	EventDto removeOrganizationAsParticipantToEvent(@RequestBody AddParticipantDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.removeOrganizationAsParticipantToEvent(dto);
	}

}
