package com.etna.gpe.dto;

public class AddParticipantDto {

	private int eventId;
	private String participantEmail;
	
	public AddParticipantDto() {
		super();
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getParticipantEmail() {
		return participantEmail;
	}

	public void setParticipantEmail(String participantEmail) {
		this.participantEmail = participantEmail;
	}
	
	
}
