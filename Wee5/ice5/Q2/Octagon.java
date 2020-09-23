package ice5.Q2;


public class Octagon implements Shape {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return (side*side) * (2 + (2*Math.sqrt(2)));
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
