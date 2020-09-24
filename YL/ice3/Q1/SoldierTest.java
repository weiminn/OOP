/**
 * Created by yeowleong on 26/4/16.
 */
public class SoldierTest {
    public static void main(String[] args) {
        Commando c = new Commando("Peter", 5000, 200);
        Soldier s = new Soldier("John", 3000);

        System.out.println(c);
        System.out.println(s);

        System.out.println("Commando's base allowance : " + c.getBaseAllowance());
        System.out.println("Commando's gross allowance : " + c.getGrossAllowance());
        System.out.println("Soldier's base allowance : " + s.getBaseAllowance());
        System.out.println("Soldier's gross allowance : " + s.getGrossAllowance());



    }
}
