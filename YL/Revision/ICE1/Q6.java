import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string:");
        String input1 = sc.nextLine();
        System.out.print("Enter the second string:");
        String input2 = sc.nextLine();
        System.out.println();

        if (matchStrings(input1, input2)) {
            System.out.println("There is an alignment as shown above.");
        } else {
            System.out.println("No alignment can be found.");
        }
    }

    // This method returns true if str2 can be aligned with str1 
    // and false otherwise. If there is an alignment, this method 
    // also prints out the alignment. See the sample runs of the 
    // program for exact output of this method.
    public static boolean matchStrings(String str1, String str2) {
        // Modify the code below to return the correct value.
        String toPrint = "";
        Queue<Character> s2Q = new ArrayDeque<>();
        for(int i = 0; i < str2.length(); i++){
            s2Q.add(str2.charAt(i));
        }
        
        char c = s2Q.peek();
        for(int j = 0; j < str1.length(); j++){
            if(c == str1.charAt(j)){
                toPrint += c;
                s2Q.remove();
                
                if(!s2Q.isEmpty()){
                    c = s2Q.peek();
                }
                
            } else {
                toPrint += " ";
            }
            
            if(s2Q.isEmpty()){
                System.out.println(str1);
                System.out.println(toPrint);
                return true;
            }
        }
            
        return false;
    }

}
