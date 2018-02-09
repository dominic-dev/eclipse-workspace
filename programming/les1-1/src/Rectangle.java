public class Rectangle extends Shape{
	private double width;
	private double height;
	
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getCircum() {
		return 2 * this.width + 2 * this.height;
	}

    public String getName(){
        return getClass().getName().toLowerCase();
    }

    public String toString(){
        return String.format("This is a %s with width: %f and height: %f", getName(), width, height);
    }

}
