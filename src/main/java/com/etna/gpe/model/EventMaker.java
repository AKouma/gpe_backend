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
	Particular particular;
	
	@ManyToOne
	Organization organization;
	
	@Column(name = "event_maker_is_deleted")
	boolean eventMakerIsDeleted = false;
	
	public EventMaker() {}
	
	

	@Override
	public String toString() {
		return "EventMaker [eventmakerId=" + eventmakerId + ", particular=" + particular + ", organization="
				+ organization + ", eventMakerIsDeleted=" + eventMakerIsDeleted + "]";
	}

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

	public boolean getEventMakerIsDeleted() {
		return eventMakerIsDeleted;
	}

	public void setEventMakerIsDeleted(boolean eventMakerIsDeleted) {
		this.eventMakerIsDeleted = eventMakerIsDeleted;
	}

}
