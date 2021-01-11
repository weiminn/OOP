
public class CompareToTest {
    public static void main(String[] args) {
        {
            String[] authors1 = {"apple", "orange"};
            String[] authors2 = {"orange", "apple"};

            ElectronicBook b1 = new ElectronicBook("Apple", 1234, authors1, new MyDate("12122019"));
            ElectronicBook b2 = new ElectronicBook("Orange", 1234, authors2, new MyDate("12122019"));

            System.out.println("Test 1 (Check title):");
            System.out.println("Expected:true");
            System.out.println("Actual  :" + (b1.compareTo(b2) < 0));
            System.out.println();
        }

        {
            String[] authors1 = {"apple", "orange"};
            String[] authors2 = {"orange", "apple"};

            ElectronicBook b1 = new ElectronicBook("Apple", 1234, authors1, new MyDate("12122019"));
            ElectronicBook b2 = new ElectronicBook("Apple", 1234, authors2, new MyDate("12122019"));

            System.out.println("Test 2 (Check authors 1):");
            System.out.println("Expected:0");
            System.out.println("Actual  :" + b1.compareTo(b2));
            System.out.println();
        }

        {
            String[] authors1 = {"apple", "orange", "pear"};
            String[] authors2 = {"orange", "apple"};

            ElectronicBook b1 = new ElectronicBook("Apple", 1234, authors1, new MyDate("12122019"));
            ElectronicBook b2 = new ElectronicBook("Apple", 1234, authors2, new MyDate("12122019"));

            System.out.println("Test 3 (Check authors 2):");
            System.out.println("Expected:true");
            System.out.println("Actual  :" + (b1.compareTo(b2) > 0));
            System.out.println();
        }

        {
            String[] authors1 = {"apple", "orange", "pear"};
            String[] authors2 = {"orange", "apple", "pamelo"};

            ElectronicBook b1 = new ElectronicBook("Apple", 1234, authors1, new MyDate("12122019"));
            ElectronicBook b2 = new ElectronicBook("Apple", 1234, authors2, new MyDate("12122019"));

            System.out.println("Test 4 (Check authors 3):");
            System.out.println("Expected:true");
            System.out.println("Actual  :" + (b1.compareTo(b2) > 0));
            System.out.println();
        }

        {
            String[] authors1 = {"apple", "orange", "pear"};
            String[] authors2 = {"orange", "apple", "pear"};

            ElectronicBook b1 = new ElectronicBook("Apple", 1234, authors1, new MyDate("10122019"));
            ElectronicBook b2 = new ElectronicBook("Apple", 1234, authors2, new MyDate("12122019"));

            System.out.println("Test 5 (Check expiry date):");
            System.out.println("Expected:true");
            System.out.println("Actual  :" + (b1.compareTo(b2) < 0));
            System.out.println();
        }

    }
}
