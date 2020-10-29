public interface CanRoll {
    //default method
    //may only be declared within interface
    //abstract methods with default implementation
    //not required to override (in a sense, concrete)
    //not final or static as it is supposed to be overridden by class or subinterface
    //assumed to be public
    public default double getGirth() {
        return 50;
    }
}
