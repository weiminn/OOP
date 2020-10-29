import java.util.*;

public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    //must implement for HashDataStructure
    //to get the index
    public int hashCode(){
        return Objects.hash(name);
    }
}
