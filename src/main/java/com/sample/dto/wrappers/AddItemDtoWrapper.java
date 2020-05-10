package com.sample.dto.wrappers;

import java.util.List;

import com.sample.dto.AddItemDto;

/**
 * Wrapper DTO fro AdditemDto.class
 * 
 * @author ronbaner
 *
 */
public class AddItemDtoWrapper {

	private List<AddItemDto> items;

	/**
	 * Default Constructer.
	 * 
	 */
	public AddItemDtoWrapper() {
		super();

	}

	/**
	 * The constructer with all fields.
	 * 
	 * @param items
	 */
	public AddItemDtoWrapper(List<AddItemDto> items) {
		super();
		this.items = items;
	}

	/**
	 * Gets the items.
	 * 
	 * @return items
	 */
	public List<AddItemDto> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 * 
	 * @param items
	 */
	public void setItems(List<AddItemDto> items) {
		this.items = items;
	}

}
