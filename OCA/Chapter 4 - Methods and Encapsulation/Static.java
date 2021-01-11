//import static method
import static java.util.Arrays.asList;

//can Not import class
//import static java.util.Arrays;

//import keyword comes first, then static
//static import java.util.Arrays.*;

//can NOT import two static variables or methods with same name

public class Static {
    public static void main(String[] args) {
        Koala koala = new Koala();
        koala = null;

        //looks up class's variable because it's static
        //no need to have object instance
        //there's only one copy
        System.out.println(koala.count);

        //using static import
        List<Integer> list = asList(1, 2, 3);

        //does NOT compile
        // Arrays.asList(2, 34, 5);
    }
    
}

class Koala {
    public static int scount; //only one copy
    public final int fcount; //every instance's constant need to be initialized in constructor
    public static final int sfcount = 34; //need to initialize straight away | cannot update via constructor cos final for one copy
    public static final int _sfcount; //can be initialized in static initializer but not nother static methods

    static {
        _sfcount = 34;
    }

    //run when the class is first used
    static {
        int a = 234;
        int b = 432;
    }

    public Koala() {
        fcount = 3;
    }
}