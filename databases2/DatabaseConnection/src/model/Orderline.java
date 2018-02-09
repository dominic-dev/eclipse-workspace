package model;

public class Orderline {

	private int amount;
	private Order order;
	private Product product;
    private double totalPriceOrderline;

    public Orderline(int amount, Order order, Product product) {
		this.amount = amount;
		this.order = order;
		this.product = product;
        updateTotalPriceOrderline();
    }

    /**
     * Upate the totalPriceOrderline based on the product price and amount.
     **/
    private void updateTotalPriceOrderline(){
        this.totalPriceOrderline = product.getPrice() * amount;
    }

    /**
     * @return the totalPriceOrderline
     **/
    public double getTotalPriceOrderline(){
        return totalPriceOrderline;
    }
    
    public void setTotalPriceOrderline(double totalPriceOrderline){
        this.totalPriceOrderline = totalPriceOrderline;
    }
	public void setAmount(int amount) {
    	this.amount = amount;
        updateTotalPriceOrderline();
	}

	public int getAmount() {
    	return amount;
	}

	public void setOrder(Order order) {
    	this.order = order;
	}

	public Order getOrder() {
    	return order;
	}

	public void setProduct(Product product) {
    	this.product = product;
	}

	public Product getProduct() {
    	return product;
	}

}
