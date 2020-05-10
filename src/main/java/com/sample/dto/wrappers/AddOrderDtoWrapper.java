package com.sample.dto.wrappers;

import java.util.List;

import com.sample.dto.AddOrderDto;

/**
 * Wrapper DTO for AddOrderDto
 * 
 * @author ronbaner
 *
 */
public class AddOrderDtoWrapper {

	private List<AddOrderDto> orders;

	/**
	 * Default Constructer.
	 * 
	 */
	public AddOrderDtoWrapper() {
		super();

	}

	/**
	 * The constructer with all fields.
	 * 
	 * @param orders
	 */
	public AddOrderDtoWrapper(List<AddOrderDto> orders) {
		super();
		this.orders = orders;
	}

	/**
	 * Gets the orders.
	 * 
	 * @return orders
	 */
	public List<AddOrderDto> getOrders() {
		return orders;
	}

	/**
	 * Sets the orders.
	 * 
	 * @param orders
	 */
	public void setOrders(List<AddOrderDto> orders) {
		this.orders = orders;
	}
}
