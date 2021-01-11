public class Operators {
    public static void main(String[] args) {

        //Unary
        int x = -2; boolean b = true; boolean a = true;
        //get the negated value of x and b
        x = -x; 
        b = !b;

        //Ternary
        int weight = 1000;
        //right hand side returns either of two values
        String animal = (weight > 500)? "Elephant": "Donkey";

        //Logical
        //evaluates both exceptions
        if(a & b){} //and
        if(a | b){} //inclusive or
        if(a ^ b){} //exclusive or

        //short circuit
        //evaluates untill first false
        if(a && b){} //and
        if(a || b){} //inclusive or

        
    }
    
}
