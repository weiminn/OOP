
public class GetPriceInCentsTest {
    public static void main(String[] args) {
        {
            ElectronicBook b1 = new ElectronicBook("Java Rocks", 1234, new String[]{}, new MyDate("12122019"));

            int result = b1.getPriceInCents();
            System.out.println("Test 1");
            System.out.println("Expected:959");
            System.out.println("Actual  :" + result);
            System.out.println();
        }

        {
            ElectronicBook b1 = new ElectronicBook("Java Rocks", 80, new String[]{}, new MyDate("12122019"));

            int result = b1.getPriceInCents();
            System.out.println("Test 2");
            System.out.println("Expected:62");
            System.out.println("Actual  :" + result);
            System.out.println();
            ;
        }


        {
            // free book
            ElectronicBook b1 = new ElectronicBook("Java Rocks", 0, new String[]{}, new MyDate("12122019"));

            int result = b1.getPriceInCents();
            System.out.println("Test 3");
            System.out.println("Expected:0");
            System.out.println("Actual  :" + result);
            System.out.println();
        }
    }
}
