public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public  void saySomething() {
        System.out.println(getName() + " says whoof whoof");
    }
}