package stap1;

public class Pair<T extends Expandable<T>> implements Expandable<Pair<T>>{

	private T x;
	private T y;

	public Pair(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public Pair<T> expand(Pair<T> other) {
		return new Pair<T>(x.expand(other.x), y.expand(other.y));
	}
}
