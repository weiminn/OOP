package farming;

import java.util.ArrayList;
import farming.type.*;

public class AnimalFarm {
    private ArrayList<Animal> animals = new ArrayList<>();

    public AnimalFarm() {
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());
    }

    public void makeNoise() {
        for (Animal a : animals) {
            a.makeNoise();
        }

    }
}
