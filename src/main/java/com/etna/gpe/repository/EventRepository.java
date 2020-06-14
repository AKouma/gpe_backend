package com.etna.gpe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.etna.gpe.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("select e from Event e where e.eventTitle like title")
	List<Event> searchEventByEventTitle(String title);
	
	@Query("select e from Event e where e.eventDate =:eventDate") 
	List<Event>searchEventByEventDate(Date eventDate);
	 
	@Query("select e from Event e where e.eventPlace =:eventPlace")
	List<Event> searchEventByEventPlace(String eventPlace);
	
	@Query("select e from Event e where e.category.categoryName =:categoryName")
	List<Event> searchEventByEventCategory(String categoryName);
	
	@Query("select e from Event e where e.eventMaker.particular.particularEmail =:particularEmail")
	List<Event> getEventByEventMakerParticular(String particularEmail);
	
	@Query("select e from Event e where e.eventMaker.organization.organizationEmail =:organizationEmail")
	List<Event> getEventByEventMakerOrganization(String organizationEmail);

}
