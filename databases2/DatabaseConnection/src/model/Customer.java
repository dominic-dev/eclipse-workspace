package model;

public class Customer {

	private String name;
	private String city;
    private int id;
    
    public Customer(){

    }

    public Customer(int id, String name, String city){
        this(name, city);
        this.id = id;
    }

    public Customer(String name, String city) {
		this.name = name;
		this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

	public void setName(String name) {
    	this.name = name;
	}

	public String getName() {
    	return name;
	}

	public void setCity(String city) {
    	this.city = city;
	}

	public String getCity() {
    	return city;
	}

    public String toString(){
        return String.format("Customer: %s %s", name, city);
    }

}
