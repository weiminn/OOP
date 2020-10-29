public class Swan extends Animal {
    //if immediate child,
    //must implement all the abstract methods in parent class(es)

    @Override
    //must follow rules for overriding
    //must be at least as accessible as its abstract method
    public void move() {
        System.out.println("Swan moving!");
    }

    //DOES NOT COMPILE
    //abstract method can only be defined by abstract class
    // public abstract void swim();
    
}
