public abstract class Elephant implements CanBurrow, CanRoll{
    //cannot implement interfaces that have default implementation for same signature
    //need to implement again
    public double getGirth(){
        return 1000;
    }
}
