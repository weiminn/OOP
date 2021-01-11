import java.util.HashSet;
import java.util.Set;

public class SecretaryTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Check Boss");
        Secretary s1 = new Secretary("Mary", "SIS", new Faculty("Apple", "SIS", "19871212"));
        Secretary s2 = new Secretary("Mary", "SIS", new Faculty("Apple", "SIS", "19871212"));
        Staff myBoss = s1.getBoss();
        System.out.println("Expected:true");
        System.out.println("Actual  :" + myBoss.getName().equals("Apple"));
        System.out.println();

        System.out.println("Test 2: Check type");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + s1.getClass().getSuperclass().getName().equals("Staff"));
        System.out.println();

        System.out.println("Test 3: Check equals");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + s1.equals(s2));
        System.out.println();


        Set<Secretary> set = new HashSet<>();
        set.add(s1);
        set.add(s2);

        System.out.println("Test 4: hashcode");
        System.out.println("Expected:1");
        System.out.println("Actual  :" + set.size());
        System.out.println();


        System.out.println("Test 5: toString");
        System.out.println("Expected:Secretary{name='Mary', school='SIS',boss=Apple}");
        System.out.println("Actual  :" + s1);
    }
}
