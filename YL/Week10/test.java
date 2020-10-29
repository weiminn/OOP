import java.util.*;

public class test {
    public static void main(String[] args) {

        //TreeMap sorts keys and values
        TreeMap<String, Integer> map = new TreeMap<>();

        //Null Pointer Exception
        map.put("apple", null);
        // int x = map.get("apple");
        map.put("Pear", 3214);


        //Autoboxing
        map.put("Orange1", 1);
        //instead of 
        map.put("Orange2", new Integer(2));

        //returns null
        System.out.println("Doesn't exist: " + map.get("doesntExist"));

        //iterate through
        Collection<Integer> values = map.values();
        for(Integer x: values){
            System.out.println(x);
        }

        //collection of unique values
        Collection<String> keys = map.keySet();
        for(String x: keys){
            System.out.println(x);
        }

        map.remove("pear");

        //iterative removal more suitable for Lists
        // (new ArrayList<>()).iterator().remove();
        //for loops are dangerous for removal as the size changes throughout the loop


        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Dicky"));
        persons.add(new Person("Dicky"));
        System.out.println(persons);
    }
    
}
