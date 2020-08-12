package com.etna.gpe.dto;

import java.util.ArrayList;
import java.util.List;

public class AuthenResponseDto {

	private OrganizationDto organizationDto = null;
	private ParticularDto particularDto = null;
	private String token;
	private List<EventDto> events = new ArrayList<EventDto>();
	
	public AuthenResponseDto() {}

	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}

	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
	}

	public ParticularDto getParticularDto() {
		return particularDto;
	}

	public void setParticularDto(ParticularDto particularDto) {
		this.particularDto = particularDto;
	}

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		if(this.events.isEmpty())
			this.events = events;
		else
			this.events.addAll(events);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
