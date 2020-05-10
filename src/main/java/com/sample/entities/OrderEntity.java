package com.sample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The order entity represents the orders table in the database.
 * 
 * @author ronbaner
 *
 */
@Entity
@Table(name = "Orders")
public class OrderEntity {

	@Id
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "order_quantity")
	private int orderQuantity;

	/**
	 * Gets the order id.
	 * 
	 * @return order id.
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	 * Gets the email id.
	 * 
	 * @return email id.
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
}
