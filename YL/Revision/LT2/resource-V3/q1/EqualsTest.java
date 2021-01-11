
public class EqualsTest {
    public static void main(String[] args) {
        ElectronicBook b1 = new ElectronicBook("Apple", 1234, new String[]{}, new MyDate("12122019"));
        ElectronicBook b2 = new ElectronicBook("Apple", 1234, new String[]{}, new MyDate("12122019"));
        ElectronicBook b3 = new ElectronicBook("Orange", 1234, new String[]{}, new MyDate("12122019"));
        ElectronicBook b4 = new ElectronicBook("Apple", 1234, new String[]{}, new MyDate("11122019"));

        System.out.println("Test 1");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + b1.equals(b2));
        System.out.println();


        System.out.println("Test 2");
        System.out.println("Expected:false");
        System.out.println("Actual  :" + b3.equals(b2));
        System.out.println();

        System.out.println("Test 3");
        System.out.println("Expected:false");
        System.out.println("Actual  :" + b4.equals(b2));
        System.out.println();

    }
}
