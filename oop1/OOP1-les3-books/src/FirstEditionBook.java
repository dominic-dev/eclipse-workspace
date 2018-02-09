
public class FirstEditionBook extends Book{
    int premiumPrice;
    public FirstEditionBook(String title, Author author, double price) {
        super(title, author, price);
        this.price = price;
    }

    public double getPrice(){
        return this.premiumPrice;
    }

    public String toString(){
        return "";
    }
}
