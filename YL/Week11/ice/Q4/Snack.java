/**
 * Created by yeowleong on 16/5/14.
 */
public class Snack {
    private int numCalories;
    private String brand;
    private int weight;

    public Snack(String name, double price, int numCalories, String brand, int weight) {
        this.numCalories = numCalories;
        this.brand = brand;
        this.weight = weight;
    }

    public Snack(String name, double price, int numCalories, String brand) {
    }

    public Snack(String name, double price, String brand, int weight) {
    }

    public int getNumCalories() {
        return numCalories;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }
	
}
