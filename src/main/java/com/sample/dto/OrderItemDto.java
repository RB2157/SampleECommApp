package com.sample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * DTO class for a item inside a order
 * 
 * @author ronbaner
 *
 */

@JsonInclude(Include.NON_NULL)
public class OrderItemDto {

	private Long itemId;

	private int orderQuantity;

	private String orderStatus;

	/**
	 * Default Constructer.
	 * 
	 */
	public OrderItemDto() {
		super();
	}

	/**
	 * The contructer with all fields.
	 * 
	 * @param itemId
	 * @param orderQuantity
	 */
	public OrderItemDto(Long itemId, int orderQuantity) {
		super();
		this.itemId = itemId;
		this.orderQuantity = orderQuantity;
	}

	/**
	 * Gets the item id.
	 * 
	 * @return item id
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 * 
	 * @param itemId
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the order quantity.
	 * 
	 * @return order quantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * Sets the order quantity.
	 * 
	 * @param orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * Gets the order status.
	 * 
	 * @return order status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets the order status.
	 * 
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
