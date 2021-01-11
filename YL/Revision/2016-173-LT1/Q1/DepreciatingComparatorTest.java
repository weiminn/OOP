import java.util.*;

public class DepreciatingComparatorTest {
    public static void main(String[] args) {
        List<Valuable> valuables = new ArrayList<>();
        
        valuables.add(new Jewellery("Gold necklace",500.0));
        valuables.add(new Car("Porsche",110000.0, 0.10));
        valuables.add(new House("Flat",120000.0));
        valuables.add(new Car("BMW",95000.0, 0.20));
        valuables.add(new Jewellery("Diamond Ring",300.0));
        valuables.add(new House("Villa",200000.0));
        valuables.add(new Car("Mercedes",90000.0, 0.10));
        valuables.add(new Jewellery("Pearl necklace",3000.0));
        
        String expected = "Diamond Ring ($300.0)Gold necklace ($500.0)Pearl necklace ($3000.0)Flat ($120000.0)Villa ($200000.0)Mercedes ($90000.0) depreciates at 0.1Porsche ($110000.0) depreciates at 0.1BMW ($95000.0) depreciates at 0.2";
        
        System.out.println("=== Test 1 ===");
        test(valuables, expected);
        
        
        valuables.clear();
        valuables.add(new Car("Porsche",110000.0, 0.10));
        valuables.add(new Car("Mercedes",90000.0, 0.10));
        
        expected = "Mercedes ($90000.0) depreciates at 0.1Porsche ($110000.0) depreciates at 0.1";

        System.out.println("=== Test 2 ===");
        test(valuables, expected);        
        
        
        valuables.clear();
        valuables.add(new House("Villa",200000.0));
        valuables.add(new Jewellery("Gold necklace",500.0));
        
        expected = "Gold necklace ($500.0)Villa ($200000.0)";
        
        System.out.println("=== Test 3 ===");
        test(valuables, expected);        
        
    }
    private static void test(List<Valuable> valuables, String expected) {
        System.out.println("Before sorting:");
        print(valuables);
        System.out.println();
        
        Collections.sort(valuables, new DepreciatingComparator());
        
        System.out.println("After sorting:");
        print(valuables);
        System.out.println();
        printResult(valuables, expected);
    }
    
    private static void print(List<Valuable> valuables) {
        for (int i = 0; i < valuables.size(); i++ ) {
            Valuable v = valuables.get(i);
            System.out.print( (i+1) + ". " + v );
            if (v instanceof Depreciating) {
                Depreciating d = (Depreciating) v;
                System.out.print( " depreciates at " + d.getDepreciationRate() );
            }
            System.out.println();
        }
    }
    
    private static void printResult(List<Valuable> valuables, String expected) {
        String actual = "";
        for (Valuable v : valuables ) {
            String s = v.toString();
            if (v instanceof Depreciating) {
                Depreciating d = (Depreciating) v;
                s+= " depreciates at " + d.getDepreciationRate();
            }
            actual += s;
        }
        System.out.println( "Result: " + (expected.equals(actual) ? "Pass":"Fail") );
        System.out.println();
    }
}