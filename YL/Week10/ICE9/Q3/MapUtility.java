import java.util.*;

public class MapUtility {


    public static void main(String[] args) {
        Map<String,String> input = new HashMap<>();
        input.put("Alfred", "81");
        input.put("Elise", "61");
        input.put("Billy", "41");
        input.put("Daniel", "41");
        input.put("Charlie", "54");


        System.out.println("Input:  " + input);
        Map<String,List<String>> result = reverse(input);
        System.out.println("Output: " + result);

    }

    static Map<String, List<String>> reverse(Map<String, String> input){
        Map<String, List<String>> toReturn = new HashMap<>();
        for (String key : input.keySet()) {
            if(toReturn.containsKey(input.get(key))){
                toReturn.get(input.get(key)).add(key);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(key);
                toReturn.put(input.get(key), newList);
            }
        }
        return toReturn;
    }
}
