package model;

public class Orderline {

	private Product orderedProduct;
	private int numberOrdered;
	private double totalPrice;
	private Order order;
	
	
	
	public Orderline(Product orderedProduct, int numberOrdered, Order order) {
		super();
		this.orderedProduct = orderedProduct;
		this.numberOrdered = numberOrdered;
		this.order = order;
		setTotalPrice();
	}

	public Orderline(Product orderedProduct, int numberOrdered) {
		super();
		this.orderedProduct = orderedProduct;
		this.numberOrdered = numberOrdered;
		// direct de totalPrice van de Orderline uitrekenen
		setTotalPrice();
	}

	public Product getOrderedProduct() {
		return orderedProduct;
	}

	public void setOrderedProduct(Product orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	public int getNumberOrdered() {
		return numberOrdered;
	}

	public void setNumberOrdered(int numberOrdered) {
		this.numberOrdered = numberOrdered;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	// De setter van TotalPrice rekent het bedrag van de Orderline uit. 
	// Deze methode wordt aangeroepen in de constructor van de Orderline, zodat de totalPrice bij het aanmaken
	// van een Orderline direct wordt uitgerekend.
	public void setTotalPrice() {
		this.totalPrice = numberOrdered * orderedProduct.getPrice();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String toString() {
		return "[" + orderedProduct.getProductName() + ", " + orderedProduct.getPrice() + ", "
				+ numberOrdered + ", " + totalPrice + "]";
	}
	
}
