package stap1;

public class Area implements Expandable<Area>{

	private Integer size;

	public Area(Integer size) {
		super();
		this.size = size;
	}

	@Override
	public Area expand(Area other) {
		return new Area(this.size + other.size);
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
