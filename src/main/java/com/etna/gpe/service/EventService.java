package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.etna.gpe.controller.customexception.ServerError;
import com.etna.gpe.dto.EventDto;
import com.etna.gpe.model.Event;
import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;
import com.etna.gpe.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	public List<EventDto> getEventDtoListFromEventIterator(Iterator<Event> events) {
		List<EventDto> eventDtoList;
		if (events == null) {
			eventDtoList = null;
		} else {
			eventDtoList = new ArrayList<>();
			while (events.hasNext()) {
				EventDto dto = new EventDto(events.next());
				eventDtoList.add(dto);
			}
		}
		return eventDtoList;
	}

	public List<EventDto> getAllEventsUserMade(Object user) {
		List<EventDto> eventDto = new ArrayList<EventDto>();
		if (user instanceof Organization) {
			eventDto.addAll(toEventDtoList(
					eventRepository.getEventByEventMakerOrganization(((Organization) user).getOrganizationEmail())));
		} else if (user instanceof Particular) {
			eventDto.addAll(toEventDtoList(
					eventRepository.getEventByEventMakerParticular(((Particular) user).getParticularEmail())));
		}
		return eventDto;
	}

	private List<EventDto> toEventDtoList(List<Event> events) {
		List<EventDto> eventDto = new ArrayList<EventDto>();
		if (events != null) {
			for (Event event : events) {
				eventDto.add(new EventDto(event));
			}
		}
		return eventDto;

	}

	public EventDto createEvent(@NonNull EventDto dto) {
		EventDto eventDtoCreate = new EventDto();
		Event event = new Event(dto);
		try {
			eventDtoCreate = new EventDto(eventRepository.save(event));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			eventDtoCreate = null;
			throw new ServerError();
		}
		return eventDtoCreate;
	}

	public List<EventDto> getAllEvents() {
		Iterator<Event> events = eventRepository.findAll().iterator();
		return getEventDtoListFromEventIterator(events);
	}

}
