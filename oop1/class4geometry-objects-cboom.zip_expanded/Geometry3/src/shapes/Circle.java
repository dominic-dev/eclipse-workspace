package shapes;

public class Circle extends Shape {
	
	//variabelen
	private double radius;
	private Point center;
	private String name;
	
	//no-args constructor
	public Circle() {
		this(1);
	}
	
	//some-args constructor with default color
	public Circle(double radius) {
		super();
		this.center = new Point(0.0, 0.0);
		this.radius = radius;
	}
	
	//some-args constructor no color
	public Circle(Point center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	
	//all-args constructor
	public Circle(String color, boolean filled, Point center, double radius) {
		super(color, filled);
		this.center = center;
		this.radius = radius;
	}
	
	//behavior tostring
	@Override
	public String toString() {
		return "Circle with radius " + this.radius + " and center (" + this.center.toString() + ").";
	}
	
	//behavior area
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}
	
	//behavior point
	public boolean containsPoint(Point p) {
	
	    double diffX = p.differenceInX(p.getX(), this.center.getX());
		double diffY = p.differenceInY(p.getY(), this.center.getY());
		double distSq = p.distanceSquared(diffX, diffY);
		double dist = p.distance(distSq);
		
		return (dist <= this.radius);
	}
	
/**	
	//behavior point
	public boolean containsPoint(Point aPoint) {
		//afstand van punt tot centrum berekenen => sqrt(x² + y²)
		double distance = 
				Math.hypot(aPoint.x - this.center.x, aPoint.y - this.center.y);
		//en afstand moet kleiner zijn dan de radius.
		return (distance <= this.radius);
	}

	public boolean containsPoint(Point p) {
		double differenceInX = p.x - this.center.x;
		double differenceInY = p.y - this.center.y;
		double distanceSquared = differenceInX * differenceInX + differenceInY * differenceInY;
		
		// wortel trekken is rekenen en afronding...
		// zonder wortel trekken kan je het OOK vergelijken met radius in kwadraat! 
		// dus wortel trekken is niet nodig. is computertechnisch beter om dit te doen.
		
		return (distanceSquared <= this.radius * this.radius);
	}
*/

	//getter radius
	public double getRadius() {
		return this.radius;
	}

	//setter radius
	public void setRadius(double radius) {
		//set een radius die groter dan 0 moet zijn....
		if (radius > 0) {
			this.radius = radius;
		}
	}
	
	//getter center
	public Point getCenter() {
		return this.center;
	}
	
	//setter center
	public void setCenter(Point p) {
		this.center = p;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
