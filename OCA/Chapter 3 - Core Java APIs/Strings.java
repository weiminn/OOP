public class Strings {
    public static void main(String[] args) {

        String s1 = "first";
        s1 = s1 + " and "; //can concatenate using + operator
        String s2 = s1.concat("second");
        //s1 will still be "first" cos immutable
        //s2 will be "firstsecond"
        
        //use String Pool
        String name = "Fluffy";
        
        //create new object
        //garbage-collected
        String name2 = new String("Fluffy");

        name.length(); //length
        name.charAt(0); //character at position
        name.indexOf("f"); //position of char, string
        name.indexOf("f", 3); //position of char, string, start searching from position 3
        name.contains("sub"); //if substring exists (case-sensitive)

        //returns String -> can chain methods
        name.substring(4, 6); //get substring starting from 4 and "stop" at 6
        name.toLowerCase(); name.toUpperCase(); //change case
        name.equals("test"); name.equalsIgnoreCase("test"); //compare strings
        name.replace("x", "y"); //replace char or substring with another char or substring
        name.trim(); //remove whitespace around string
    }
    
}
