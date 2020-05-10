package com.sample.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * DTO class for adding/updating orders.
 * 
 * @author ronbaner
 *
 */
@JsonInclude(Include.NON_NULL)
public class AddOrderDto {

	private Long orderId;

	private String emailId;

	private List<OrderItemDto> items;

	/**
	 * Default Constructer.
	 * 
	 */
	public AddOrderDto() {
		super();
	}

	/**
	 * The contructer with all fields.
	 * 
	 * @param orderId
	 * @param emailId
	 * @param items
	 */
	public AddOrderDto(Long orderId, String emailId, List<OrderItemDto> items) {
		super();
		this.orderId = orderId;
		this.emailId = emailId;
		this.items = items;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public List<OrderItemDto> getItems() {
		return items;
	}

	/**
	 * 
	 * 
	 * @param items
	 */
	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * 
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
