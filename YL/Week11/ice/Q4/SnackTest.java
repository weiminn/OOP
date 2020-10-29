/**
 * Created by yeowleong on 13/5/15.
 */
public class SnackTest {
    public static void main(String[] args) {
        Snack kitKat = new Snack("Kit kat", 5.6, 400, "Nestle", 250);
        Snack bun = new Snack("Meat Bun", 1.2, 200, "Kong Guan");
        Snack nuts = new Snack("Fruits & Nuts Fusion", 6, "Tai Sun", 150);

        System.out.println(kitKat);
        System.out.println(bun);
        System.out.println(nuts);
    }
}
