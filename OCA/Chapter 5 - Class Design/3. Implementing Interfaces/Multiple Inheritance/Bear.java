public class Bear implements Herbivore, Omnivore {

    //implements eatPlants from both interfaces simultaneously
    //automatically implements the second method
    //if the two methods have different signatures, must implement both
    public void eatPlants() {
        System.out.println("Eating Plants");
    }

    public void eatMeat() {
        System.out.println("Eating Meat");
    }

    
}
