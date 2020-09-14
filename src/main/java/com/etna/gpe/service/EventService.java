package com.etna.gpe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.etna.gpe.controller.customexception.ParametersNotFound;
import com.etna.gpe.controller.customexception.ResourceNotExist;
import com.etna.gpe.controller.customexception.ServerError;
import com.etna.gpe.dto.AddParticipantDto;
import com.etna.gpe.dto.CategoryDto;
import com.etna.gpe.dto.EventDto;
import com.etna.gpe.dto.EventSearchResponseDto;
import com.etna.gpe.dto.HomeDto;
import com.etna.gpe.model.Category;
import com.etna.gpe.model.Community;
import com.etna.gpe.model.Event;
import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;
import com.etna.gpe.model.User;
import com.etna.gpe.pager.Pager;
import com.etna.gpe.repository.CategoryRepository;
import com.etna.gpe.repository.EventRepository;
import com.etna.gpe.repository.OrganizationRepository;
import com.etna.gpe.repository.ParticularRepository;
import com.etna.gpe.utils.DateUtils;
import com.etna.gpe.utils.StringUtils;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	ParticularRepository participantRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	CategoryRepository categoryRepository;

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

	public List<EventDto> getAllEventsUserMade(User user) {
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

	public List<EventDto> getAllEventUserParticipate(User user) {
		List<EventDto> eventDto = getEventDtoListFromEventIterator(eventRepository.findAll().iterator());
		List<EventDto> result = new ArrayList<>();
		if (user instanceof Particular) {
			result.addAll(eventDto.stream().filter(e -> e.getParticipants().contains((Particular) user))
					.collect(Collectors.toList()));
		} else if (user instanceof Organization) {
			result.addAll(
					eventDto.stream().filter(e -> e.getOrganizationsAsParticipants().contains((Organization) user))
							.collect(Collectors.toList()));
		}
		return result;
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
		Event event = null;

		try {
			event = eventRepository.findById(dto.getEventId()).get();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (event == null) {

				Category category = categoryRepository.findCategoryByCategoryName(dto.getCategoryName());
				if (category == null)
					throw new ParametersNotFound();

				CategoryDto categoryDto = new CategoryDto(category);
				dto.setCategory(categoryDto);

				event = new Event(dto);
				Community community = new Community();
				community.setCommunityAdmin(dto.getEventMakerEmail());
				event.setCommunity(community);
			}
			event = eventRepository.save(event);
			if (event == null)
				throw new ServerError();

			dto = new EventDto(event);
			dto.setCategoryName(event.getCategory().getCategoryName());
		}
		return dto;
	}

	public EventSearchResponseDto searchEvents(String placeCriteria, String titleCriteria, String categoryCriteria,
			String descriptionCriteria, String eventMakerCriteria, Date dateCriteria1, Date dateCriteria2,
			int pageRequested) {

		int totalPage = 0;
		EventSearchResponseDto response = new EventSearchResponseDto();
		List<EventDto> eventFound = new ArrayList<>();
		Iterator<Event> events = eventRepository.findAll(Pager.getEventPageable(pageRequested)).iterator();

		if (StringUtils.isEmptyOrNull(placeCriteria) && StringUtils.isEmptyOrNull(titleCriteria)
				&& StringUtils.isEmptyOrNull(categoryCriteria) && StringUtils.isEmptyOrNull(descriptionCriteria)
				&& StringUtils.isEmptyOrNull(eventMakerCriteria) && dateCriteria1 == null && dateCriteria2 == null) {

			eventFound.addAll(getEventDtoListFromEventIterator(events));
			// filter activate events
			eventFound = eventFound.stream().filter(e -> !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
					.collect(Collectors.toList());
		} else {
			// get all events into list
			List<Event> eventList = new ArrayList<>();
			events.forEachRemaining(eventList::add);

			// search by event title
			if (titleCriteria != null && !titleCriteria.isEmpty()) {
				eventList = eventList.stream().filter(e -> titleCriteria.equalsIgnoreCase(e.getEventTitle())
						&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate())).collect(Collectors.toList());
			}

			// search by event place
			if (placeCriteria != null && !placeCriteria.isEmpty()) {
				eventList = eventList.stream().filter(e -> placeCriteria.equalsIgnoreCase(e.getEventPlace())
						&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate())).collect(Collectors.toList());
			}

			// search by event category
			if (categoryCriteria != null && !categoryCriteria.isEmpty()) {
				eventList = eventList.stream()
						.filter(e -> categoryCriteria.equalsIgnoreCase(e.getCategory().getCategoryName())
								&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());
			}

			// search by event date
			if (dateCriteria1 != null) {
				eventList = eventList.stream()
						.filter(e -> !e.isEventIsDeleted()
								&& DateUtils.isEligibled(dateCriteria1, dateCriteria2, e.getEventDate())
								&& DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());
			}

			// search by event Description
			if (descriptionCriteria != null && !descriptionCriteria.isEmpty()) {
				eventList = eventList
						.stream().filter(e -> e.getEventDescription().contains(descriptionCriteria)
								&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());
			}

			// search by event Event maker mail
			if (eventMakerCriteria != null && !eventMakerCriteria.isEmpty()) {
				eventList = eventList.stream()
						.filter(e -> eventMakerCriteria.equalsIgnoreCase(e.getEventMakerEmail())
								&& !e.isEventIsDeleted() && DateUtils.isOnline(e.getEventDate()))
						.collect(Collectors.toList());
			}
			if (eventList != null && !eventList.isEmpty()) {
				eventFound.addAll(toEventDtoList(eventList));
			}
		}
		totalPage = getNumberOfPage(eventFound);
		response.setEvents(eventFound);
		response.setTotalPage(totalPage);

		return response;
	}

	public void deletedEvent(int eventId) {
		Event eventToDelete = eventRepository.findById(eventId).get();
		if (eventToDelete == null)
			throw new ResourceNotExist();

		eventToDelete.setEventIsDeleted(true);
		eventRepository.save(eventToDelete);
	}

	public EventDto findById(int id) {
		Event event = eventRepository.findById(id).get();
		if (event == null || event.isEventIsDeleted())
			throw new ResourceNotExist();

		return new EventDto(event);
	}

	public EventDto addParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Particular particular = participantRepository.findParticularByParticularEmail(dto.getParticipantEmail());
		if (event == null || event.isEventIsDeleted() || particular == null || particular.isParticularIsDeleted())
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
		if (event == null || event.isEventIsDeleted() || particular == null || particular.isParticularIsDeleted())
			throw new ResourceNotExist();

		List<Particular> participants = event.getParticipants();
		participants.remove(particular);
		// reset participant list
		event.setParticipants(null);
		// add participants
		event.setParticipants(participants);
		eventRepository.save(event);

		EventDto eventDto = new EventDto(event);

		return eventDto;
	}

	public EventDto addOrganizationAsParticipantToEvent(AddParticipantDto dto) {
		Event event = eventRepository.findById(dto.getEventId()).get();
		Organization organization = organizationRepository
				.getOrganizationByOrganizationEmail(dto.getParticipantEmail());
		if (event == null || event.isEventIsDeleted() || organization == null || organization.isOrganizationIsDeleted())
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
		Organization organization = organizationRepository
				.getOrganizationByOrganizationEmail(dto.getParticipantEmail());
		if (event == null || event.isEventIsDeleted() || organization == null || organization.isOrganizationIsDeleted())
			throw new ResourceNotExist();

		List<Organization> organizations = event.getOrganizationsAsParticipants();
		organizations.remove(organization);
		// reset participant list
		event.setOrganizationsAsParticipants(null);
		// add participants
		event.setOrganizationsAsParticipants(organizations);
		eventRepository.save(event);

		EventDto eventDto = new EventDto(event);

		return eventDto;
	}

	private int getNumberOfPage(List<EventDto> list) {
		int quotient = list.size() / 15; // each page requires at most 15 elements
		return list.size() % 15 > 0 ? quotient + 1 : quotient;
	}
	
	
    //todo : have to optimize by using sql
	public HomeDto getHomeInfo() {
		HomeDto homeDto = new HomeDto();
		
		List<Event> eventNumberList	= new ArrayList<Event>();
		eventRepository.findAll().iterator().forEachRemaining(
				e-> {
					if(!e.isEventIsDeleted())
						eventNumberList.add(e);
					});
		
		List<Particular> particularNumberList = new ArrayList<Particular>();
		participantRepository.findAll().iterator().forEachRemaining(p->{
				if(!p.isParticularIsDeleted())
				particularNumberList.add(p);
				});
		
		List<Organization> organizationNumberList = new ArrayList<Organization>();
		organizationRepository.findAll().iterator().forEachRemaining(o->
				{
					if(!o.isOrganizationIsDeleted())
						organizationNumberList.add(o);
				});
		
		homeDto.setEventNumber(eventNumberList.size());
		homeDto.setOrganizationNumber(organizationNumberList.size());
		homeDto.setParticularNumber(particularNumberList.size());
		
		return homeDto;
	}

}
