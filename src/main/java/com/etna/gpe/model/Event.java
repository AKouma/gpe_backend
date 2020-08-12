package com.etna.gpe.model;

import java.util.Date;

import javax.persistence.*;

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

	@Column(name = "event_title", nullable = false)
	private String eventTitle;

	@Column(name = "event_description", length = 10000, nullable = false)
	private String eventDescription;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_create_date")
	private Date eventCreateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_update_date")
	private Date eventUpdateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_delete_date")
	private Date eventDeleteDate;

	@Column(name = "event_place", nullable = false)
	private String eventPlace;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_date")
	private Date eventDate;

	@Column(name = "event_is_deleted")
	private boolean eventIsDeleted;

	@Column(name = "event_maker_email", nullable = false)
	private String eventMakerEmail;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	private Community community;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	private Category category;

	public Event(@NonNull EventDto eventDto) {
		this.setCategory(eventDto.getCategory());
		this.setCommunity(eventDto.getCommunity());
		if (eventDto.getEventCreateDate() != null)
			this.setEventCreateDate(eventDto.getEventCreateDate());
		this.setEventDate(eventDto.getEventDate());
		this.setEventDescription(eventDto.getEventDescription());
		this.setEventIsDeleted(eventDto.isEventIsDeleted());
		this.setEventMakerEmail(eventDto.getEventMakerEmail());
		this.setEventPlace(eventDto.getEventPlace());
		this.setEventTitle(eventDto.getEventTitle());
		if (eventDto.getEventUpdateDate() != null)
			this.setEventUpdateDate(eventDto.getEventUpdateDate());
	}

	protected Event() {
		// empty constructor
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventTitle=" + eventTitle + ", eventDescription=" + eventDescription
				+ ", eventCreateDate=" + eventCreateDate + ", eventUpdateDate=" + eventUpdateDate + ", eventDeleteDate="
				+ eventDeleteDate + ", eventPlace=" + eventPlace + ", eventDate=" + eventDate + ", eventIsDeleted="
				+ eventIsDeleted + ", community=" + community + ", category=" + category + ", eventMakerEmail="
				+ eventMakerEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((community == null) ? 0 : community.hashCode());
		result = prime * result + ((eventCreateDate == null) ? 0 : eventCreateDate.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventDeleteDate == null) ? 0 : eventDeleteDate.hashCode());
		result = prime * result + ((eventDescription == null) ? 0 : eventDescription.hashCode());
		result = prime * result + eventId;
		result = prime * result + (eventIsDeleted ? 1231 : 1237);
		result = prime * result + ((eventMakerEmail == null) ? 0 : eventMakerEmail.hashCode());
		result = prime * result + ((eventPlace == null) ? 0 : eventPlace.hashCode());
		result = prime * result + ((eventTitle == null) ? 0 : eventTitle.hashCode());
		result = prime * result + ((eventUpdateDate == null) ? 0 : eventUpdateDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (community == null) {
			if (other.community != null)
				return false;
		} else if (!community.equals(other.community))
			return false;
		if (eventCreateDate == null) {
			if (other.eventCreateDate != null)
				return false;
		} else if (!eventCreateDate.equals(other.eventCreateDate))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventDeleteDate == null) {
			if (other.eventDeleteDate != null)
				return false;
		} else if (!eventDeleteDate.equals(other.eventDeleteDate))
			return false;
		if (eventDescription == null) {
			if (other.eventDescription != null)
				return false;
		} else if (!eventDescription.equals(other.eventDescription))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventIsDeleted != other.eventIsDeleted)
			return false;
		if (eventMakerEmail == null) {
			if (other.eventMakerEmail != null)
				return false;
		} else if (!eventMakerEmail.equals(other.eventMakerEmail))
			return false;
		if (eventPlace == null) {
			if (other.eventPlace != null)
				return false;
		} else if (!eventPlace.equals(other.eventPlace))
			return false;
		if (eventTitle == null) {
			if (other.eventTitle != null)
				return false;
		} else if (!eventTitle.equals(other.eventTitle))
			return false;
		if (eventUpdateDate == null) {
			if (other.eventUpdateDate != null)
				return false;
		} else if (!eventUpdateDate.equals(other.eventUpdateDate))
			return false;
		return true;
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
