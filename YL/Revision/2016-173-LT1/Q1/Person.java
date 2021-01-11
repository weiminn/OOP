import java.util.*;

public class Person implements Comparable<Person>{
    // Do not change : start
    private String name;
    private List<Item> items = new ArrayList<>();
    
    public Person(String name) {
        this.name = name;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public String toString() {
        return name + " " + items;
    }
    // Do not change : end
    

    @Override
    public int compareTo(Person p){
        double t1 = 0.0;
        double t2 = 0.0;
        for (Item item : items) {
            if(item instanceof ValuableItem && !(item instanceof Depreciating)){
                t1 += ((ValuableItem) item).getPrice();
            }
        }
        for (Item item : p.items) {
            if(item instanceof ValuableItem && !(item instanceof Depreciating)){
                t2 += ((ValuableItem) item).getPrice();
            }
        }

        return -Double.compare(t1, t2);
    }    
    
}