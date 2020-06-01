package com.wiley.covidtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception {
	
	public ResourceNotFound(String message) {
    	super(message);
    }
}
