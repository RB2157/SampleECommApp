package com.sample.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.AddOrderDto;
import com.sample.services.OrderService;

/**
 * The controller for handling order related endpoints
 * 
 * @author ronbaner
 *
 */
@RestController
public class OrderController {

	private static final Logger LOGGER = LogManager.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	/**
	 * Add new order/ update existing orders in database.
	 * 
	 * @param order
	 * @return reponse
	 */
	@PostMapping("/addOrder")
	public ResponseEntity<Object> addOrder(@RequestBody AddOrderDto order) {

		LOGGER.debug("Into addOrder()");
		return orderService.addOrder(order);
	}

	/**
	 * Deletes all items from the database.
	 * 
	 * @return response
	 */
	@DeleteMapping("/deleteAllOrders")
	public ResponseEntity<Object> deleteAllOrders() {
		return orderService.deleteAllOrders();

	}

	/**
	 * Deletes the order from the database whose id is passed as @param orderId.
	 * 
	 * @param orderId
	 * @return
	 */
	@DeleteMapping("/deleteOrderById/{orderId}")
	public ResponseEntity<Object> deleteOrderById(@PathVariable("orderId") Long orderId) {

		return orderService.deleteOrderById(orderId);

	}

	@GetMapping("/allOrders")
	public ResponseEntity<Object> getAllOrders() {

		return orderService.getAllOrders();

	}

};