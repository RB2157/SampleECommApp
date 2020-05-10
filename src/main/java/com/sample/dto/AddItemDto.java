package com.sample.dto;

/**
 * DTO class for adding/updating a item
 * 
 * @author ronbaner
 *
 */
public class AddItemDto {

	private Long itemId;

	private String itemDescription;

	private int itemQuantity;

	private String message;

	private double itemPrice;

	/**
	 * Default Constructor.
	 * 
	 */
	public AddItemDto() {
		super();
	}

	/**
	 * The contructer with all fields.
	 * 
	 * @param itemId
	 * @param itemDescription
	 * @param itemQuantity
	 * @param message
	 * @param itemPrice
	 */
	public AddItemDto(Long itemId, String itemDescription, int itemQuantity, String message, double itemPrice) {
		super();
		this.setItemId(itemId);
		this.itemDescription = itemDescription;
		this.itemQuantity = itemQuantity;
		this.message = message;
		this.itemPrice = itemPrice;
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
	 * Gets the message.
	 * 
	 * @return message
	 */
	public String getmessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 */
	public void setmessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the item price.
	 * 
	 * @return item price.
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
