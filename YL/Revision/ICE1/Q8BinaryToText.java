import java.util.*;

public class Q8BinaryToText {
    public static void main(String[] args) {
        String bString = "01010100011010000110100101110011001000000110100101110011001000000110011001110101011011100110111001111001001000000011110100101001";
        List<String> bWords = new ArrayList<>();
        List<Character> tWords = new ArrayList<>();

        for (int i = 1; i <= bString.length(); i++){
            if(i % 8 == 0){
                bWords.add(bString.substring(i-7, i));
                tWords.add(btoc(bString.substring(i-7, i)));
                System.out.print(btoc(bString.substring(i-7, i)));
            }
        }
    }

    public static char btoc(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(s.length()-1-i))) * Math.pow(2, i);
        }
        return (char) sum;
    }
}