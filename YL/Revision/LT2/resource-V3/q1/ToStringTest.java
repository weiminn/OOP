
public class ToStringTest {
    public static void main(String[] args) {
        ElectronicBook b1 = new ElectronicBook("Apple", 1234, new String[]{}, new MyDate("12122019"));

        System.out.println("Test");
        System.out.println("Expected:Apple : 12122019");
        System.out.println("Actual  :" + b1);

    }
}
