public class Lion extends Animals {

    //does NOT Override variable
    //only hide
    private int age;

    //compiler automatically inserts no-arg constructor
    //if automatically inserted by compiler, cannot be called by other constructors because if other constructor exists, default will not be inserted by compiler
    public Lion() {
        //super not inserted if chained
        //super will be inserted in base ctor
        //this can only be called from other constructors in the same class
        this("Default");

        //DOES NOT COMPILE
        //Lion("Default")
        //constructors called only with "new" keyword
    }

    //base constructor
    public Lion(String name) {
        //call to super ctor automatically in the base constructor
        //only as first statemnet in ctor
        
        //super();

    }

    private void roar() {

        //getAge need to be public if accessed by everone
        //size need to protected if accessed only by chidren
        System.out.println(
            "Roared by " + getAge() +
            " and " + size
        );        
        
        //can use super keyword to explicitly refer to parent's method
        //still cannot acess private members
        System.out.println(
            "Roared by " + super.getAge()
        );

        /*
        DOES NOT COMPILE
        System.out.println(
            "Roared by " + age
        );
        */
    }

    //OVERRIDING
    //must have the same signature
    //must be at least as accessible as the original method

    //must not throw new or broader checked exceptions
    //can hide or eliminate parent's exceptions

    //must return covariant return types (same or subclass)

    //HIDING
    //must be static if parent method is static
    //in addition to the rules of overriding
    public void getAge(){

        //calls parent's getAge
        return super.getAge() + 30;

        //INFINITE LOOP
        //calls its own getAge recursively with no base case
        //return getAge() + 30;
    }


    //Redeclare private methods
    //setSize in parent class is hidden
    private void setSize(int size){

    }
}
