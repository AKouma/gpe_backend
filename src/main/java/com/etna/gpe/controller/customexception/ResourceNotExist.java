package com.etna.gpe.controller.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "resource not exist")
public class ResourceNotExist extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}