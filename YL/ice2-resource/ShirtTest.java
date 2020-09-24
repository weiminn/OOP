public class ShirtTest {
    public static void main(String[] args) {
        Shirt shirt1 = new Shirt('r', 85.50, "SMUgger");
        Shirt shirt2 = new Shirt('b', 90.40, "SMUgger");
        Shirt shirt3 = new Shirt('g', 85.50);

        System.out.println("s1 same brand as s2:" + shirt1.isSameBrand(shirt2));
        System.out.println("s1 same brand as s2:" + shirt2.isSameBrand(shirt3));
        System.out.println(shirt1.toString());
        System.out.println(shirt2.toString());
        System.out.println(shirt3.toString());
    }
}
