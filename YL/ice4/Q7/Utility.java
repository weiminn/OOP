import java.util.*;

public class Utility {
    public static void doSomething(List<Animal> aList) {
        for (Animal a : aList) {
            a.saySomething();
        }
        //aList.add(new Dog("pussy")); 
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Snowy"));
        animals.add(new Dog("Brownie"));
        doSomething(animals);
        System.out.println();

        List<Dog> animals2 = new ArrayList<>();
        animals2.add(new Dog("Milky"));
        animals2.add(new Dog("Cocoa"));
        doSomething(animals2);
    }
}