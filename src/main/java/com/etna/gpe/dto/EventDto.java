package com.etna.gpe.dto;

import java.util.Date;


import org.springframework.lang.NonNull;

import com.etna.gpe.model.Category;
import com.etna.gpe.model.Community;
import com.etna.gpe.model.Event;

public class EventDto {
	
	int eventId;
	String eventTitle;
	String eventDescription;
	Date eventCreateDate;
	Date eventUpdateDate;
	String eventPlace;
	Date eventDate;
	boolean eventIsDeleted;
	Community community;
	Category category;
	String eventMakerEmail;
	
	

	public EventDto() {
	}
	
	public EventDto(@NonNull Event event) {
		//this.setCategory(event.getCategory());
	//	this.setCommunity(event.getCommunity());
		this.setEventCreateDate(event.getEventCreateDate());
		this.setEventDate(event.getEventDate());
		this.setEventDescription(event.getEventDescription());
		this.setEventId(event.getEventId());
		this.setEventIsDeleted(event.isEventIsDeleted());
		this.setEventMakerEmail(event.getEventMakerEmail());
		this.setEventPlace(event.getEventPlace());
		this.setEventTitle(event.getEventTitle());
		this.setEventUpdateDate(event.getEventUpdateDate());
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

	public Date getEventCreateDate() {
		return eventCreateDate;
	}

	public void setEventCreateDate(Date eventCreateDate) {
		this.eventCreateDate = eventCreateDate;
	}

	public Date getEventUpdateDate() {
		return eventUpdateDate;
	}

	public void setEventUpdateDate(Date eventUpdateDate) {
		this.eventUpdateDate = eventUpdateDate;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public boolean isEventIsDeleted() {
		return eventIsDeleted;
	}

	public void setEventIsDeleted(boolean eventIsDeleted) {
		this.eventIsDeleted = eventIsDeleted;
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

	public String getEventMakerEmail() {
		return eventMakerEmail;
	}

	public void setEventMakerEmail(String eventMakerEmail) {
		this.eventMakerEmail = eventMakerEmail;
	}
}
