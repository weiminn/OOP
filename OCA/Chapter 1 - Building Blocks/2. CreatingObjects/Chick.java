/**
 * Chick
 */
public class Chick {

    int eggs = 0;
    String name;

    // constructor
    // special method with no return type
    // purpose is to initialize fields
    public Chick(){
        System.out.println("chick constructor");
        name = "Duke";
    }

    // do-nothing default constructor if no constructor is specified
    //public Chick(){}

    // not a constructor
    public void Chick(){}
}