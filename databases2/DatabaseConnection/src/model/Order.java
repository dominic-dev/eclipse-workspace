package model;

import java.util.ArrayList;

public class Order {

    private Customer customer;
    private ArrayList<Orderline> orderlines;
    private int id;
    private double totalPriceOrder;
    private String date;

    public Order(){
    }

    public Order(Customer customer){
        this.orderlines = new ArrayList<>();
        this.customer = customer;
    }

    public Order(Customer customer, ArrayList<Orderline> orderlines) {
        this(customer);
        this.orderlines = orderlines;
        updateTotalPriceOrder();
    }

    /**
     * update the totalPriceOrder based on orderlines.
     **/
    private void updateTotalPriceOrder() {
        double total=0;
        for (Orderline orderline : orderlines) {
            total += orderline.getTotalPriceOrderline();
        }
        totalPriceOrder = total;
    }

    /**
     * @param orderline the Orderline to add
     **/
    public void addOrderline(Orderline orderline){
        orderlines.add(orderline);
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the orderlines
     */
    public ArrayList<Orderline> getOrderlines() {
        return orderlines;
    }

    /**
     * @param orderlines the orderlines to set
     */
    public void setOrderlines(ArrayList<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the totalPriceOrder
     */
    public double getTotalPriceOrder() {
        return totalPriceOrder;
    }

    /**
     * @param totalPriceOrder the totalPriceOrder to set
     */
    public void setTotalPriceOrder(double totalPriceOrder) {
        this.totalPriceOrder = totalPriceOrder;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
