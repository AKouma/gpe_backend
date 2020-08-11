package com.etna.gpe.controller.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "resource already exist")
public class ResourceAlreadyExist extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
