import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionTest {
    public static void testEqualStaff(){
        System.out.println("Test 1 (testEqualStaff):");
        Course c = new Course("001", "ABC Studies");
        Staff[] staff = {
                new TA("Charles", "SIS", 1),
                new TA("BILL", "SIS", 2),
                new Faculty("Bill", "ABC", "20181212")
        };

        Section g1 = new Section("G1", c, staff);

        Staff[] staff2 = {
                new TA("BILL", "SIS", 2),
                new TA("Charles", "SIS", 1),
                new Faculty("Bill", "ABC", "20181212")
        };
        Section g2 = new Section("G2", c, staff2);

        System.out.println("Expected:true");
        System.out.println("Actual  :" + g1.equals(g2));
        System.out.println();
    }

    public static void testUnequalStaff(){
        System.out.println("Test 1 (testUnEqualStaff):");
        Course c = new Course("001", "ABC Studies");
        Staff[] staff = {
                new TA("BILL", "SIS", 2),
                new Faculty("Bill", "ABC", "20181212")
        };

        Section g1 = new Section("G1", c, staff);

        Staff[] staff2 = {
                new TA("BILL", "SIS", 2),
                new Faculty("Bill", "ABC", "20181212"),
                new Faculty("Charles", "ABC", "20181212"),
        };
        Section g2 = new Section("G2", c, staff2);

        System.out.println("Expected:false");
        System.out.println("Actual  :" + g1.equals(g2));
        System.out.println();
    }

    public static void main(String[] args) {
        testEqualStaff();

        testUnequalStaff();

    }
}
