public class Mutability {
    public static void main(String[] args) {
        //StringBuffer in older Java versions
        
        StringBuilder sb = new StringBuilder("Start");

        //convert to String
        System.out.println(sb.toString());

        //concatenate
        sb.append("Middle");
        sb.append("End");

        //insert char or string at position 5
        sb.insert(5, "inserted");
        
        //delete
        sb.delete(1, 3); //delete substring starting from 1 and ending at 3 (ending means exclusive)
        sb.deleteCharAt(3); //delet only one character at position 3

        //reverse
        sb.reverse();

        //charAt, indexOf, length, subString same as String
    }
}
