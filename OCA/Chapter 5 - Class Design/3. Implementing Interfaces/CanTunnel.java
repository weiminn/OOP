//inherits all abstract methods of CanBurrow
//first concrete class to implement this or extend abstract class that implement this must implement all the inherited abstract methods
public interface CanTunnel extends CanBurrow {

    //default method overrides abstract method from parent interface
    default int getMaximumDepth(){
        return 10;
    }

    //overrides default method form parent with new abstract method
    //forces any class that implement this sub interface to implement getMaximumDepth()
    double getGirth();
}
