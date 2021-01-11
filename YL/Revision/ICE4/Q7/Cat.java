public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public  void saySomething() {
        System.out.println(getName() + " says meow meow");
    }
    }