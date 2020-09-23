public class Vehicle {
    private int numWheels;
    private double distancePerLiter;

    public Vehicle(int numWheels, double distancePerLiter){
        this.numWheels = numWheels;
        this.distancePerLiter = distancePerLiter;
    }

    @Override
    public String toString() {
        return String.format("Vehicle[numWheels='%d', distancePerLiter=%.1f]", numWheels, distancePerLiter);
    }
}
