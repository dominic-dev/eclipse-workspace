package shapes;

public class Triangle extends Shape {

	//var
	private double leftLine;
	private double rightLine;
	private double bottomLine;
	private Point center;
	private String name;

	//semi-no-arg default color
	public Triangle() {
		super();
		this.leftLine = 1.0;
		this.rightLine = 1.0; 
		this.bottomLine = 1.0;
		this.center = new Point(0.0, 0.0);
	}
	
	//some-arg no color
	public Triangle(double leftLine, double rightLine, double bottomLine) {
		this.leftLine = leftLine;
		this.rightLine = rightLine; 
		this.bottomLine = bottomLine;
		this.center = new Point(0.0, 0.0);
	}
	
	//all-arg with color
	public Triangle(String color, boolean filled, double leftLine, 
			double rightLine, double bottomLine, Point center) {
		super(color, filled);
		this.leftLine = leftLine;
		this.rightLine = rightLine; 
		this.bottomLine = bottomLine;
		this.center = center;
	}
	
	@Override
	public String toString() {
		if (super.getColor() == "opaque") {
			return "Triangle with no color "
				+ ", left line " + this.leftLine
				+ ", right line " + this.rightLine
				+ ", bottom line " + this.bottomLine
				+ " and center " + this.center;
		} else {
			return "Triangle with color " + super.getColor()
				+ ", left line " + this.leftLine
				+ ", right line " + this.rightLine
				+ ", bottom line " + this.bottomLine
				+ " and center " + this.center;
		}
	}

    public double getArea() {
        return (this.leftLine + this.rightLine + this.bottomLine) / 2;
    }

    public double getPerimeter() {
        return this.leftLine + this.rightLine + this.bottomLine;
    }
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
    
    public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}

	public double getLeftLine() {
		return leftLine;
	}

	public void setLeftLine(double leftLine) {
		this.leftLine = leftLine;
	}

	public double getRightLine() {
		return rightLine;
	}

	public void setRightLine(double rightLine) {
		this.rightLine = rightLine;
	}

	public double getBottomLine() {
		return bottomLine;
	}

	public void setBottomLine(double bottomLine) {
		this.bottomLine = bottomLine;
	}
	
}
