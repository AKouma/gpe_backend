package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.controller.customexception.ServerError;
import com.etna.gpe.dto.AddParticipantDto;
import com.etna.gpe.dto.EventDto;
import com.etna.gpe.model.Community;
import com.etna.gpe.model.Event;
import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;
import com.etna.gpe.repository.EventRepository;
import com.etna.gpe.repository.OrganizationRepository;
import com.etna.gpe.repository.ParticularRepository;
import com.etna.gpe.utils.DateUtils;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	ParticularRepository participantRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;

	public List<EventDto> getEventDtoListFromEventIterator(Iterator<Event> events) {
		List<EventDto> eventDtoList;
		if (events == null) {
			eventDtoList = null;
		} else {
			eventDtoList = new ArrayList<>();
			while (events.hasNext()) {
				EventDto dto = new EventDto(events.next());
				if (!dto.isEventIsDeleted())
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
	
	public List<EventDto> getAllEventUserParticipate(Object user){
		List<EventDto> eventDto = getEventDtoListFromEventIterator(eventRepository.findAll().iterator());
		if (user instanceof Particular) {
			eventDto.addAll(eventDto.stream().filter(e -> e.getParticipants()
					.contains((Particular) user)).collect(Collectors.toList()));
		} else if (user instanceof Organization) {
			eventDto.addAll(eventDto.stream().filter(e -> e.getOrganizationsAsParticipants()
					.contains((Organization) user)).collect(Collectors.toList()));
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

	public EventDto createEventOrUpdate(@NonNull EventDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		if (event == null) {
			event = new Event(dto);
			Community community = new Community();
			community.setCommunityAdmin(dto.getEventMakerEmail());
			event.setCommunity(community);
		}

		try {
			event = eventRepository.save(event);
			if (event == null)
				throw new ServerError();

			dto = new EventDto(event);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			dto = null;
			throw new ServerError();
		}
		return dto;
	}

	public List<EventDto> searchEvents(String criteria) {
		List<EventDto> eventFound = new ArrayList<>();
		Iterator<Event> events = eventRepository.findAll().iterator();

		if (criteria == null || criteria.isEmpty())
			eventFound.addAll(getEventDtoListFromEventIterator(events));
		else {
			try {
				// find by ID
				int idToFind = Integer.parseInt(criteria);
				EventDto dtoById = new EventDto(eventRepository.findById(idToFind).get());
				eventFound.add(dtoById);
			} catch (NumberFormatException exception) {
				System.err.print("search by criteria");
				// get all events into list
				List<Event> eventList = new ArrayList<>();
				events.forEachRemaining(eventList::add);

				// search by event title
				List<Event> eventByTitle = eventList.stream().filter(e -> criteria.equalsIgnoreCase(e.getEventTitle())
						&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate())).collect(Collectors.toList());

				// search by event place
				List<Event> eventByPlace = eventList.stream().filter(e -> criteria.equalsIgnoreCase(e.getEventPlace())
						&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate())).collect(Collectors.toList());

				// search by event category
				List<Event> eventByCategory = eventList.stream()
						.filter(e -> criteria.equalsIgnoreCase(e.getCategory().getCategoryName())
								&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());

				// search by event date
				List<Event> eventByDate = eventList.stream()
						.filter(e -> !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());

				// search by event Description
				List<Event> eventByDescription = eventList.stream()
						.filter(e -> e.getEventDescription().contains(criteria) && !e.isEventIsDeleted()
								&& DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());

				// search by event Event maker mail
				List<Event> eventByEventMakerMail = eventList.stream()
						.filter(e -> criteria.equalsIgnoreCase(e.getEventMakerEmail()) && !e.isEventIsDeleted()
								&& DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());

				if (eventByTitle != null && !eventByTitle.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByTitle));
				}

				if (eventByPlace != null && !eventByPlace.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByPlace));
				}

				if (eventByCategory != null && !eventByCategory.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByCategory));
				}

				if (eventByDate != null && !eventByDate.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByDate));
				}

				if (eventByDescription != null && !eventByDescription.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByDescription));
				}

				if (eventByEventMakerMail != null && !eventByEventMakerMail.isEmpty()) {
					eventFound.addAll(toEventDtoList(eventByEventMakerMail));
				}
			}
		}
		return eventFound;
	}

	public void deletedEvent(int eventId) {
		Event eventToDelete = eventRepository.findById(eventId).get();
		if(eventToDelete == null)
			throw new ResourceNotExist();
		
		eventToDelete.setEventIsDeleted(true);
		eventRepository.save(eventToDelete);
	}

	public EventDto addParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Particular particular = participantRepository.findParticularByParticularEmail(dto.getParticipantEmail());
		if(event == null || event.isEventIsDeleted() || particular == null || particular.isParticularIsDeleted())
			throw new ResourceNotExist();
		
		List<Particular> participants = new ArrayList<Particular>();
		participants.add(particular);
		event.setParticipants(participants);
		eventRepository.save(event);
		
		EventDto eventDto = new EventDto(event);
		
		return eventDto;
	}

	public EventDto removeParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Particular particular = participantRepository.findParticularByParticularEmail(dto.getParticipantEmail());
		if(event == null || event.isEventIsDeleted() || particular == null || particular.isParticularIsDeleted())
			throw new ResourceNotExist();
		
		List<Particular> participants = event.getParticipants();
		participants.remove(particular);
		//reset participant list
		event.setParticipants(null);
		//add participants
		event.setParticipants(participants);
		eventRepository.save(event);
		
		EventDto eventDto = new EventDto(event);
		
		return eventDto;
	}

	public EventDto addOrganizationAsParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Organization organization = organizationRepository.getOrganizationByOrganizationEmail(dto.getParticipantEmail());
		if(event == null || event.isEventIsDeleted() || organization == null || organization.isOrganizationIsDeleted())
			throw new ResourceNotExist();
		
		List<Organization> organizations = new ArrayList<Organization>();
		organizations.add(organization);
		event.setOrganizationsAsParticipants(organizations);
		eventRepository.save(event);
		
		EventDto eventDto = new EventDto(event);
		
		return eventDto;
	}

	public EventDto removeOrganizationAsParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Organization organization = organizationRepository.getOrganizationByOrganizationEmail(dto.getParticipantEmail());
		if(event == null || event.isEventIsDeleted() || organization == null || organization.isOrganizationIsDeleted())
			throw new ResourceNotExist();
		
		List<Organization> organizations = event.getOrganizationsAsParticipants();
		organizations.remove(organization);
		//reset participant list
		event.setOrganizationsAsParticipants(null);
		//add participants
		event.setOrganizationsAsParticipants(organizations);
		eventRepository.save(event);
		
		EventDto eventDto = new EventDto(event);
		
		return eventDto;
	}

}
