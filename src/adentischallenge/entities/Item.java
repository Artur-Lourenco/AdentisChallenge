package adentischallenge.entities;

public class Item {
	
	private double cost;
	private double shippingFee;
	private double taxAmount;
	Product product;
	
	public Item(double cost, double shippingFee, double taxAmount, Product product) {
		this.cost = cost;
		this.shippingFee = shippingFee;
		this.taxAmount = taxAmount;
		this.product = product;
	}

	/**
	 * Setters
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}
	
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * Getters
	 */
	public double getCost() {
		return cost;
	}
	
	public double getShippingFee() {
		return shippingFee;
	}
	
	public double getTaxAmount() {
		return taxAmount;
	}
	
	public Product getProduct() {
		return product;
	}
}
