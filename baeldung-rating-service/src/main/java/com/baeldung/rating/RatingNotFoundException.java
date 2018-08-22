package com.baeldung.rating;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class RatingNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3376209352697283740L;

	RatingNotFoundException(String message) {
        super(message);
    }
}