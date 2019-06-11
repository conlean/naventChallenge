package com.navent.challenge.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NaventControllerValidationHandler {

	private static final Logger logger = LoggerFactory.getLogger(NaventControllerValidationHandler.class);

	/**
	 * Handles validation errors in params.
	 *
	 * @param ex thrown exception to handle
	 * @return message to return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> processValidationError(MethodArgumentNotValidException ex) {

		Map<String, String> data = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			data.put("Campo " + error.getField(), " "  + error.getDefaultMessage());
			logger.error(error.getField() + ": " + error.getDefaultMessage());
		}

		return data;
	}

	/**
	 * Handles internal server errors.
	 *
	 * @param ex thrown exception to handle
	 * @return message to return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, String> processValidationError(Exception ex) {

		Map<String, String> data = new HashMap<>();
		data.put("message", "Error en el servidor");
		logger.error("The request failed due to an internal server error.");
		return data;
	}

}
