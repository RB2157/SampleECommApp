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

import com.sample.dto.wrappers.AddItemDtoWrapper;
import com.sample.services.ItemService;

/**
 * The controller for handling Item related endpoints.
 * 
 * @author ronbaner
 *
 */

@RestController
public class ItemController  {
	
	private static final Logger LOGGER = LogManager.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;
	
	
	/**
	 * Gets all the available items from the database.
	 * 
	 * @return response
	 */
	@GetMapping("/getAllItems")
	public ResponseEntity<Object> getAllItems() {
		LOGGER.debug("Into getAllItems()");

		return itemService.getAllItems();
	}

	/**
	 * Gets the item from the database whose id is passed as @param itemId.
	 * 
	 * @param itemId
	 * @return response
	 */
	@GetMapping("/getItem/{id}")
	public ResponseEntity<Object> getItemById(@PathVariable("id") Long itemId) {
		LOGGER.debug("Into getItemById()");
		return itemService.getItemById(itemId);
	}

	/**
	 * Deletes all items from the database.
	 * 
	 * @return response
	 */
	@DeleteMapping("/deleteAllItems")
	public ResponseEntity<Object> deleteAllItems() {
		
		LOGGER.debug("Into deleteAllItems()");
		return itemService.deleteAllItems();
	}

	/**
	 * Deletes the item from the database whose id is passed as @param itemId.
	 * 
	 * @param itemId
	 * @return
	 */
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<Object> deleteItemById(@PathVariable("id") Long itemId) {
		return itemService.deleteItemById(itemId);
	}

	/**
	 * Add new items/ update existing items in database.
	 * 
	 * @param items
	 * @return response
	 */
	@PostMapping("/addItems")
	public ResponseEntity<Object> addItems(@RequestBody AddItemDtoWrapper items) {
		return itemService.addItems(items);

	}
	
	
	

}
