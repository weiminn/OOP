public class Swan {

    //static variables and static initializers run first
    //instance variables and initializers second
    //in the order they appear
    //constructors last

    int eggs;

    // code block outside a method
    // aka instance initializer
    // called before constructor
    {
        System.out.println("Setting field");

        //name = "fluffy"; doesn't compile; order matters
    }

    String name;

    // constructor runs after all the fields and instance initializer has run
    public Swan() {
        super();
    }

    public static void main(String[] args) {
        Swan mother = new Swan();
        mother.eggs = 1; // set variable
        System.out.println(mother.eggs); // read variable


        // code block
        // usually inside a method
        // runs when method is called
        {

        }
    }
    
}
