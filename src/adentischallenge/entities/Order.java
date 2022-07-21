package adentischallenge.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	
	private String customerName;
	private String customerContact;
	private String shippingAddress;
	private double grandTotal;
	private LocalDateTime orderPlacedDate;
	private List<Item> items;
	
	public Order(String customerName, String customerContact, String shippingAddress, 
				 double grandTotal, LocalDateTime orderPlacedDate, List<Item> items) {
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.shippingAddress = shippingAddress;
		this.grandTotal = grandTotal;
		this.orderPlacedDate = orderPlacedDate;
		this.items = items;
	}
	
	/**
	 * Setters
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void setOrderDate(LocalDateTime orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Getters
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	public String getCustomerContact() {
		return customerContact;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
	
	public LocalDateTime getOrderPlacedDate() {
		return orderPlacedDate;
	}
	
	public List<Item> getItems() {
		return items;
	}
}
