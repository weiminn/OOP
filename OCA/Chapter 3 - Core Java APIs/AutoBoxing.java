import java.util.*;
public class AutoBoxing {
    public static void main(String[] args) {
        ArrayList<Double> weights = new ArrayList<>();

        //can put primitive as argument
        //automatically converts to wrapper class
        weights.add(50.0); 

        //unboxing
        //converts to primitive
        double w = weights.get(0);

    }
    
}
