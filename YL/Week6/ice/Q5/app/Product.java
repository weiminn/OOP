/**
 * Created by yeowleong on 8/5/14.
 */
package app;

public class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return String.format("%s, %s, %s", name, quantity, price);
    }
}


