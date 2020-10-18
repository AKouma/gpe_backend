package com.etna.gpe.dto;

import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import com.etna.gpe.model.Community;
import com.etna.gpe.model.Event;
import com.etna.gpe.model.Organization;
import com.etna.gpe.model.Particular;

public class EventDto {

	private int eventId;
	private String eventTitle;
	private String eventDescription;
	private Date eventCreateDate;
	private Date eventUpdateDate;
	private String eventPlace;
	private Date eventDate;
	private boolean eventIsDeleted;
	private Community community;
	private CategoryDto category;
	private String categoryName;
	private String eventMakerEmail;
	private Double lng;
	private Double lat;
	private String picture;
	private List<Particular> participants;
	private List<Organization> organizationsAsParticipants;

	public EventDto() {
	}

	public EventDto(@NonNull Event event) {
		this.setCategory(new CategoryDto(event.getCategory()));
		this.setCommunity(event.getCommunity());
		this.setEventCreateDate(event.getEventCreateDate());
		this.setEventDate(event.getEventDate());
		this.setEventDescription(event.getEventDescription());
		this.setEventId(event.getEventId());
		this.setEventIsDeleted(event.isEventIsDeleted());
		this.setEventMakerEmail(event.getEventMakerEmail());
		this.setEventPlace(event.getEventPlace());
		this.setEventTitle(event.getEventTitle());
		this.setEventUpdateDate(event.getEventUpdateDate());
		this.setParticipants(event.getParticipants());
		this.setOrganizationsAsParticipants(event.getOrganizationsAsParticipants());
		this.setPicture(event.getPicture());
		this.setLng(event.getEventLongitude());
		this.setLat(event.getEventLatitude());
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

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public String getEventMakerEmail() {
		return eventMakerEmail;
	}

	public void setEventMakerEmail(String eventMakerEmail) {
		this.eventMakerEmail = eventMakerEmail;
	}

	public List<Particular> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Particular> participants) {
		if (this.participants == null || this.participants.isEmpty())
			this.participants = participants;
		else
			this.participants.addAll(participants);
	}
	
	public List<Organization> getOrganizationsAsParticipants() {
		return organizationsAsParticipants;
	}

	public void setOrganizationsAsParticipants(List<Organization> organizationsAsParticipants) {
		if (this.organizationsAsParticipants == null || this.organizationsAsParticipants.isEmpty())
			this.organizationsAsParticipants = organizationsAsParticipants;
		else
			this.organizationsAsParticipants.addAll(organizationsAsParticipants);
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double longitude) {
		this.lng = longitude;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double latitude) {
		this.lat = latitude;
	}
	
}
