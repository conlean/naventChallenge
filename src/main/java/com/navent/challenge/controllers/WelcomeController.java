package com.navent.challenge.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Leito 
 * Bienvenida controller
 */
@RestController
@RequestMapping("/")
public class WelcomeController {

	Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@GetMapping
	public String welcome() {
		logger.info("App is running");
		return "App is running";
	}
}
