package com.etna.gpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.dto.EventDto;
import com.etna.gpe.repository.EventMakerRepository;
import com.etna.gpe.repository.EventRepository;
import com.etna.gpe.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	EventMakerRepository eventMakerRepository;

	@Autowired
	EventService eventService;

	@GetMapping("all_events")
	@ResponseStatus(HttpStatus.OK)
	List<EventDto> getAllEvents() {
		return eventService.getAllEvents();
	}

	// have to test have to replace eventdate to string
	@PostMapping("create_event")
	@ResponseStatus(HttpStatus.CREATED)
	EventDto addEvent(@RequestBody EventDto dto) {
		if (dto == null)
			throw new ParametersNotFound();
		
		return eventService.createEvent(dto);
	}

}
