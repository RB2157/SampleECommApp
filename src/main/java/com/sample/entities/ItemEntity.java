package com.sample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The item entity represents the items table in the database.
 *
 * @author ronbaner
 *
 */

@Entity
@Table(name = "Items")
public class ItemEntity {

	@Id
	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "item_desc")
	private String itemDescription;

	@Column(name = "item_quantity")
	private int itemQuantity;

	@Column(name = "item_price")
	private double itemPrice;

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
	 * Gets the item description.
	 * 
	 * @return item description
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * Sets the item description.
	 * 
	 * @param itemDescription
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * Gets the item quantity.
	 * 
	 * @return item quantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 * 
	 * @param itemQuantity
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * Gets the item price.
	 * 
	 * @return item price
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 * 
	 * @param itemPrice
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
