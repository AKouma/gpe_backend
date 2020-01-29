package com.etna.gpe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.etna.gpe.dto.EventDto;

@Entity
@Table(name = "event")
public class Event {

	
	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int eventId;
	
	@NotBlank
	@Column(name ="event_title")
	String eventTitle;
	
	@NotBlank
	@Column(name ="event_description")
	String eventDescription;
	
	@Column(name ="event_create_date")
	String eventCreateDate;
	
	@Column(name ="event_update_date")
	String eventUpdateDate;
	
	@Column(name ="event_delete_date")
	String eventDeleteDate;
	
	@NotBlank
	@Column(name ="event_place")
	String eventPlace;
	
	@NotBlank
	@Column(name ="event_date")
	String eventDate;
	
	@Column(name ="event_is_deleted")
	boolean eventIsDeleted;
	
	@ManyToOne
	@JoinColumn
	EventMaker eventMaker;
	
	@ManyToOne
	@JoinColumn
	Community community;
	
	@ManyToOne
	@JoinColumn
	Category category;
	
	public Event(@NonNull EventDto eventDto) {
		this.setCategory(eventDto.getCategory());
		this.setCommunity(eventDto.getCommunity());
		this.setEventCreateDate(eventDto.getEventCreateDate());
		this.setEventDate(eventDto.getEventDate());
		this.setEventDeleteDate(eventDto.getEventDeleteDate());
		this.setEventDescription(eventDto.getEventDescription());
		this.setEventId(eventDto.getEventId());
		this.setEventIsDeleted(eventDto.isEventIsDeleted());
		this.setEventMaker(eventDto.getEventMaker());
		this.setEventPlace(eventDto.getEventPlace());
		this.setEventTitle(eventDto.getEventTitle());
		this.setEventUpdateDate(eventDto.getEventUpdateDate());
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventCreateDate() {
		return eventCreateDate;
	}

	public void setEventCreateDate(String eventCreateDate) {
		this.eventCreateDate = eventCreateDate;
	}

	public String getEventUpdateDate() {
		return eventUpdateDate;
	}

	public void setEventUpdateDate(String eventUpdateDate) {
		this.eventUpdateDate = eventUpdateDate;
	}

	public String getEventDeleteDate() {
		return eventDeleteDate;
	}

	public void setEventDeleteDate(String eventDeleteDate) {
		this.eventDeleteDate = eventDeleteDate;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public boolean isEventIsDeleted() {
		return eventIsDeleted;
	}

	public void setEventIsDeleted(boolean eventIsDeleted) {
		this.eventIsDeleted = eventIsDeleted;
	}

	public EventMaker getEventMaker() {
		return eventMaker;
	}

	public void setEventMaker(EventMaker eventMaker) {
		this.eventMaker = eventMaker;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
