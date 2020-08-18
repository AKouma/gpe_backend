package com.etna.gpe.pager;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pager {

	private static int NUMBER_OF_ITEMS = 15;

	public static Pageable getEventPageable(int pageRequested) {
		Pageable pageWithFifteenElements = PageRequest.of(pageRequested, NUMBER_OF_ITEMS);
		return pageWithFifteenElements;
	}

}
