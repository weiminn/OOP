import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yeowleong on 12/1/17.
 */
public class StudentTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Charlie", 9));
        students.add(new Student("Donkey", 30));
        students.add(new Student("Elise", 10));
        students.add(new Student("Fanciful", 45));
        students.add(new Student("Gorilla", 43));
        students.add(new Student("Alex", 10));
        students.add(new Student("Alex", 30));
        students.add(new Student("Alex", 20));
        students.add(new Student("Billy", 1));

        Collections.sort(students);
        System.out.println(students);

        List<Student> students2 = new ArrayList<Student>();
        students2.add(new Student("Charlie", 9));
        students2.add(new Student("Donkey", 30));
        students2.add(new Student("Fanciful", 45));
        students2.add(new Student("Alex", 10));
        students2.add(new Student("Billy", 1));
        students2.add(new Student("Alex", 30));
        students2.add(new Student("Alex", 20));
        students2.add(new Student("Elise", 10));
        students2.add(new Student("Gorilla", 43));


        Collections.sort(students2, new StudentComparator());
        System.out.println(students2);
    }
}
