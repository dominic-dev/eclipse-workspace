public class Circle extends Shape{
	public double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

    public double getRadius() {
        return radius;
    }
	
	public double getArea() {
		return Main.PI * Math.pow(radius, 2);
	}
	
	public double getCircum() {
		return 2 * Main.PI * radius;
	}

    public String toString(){
        return "This is a circle with radius " + radius;
    }



}
