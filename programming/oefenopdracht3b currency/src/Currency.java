
public class Currency {
	public String name;
	public double rate;
	
	public Currency(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}
	
	public double exchangeTo(double amount) {
		return Math.round(amount * rate * 100) / 100.0;
	}
	
	
}
