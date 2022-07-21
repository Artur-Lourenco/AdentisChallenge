package adentischallenge.entities;

import java.time.LocalDateTime;

public class Product {
	
	private String name;
	private String category;
	private double weight;
	private double price;
	private LocalDateTime creationDate;
	
	public Product(String name, String category, double weight, double price, 
					LocalDateTime creationDate) {
		this.name = name;
		this.category = category;
		this.weight = weight;
		this.price = price;
		this.creationDate = creationDate;
	}

	/**
	 * Setters
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * Getters
	 */
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getPrice() {
		return price;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
}
