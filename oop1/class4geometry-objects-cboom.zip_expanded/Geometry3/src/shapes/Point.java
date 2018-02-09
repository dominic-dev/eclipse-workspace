package shapes;

public class Point extends Shape {

	private double x;
	private double y;
	
	//no arg constructor
	public Point() {
		this(0.0, 0.0);
	}
	
	//all-arg constructor
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//getter X
	public double getX() {
		return this.x;
	}
	
	//getter Y
	public double getY() {
		return this.y;
	}
	
	//behavior diffX
	public double differenceInX(double x1, double x2) {
		return x1 - this.x;
	}
	
	//behavior diffY
	public double differenceInY(double y1, double y2) {
		return y1 - this.y;
	}
	
	//behavior distSqr
	public double distanceSquared(double differenceInX, double differenceInY) {
		return differenceInX * differenceInX + differenceInY * differenceInY;
	}
	
	//behavior dist
	public double distance(double distanceSquared) {
		return Math.sqrt(distanceSquared);
	}
	
	@Override
	public String toString() {
        return String.format("Point (%f, %f)", x, y);
	}
}
