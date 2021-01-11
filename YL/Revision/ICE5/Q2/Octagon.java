public class Octagon implements Shape{
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double getPerimeter() {
        return 8*side;
    }

    public double getArea() {
        return Math.pow(this.side, 2) + (2 + (2 * Math.pow(2, .5)));
    }
    
}
