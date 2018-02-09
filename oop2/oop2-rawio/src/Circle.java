import java.io.Serializable;

public class Circle implements Serializable{

	private static final long serialVersionUID = 3945964718456148105L;
	private int x;
	private int y;
	private double radius;

    public Circle(int x, int y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
    }

	public void setX(int x) {
    	this.x = x;
	}

	public int getX() {
    	return x;
	}

	public void setY(int y) {
    	this.y = y;
	}

	public int getY() {
    	return y;
	}

	public void setRadius(double radius) {
    	this.radius = radius;
	}

	public double getRadius() {
    	return radius;
	}

    public double circumference(){
        return 2 * Math.PI * radius;
    }

    public double area(){
        return Math.PI * radius * radius ;
    }

	public Object getDiameter() {
        return radius * 2;
	}


}
