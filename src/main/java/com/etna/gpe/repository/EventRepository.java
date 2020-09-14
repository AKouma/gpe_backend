package com.etna.gpe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.etna.gpe.model.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {

	@Query("select e from Event e where e.eventTitle like title")
	List<Event> searchEventByEventTitle(String title);

	@Query("select e from Event e where e.eventDate =:eventDate")
	List<Event> searchEventByEventDate(Date eventDate);

	@Query("select e from Event e where e.eventPlace =:eventPlace")
	List<Event> searchEventByEventPlace(String eventPlace);

	@Query("select e from Event e where e.category.categoryName =:categoryName")
	List<Event> searchEventByEventCategory(String categoryName);

	@Query("select e from Event e where e.eventMakerEmail =:particularEmail")
	List<Event> getEventByEventMakerParticular(String particularEmail);

	@Query("select e from Event e where e.eventMakerEmail =:organizationEmail")
	List<Event> getEventByEventMakerOrganization(String organizationEmail);
}
