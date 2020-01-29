package com.etna.gpe.model;

import javax.persistence.*;

@Entity
@Table(name = "event_maker")
public class EventMaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_maker_id") 
	int eventmakerId;
	
	@ManyToOne
	@JoinColumn
	Particular particular;
	
	@ManyToOne
	@JoinColumn
	Organization organization;
	
	@Column(name = "event_maker_is_deleted")
	String eventMakerIsDeleted;

	public int getEventmakerId() {
		return eventmakerId;
	}

	public void setEventmakerId(int eventmakerId) {
		this.eventmakerId = eventmakerId;
	}

	public Particular getParticular() {
		return particular;
	}

	public void setParticular(Particular particular) {
		this.particular = particular;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getEventMakerIsDeleted() {
		return eventMakerIsDeleted;
	}

	public void setEventMakerIsDeleted(String eventMakerIsDeleted) {
		this.eventMakerIsDeleted = eventMakerIsDeleted;
	}

}
