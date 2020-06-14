package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.etna.gpe.dto.EventDto;

@Entity
@Table(name = "event")
public class Event {

	
	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	
	@NotBlank
	@Column(name ="event_title")
	private String eventTitle;
	
	@NotBlank
	@Column(name ="event_description")
	private String eventDescription;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name ="event_create_date")
	private Date eventCreateDate;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name ="event_update_date")
	private Date eventUpdateDate;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name ="event_delete_date")
	private Date eventDeleteDate;
	
	@NotBlank
	@Column(name ="event_place")
	private String eventPlace;
	
	@NotBlank
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name ="event_date")
	private Date eventDate;
	
	@Column(name ="event_is_deleted")
	private boolean eventIsDeleted;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn
	private EventMaker eventMaker;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn
	private Community community;
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn
	private Category category;
	
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

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventTitle=" + eventTitle + ", eventDescription=" + eventDescription
				+ ", eventCreateDate=" + eventCreateDate + ", eventUpdateDate=" + eventUpdateDate + ", eventDeleteDate="
				+ eventDeleteDate + ", eventPlace=" + eventPlace + ", eventDate=" + eventDate + ", eventIsDeleted="
				+ eventIsDeleted + ", eventMaker=" + eventMaker + ", community=" + community + ", category=" + category
				+ "]";
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

	public Date getEventDeleteDate() {
		return eventDeleteDate;
	}

	public void setEventDeleteDate(Date eventDeleteDate) {
		this.eventDeleteDate = eventDeleteDate;
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
