package com.etna.gpe.dto;

import java.util.List;

public class EventSearchResponseDto {

	private List<EventDto> events;
	
	private int totalPage;

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
