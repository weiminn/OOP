
public class ConstructorTest {
    public static void main(String[] args) {
        ElectronicBook b1 = new ElectronicBook("Apple", 1234, new String[]{"apple", "orange"}, new MyDate("12122019"));

        System.out.println("Test 1");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + b1.getTitle().equals("Apple"));
        System.out.println();

        System.out.println("Test 2");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + (b1.getAuthors().length == 2));
        System.out.println();

        System.out.println("Test 3");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + (b1.getPriceInCents() == 959));
        System.out.println();

        System.out.println("Test 4");
        System.out.println("Expected:true");
        System.out.println("Actual  :" + b1.getExpiryDate().equals(new MyDate("12122019")));

    }
}
