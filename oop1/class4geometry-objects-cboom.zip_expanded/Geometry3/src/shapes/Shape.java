package shapes;

public abstract class Shape {
	
	private String color;
	private boolean filled;
	
	public Shape() {
		this.color = "opaque";
	}
	
	public Shape(String color, boolean filled) {
		this.color = color;
		this.setFilled(filled);
	}
	
	public String toString() {
		return "Shape with color: " + color;
	}
	
    // A static method to print any Shape
    public static void printShape( Shape s ) {
        System.out.println("Print Shape " + s );
    }
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

}
