package com.baeldung.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5231460647707200464L;

	BookNotFoundException(String message) {
        super(message);
    }
}