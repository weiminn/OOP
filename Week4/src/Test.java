import a.*;//how many levels to go down
//classpath in javac will specify starting point
import LLibrary.LSubpackage.Lclass;
/**
 * test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Testing Java");
        Aclass bclass = new Aclass();
        System.out.println(bclass.toString());

        Lclass.lPrint();
    }
}