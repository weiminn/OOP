//can have only max 1 public class per java file

//Rodent needs to be in seperate file if public
class Rodent{

    //GroundHog will not compile
    //Empty ctor with empty call to super is inserted to GroundHog
    //Rodent does NOT have empty ctor if ctor is declar like beneathe
    // public Rodent(String name) {
    //     super();
    // }
}

/*
DOES NOT COMPILE
public class Rodent{}
*/

public class GroundHog extends Rodent {
    public static void main(String[] args) {
        //empty ctor automatically inserted by compiler
        new GroundHog();
    }
}