public class BoxTest {

    public static void main(String[] args) {
        Box b1 = new Box (3,2,1);
        Box b2 = new Box (3,2,1);

        System.out.println("testing equals:");
        // b1.equals(b2) and b2.equals(b1) should return true
        System.out.println("b1 and b2 are equal :" + b1.equals(b2));
        System.out.println("b2 and b1 are equal :" + b2.equals(b1));
        System.out.println();

        // should print out the correct dimensions
        System.out.println("testing toString:");
        System.out.println("b1 :" + b1);
        System.out.println("b2 :" + b2);
        System.out.println();

        try {
            System.out.println("testing clone:");
            Box b3 = (Box)b1.clone();
            System.out.println("b1 :" + b1);
            System.out.println("b3 :" + b3);
            System.out.println();

            b1.setHeight(5); // change the height of b1
            // the height of b3 should be independent from the height of b1
            System.out.println("after changing the height of b1:");
            System.out.println("b1 :" + b1);
            System.out.println("b3 :" + b3);
        } catch (Exception e) {
            //TODO: handle exception
        }
        

        

    }
}
