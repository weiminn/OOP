/**
 * Created by yeowleong on 16/5/14.
 */
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
	
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "\"" + name + "\" price=$" + df.format( price );
    }
}
