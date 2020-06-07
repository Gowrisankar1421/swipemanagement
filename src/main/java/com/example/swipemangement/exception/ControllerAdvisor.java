package com.example.swipemangement.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	private static final String MESSAGE = "message";
	@ExceptionHandler(SwipeReportFailedException.class)
	public ResponseEntity<Object> handleSwipeReportFailedException(SwipeReportFailedException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "swpie report was not successful");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Object> handleInvalidDetailsException(InvalidDetailsException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "invalid details");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientDataException.class)
	public ResponseEntity<Object> handleInsufficientDataException(InsufficientDataException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "please fill the all the neccessary deatils");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoEmployeeDataFoundException.class)
	public ResponseEntity<Object> handleNoEmployeeDataFoundException(NoEmployeeDataFoundException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "employee data not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFacilityDataFoundException.class)
	public ResponseEntity<Object> handleNoFacilityDataFoundException(NoFacilityDataFoundException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put(MESSAGE, "facility data not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
