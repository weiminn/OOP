import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ResultGeneratorTest {

    public static List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(new File("test.ser")))) {
            int size = reader.readInt();
            for (int i = 0 ; i < size ; i++) {
                studentList.add((Student) reader.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public static void main(String[] args) {

        try {
            ResultGenerator.output(getStudents(), "result.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
