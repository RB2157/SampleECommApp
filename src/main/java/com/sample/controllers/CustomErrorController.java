package com.sample.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for custom errors.
 * 
 * @author ronbaner
 *
 */

@RestController
public class CustomErrorController implements ErrorController {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomErrorController.class);

	/**
	 * Refer - org.springframework.boot.web.servlet.error.ErrorController.getErrorPath().
	 * 
	 */
	@Override
	public String getErrorPath() {

		return "/error";

	}
	
	/**
	 * Globally Handling endpoints that doesnot exists.
	 * 
	 * @return response
	 */
	@GetMapping("/error")
	public ResponseEntity<Object> getErrorMessage(){
		LOGGER.error("Into getErrorMessage() : Bad Request");
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("resposne","Error");
		errorResponse.put("message","This endpoint does not exist");
		
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	

}
