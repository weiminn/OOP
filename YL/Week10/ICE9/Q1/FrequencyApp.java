import java.util.*;

public class FrequencyApp {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word > ");
        String input = sc.nextLine();

        while(!input.equals("")){
            if(map.containsKey(input)){
                map.put(input, map.get(input)+1);
            } else {
                map.put(input, 1);
            }

            System.out.print("Enter the word > ");
            input = sc.nextLine();
        }

        Collection<String> fruits = map.keySet();
        for(String fruit: fruits){
            System.out.println(map.get(fruit) + " " + fruit);
        }
    }

    

}