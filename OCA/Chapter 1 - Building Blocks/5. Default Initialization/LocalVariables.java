public class LocalVariables {
    public static void main(String[] args){
        //local variables are defined inside method

        String str = ""; //must be initialized before used.

        int i;
        int j;
        /*
        i++; //won't compile
        cannot appear in expression untill assigned a value
        */
        
        boolean b = false;

        if (b) {
            i = 1;
            j = 1;
        } else {
            j = 1;
        }

        //compiler knows that variable is assigned in all cases
        System.out.println(j);

        /*
        won't compile
        compiler knows possibility of now assigned i
        System.out.println(i);
        */
    }
}
