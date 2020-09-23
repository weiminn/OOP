import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("demoFile"));
        Person p = (Person) ois.readObject();
        System.out.println(p.getName());
    }
    
}
