public class Book {

	private String title;
	private Author author;
	protected double price;

    public Book(String title, Author author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
    }

	public String getTitle() {
    	return title;
	}

	public Author getAuthor() {
    	return author;
	}

	public void setPrice(double price) {
    	this.price = price;
	}

	public double getPrice() {
    	return price;
	}

}
