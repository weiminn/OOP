import java.util.*;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        
        Person p = new Person("Adrian");
        p.addItem(new Fruit("grape"));
        p.addItem(new Car("Mercedes",90000.0, 0.10));
        p.addItem(new Fruit("lime"));
        p.addItem(new House("Flat",120000.0));
        p.addItem(new Car("BMW",95000.0, 0.20));
        persons.add( p );
        
        p = new Person("Bryan");
        p.addItem(new Fruit("apple"));
        p.addItem(new Jewellery("Diamond Ring",300.0));
        p.addItem(new Fruit("orange"));
        p.addItem(new Jewellery("Gold necklace",500.0));
        p.addItem(new Fruit("papaya"));
        persons.add( p );
        
        p = new Person("Cathy");
        persons.add( p );
        
        p = new Person("Devin");
        p.addItem(new Fruit("pear"));
        p.addItem(new Car("Porsche",110000.0, 0.05));
        p.addItem(new Fruit("lemon"));
        p.addItem(new House("Villa",200000.0));
        p.addItem(new Fruit("berry"));
        p.addItem(new Jewellery("Pearl necklace",3000.0));
        p.addItem(new Fruit("banana"));
        persons.add( p );
        
        System.out.println("Before sorting:");
        print(persons);
        System.out.println();
        
        Collections.sort(persons);
        
        System.out.println("After sorting:");
        print(persons);
        System.out.println();
        printResult(persons);
    }
    
    private static void print(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++ ) {
            Person p = persons.get(i);
            System.out.println( (i+1) + ". " + p );
        }
    }
    
    private static void printResult(List<Person> persons) {
        String actual = "";
        for (Person p : persons ) {
            actual +=  p;            
        }
        String expected = "Devin [pear, Porsche ($110000.0), lemon, Villa ($200000.0), berry, Pearl necklace ($3000.0), banana]Adrian [grape, Mercedes ($90000.0), lime, Flat ($120000.0), BMW ($95000.0)]Bryan [apple, Diamond Ring ($300.0), orange, Gold necklace ($500.0), papaya]Cathy []";
        
        System.out.println( "Result: " + (expected.equals(actual) ? "Pass":"Fail") );
    }
}