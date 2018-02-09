package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
	private Customer orderCustomer;
	private String orderDate;
	private List<Orderline> orderlines = new ArrayList<Orderline>();
	private double totalOrderPrice;
	
	public Order(Customer orderCustomer, String orderDate) {
		super();
		this.orderCustomer = orderCustomer;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(Customer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public void addOrderline(Orderline oline) {
		this.orderlines.add(oline);
	}

	public double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice() {
		this.totalOrderPrice = 0;
		for (Orderline ol : orderlines) {
			this.totalOrderPrice += ol.getTotalPrice();
		}

	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer: " + orderCustomer + "\n");
		sb.append("Date: " + orderDate + "\n");
		sb.append("Ordered Products: \n");
		for (Orderline ol : orderlines) {
			sb.append(ol + "\n");
		}
		sb.append("Totalprice: " + totalOrderPrice);
		return sb.toString();
	}
	
	
}
