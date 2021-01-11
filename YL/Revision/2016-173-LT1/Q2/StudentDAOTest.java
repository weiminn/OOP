import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentDAOTest {
    public static void testMissingFile() {
        System.out.println("Test 1: Missing File");

        try {
            StudentDAO.read("missing.txt");
            System.out.println("Result: Fail");
        } catch (FileNotFoundException e) {
            System.out.println("Result: Pass");
        } catch (Throwable e) {
            System.out.println("Result: Fail");
        }
    }

    public static void testEmptyFile() {
        System.out.println("Test 2: Empty File");

        try {
            List<Student> studentList = StudentDAO.read("empty.txt");
            System.out.println("Expected: []");
            System.out.println("Actual:   " + studentList);
            if ("[]".equals(studentList.toString())) {
                System.out.println("Result:   Pass");
            } else {
                System.out.println("Result:   Fail");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Actual: Crashed with exception");
            e.printStackTrace();
        }
    }

    public static void testReadFile() {
        System.out.println("Test 3: Non-Empty File");

        try {
            List<Student> studentList = StudentDAO.read("student.txt");

            String expected = "[name=mary, gender=F, courses= [], name=orange, gender=M, courses= [code=COMM101, gradePoint=3.3, code=IS101, gradePoint=4.0, code=IS200, gradePoint=3.0, code=MATH001, gradePoint=4.3], languages=[Java, Python, C#, Go, Perl, C++], name=apple, gender=M, courses= [code=COMM101, gradePoint=3.3, code=IS101, gradePoint=3.0, code=IS200, gradePoint=2.7, code=MGMT003, gradePoint=3.3, code=STAT101, gradePoint=1.3], languages=[Java], name=pear, gender=M, courses= [code=COMM101, gradePoint=4.0, code=IDIS001, gradePoint=3.7, code=IS101, gradePoint=4.3, code=IS200, gradePoint=1.7, code=MGMT002, gradePoint=4.0], languages=[], name=durian, gender=F, courses= [], languages=[], name=ricky, gender=M, courses= []]";

            String actual = studentList.toString();
            System.out.println("Expected: " + expected);
            System.out.println();
            System.out.println("Actual:   " + actual);
            if ( expected.equals(actual) ) {
                System.out.println("Result:   Pass");
            } else {
                System.out.println("Result:   Fail");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Actual: Crashed with exception");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testMissingFile();
        System.out.println();
        
        testEmptyFile();
        System.out.println();
        
        testReadFile();
        System.out.println();      
    }
}
