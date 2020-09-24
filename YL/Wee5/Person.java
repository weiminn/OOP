import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        Person p = new Person("Calvin");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("demoFile"));
        oos.writeObject(p);
    }
    
}
