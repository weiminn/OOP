//cannot be instantiated directly ( i.e. new CanBurrow() )
//not required to have any methods
//canot be final
//must be public or default package access

public interface CanBurrow {
    
    //public static final optional because assumed and inserted by compiler automatically
    public static final int MINIMUM_DEPTH = 2;
    
    //public abstract optional because assumed and inserted by compiler automatically
    public abstract int getMaximumDepth();

    //default method
    //may only be declared within interface
    //abstract methods with default implementation
    //not required to override (in a sense, concrete)
    //not final or static as it is supposed to be overridden by class or subinterface
    //assumed to be public
    default double getGirth() {
        return 5;
    }

    //static method
    //nearly identical to static method in classes
    //not inherited in any method that implements the interface
    //need to reference the interface directly to use
    static int getJumpHeight() {
        return 8;
    }
}
