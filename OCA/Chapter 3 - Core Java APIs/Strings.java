public class Strings {
    public static void main(String[] args) {

        String s1 = "first";
        String s2 = s1.concat("second");
        //s1 will still be "first" cos immutable
        //s2 will be "firstsecond"
        
        //use String Pool
        String name = "Fluffy";
        
        //create new object
        //garbage-collected
        String name2 = new String("Fluffy");



    }
    
}
