public class Equality {
    public static void main(String[] args) {
        String x = "Hello World";
        String y = "Hello World";

        //String literals are pools even if reference
        System.out.println((x == y) == true);

        String z = " Hello World ".trim();

        //String literals are pools even if reference
        System.out.println((x == z) == true);
    }
    
}
