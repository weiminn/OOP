import java.util.*;

public class NumberUtils {
    public static Map<Integer, Integer> calculateFrequency(int[] arr){
        if(arr == null) throw new IllegalArgumentException("Cannot be null!");
        Map<Integer, Integer> result = new HashMap<>();
        for(int i: arr){
            if(!result.containsKey(i)){
                result.put(i, 0);
            }
            result.put(i, result.get(i)+1);
        }
        return result;
    }

    public static int[] createArray(Map<Integer, Integer> freqMap){
        if(freqMap == null) throw new IllegalArgumentException("Cannot be null!");
        ArrayList<Integer> aList = new ArrayList<>();
        for (Integer key : freqMap.keySet()) {
            for (int i = 0; i < freqMap.get(key); i++) {
                aList.add(key);
            }
        }
        int[] arr = new int[aList.size()];
        for (int i = 0; i < aList.size(); i++) {
            arr[i] = aList.get(i);
        }
        return arr;
    }

    public static int max(int... args){
        if(args == null) throw new IllegalArgumentException("Cannot be null!");
        if(args.length == 0) throw new IllegalArgumentException("Cannot be Empty!");
        Integer max = null;
        for (int i = 0; i < args.length; i++){
            if (max != null) {
                max = (args[i] > max) ? args[i]: max;
            } else {
                max = args[i];
            }
        }
        return max;
    }

    public static List<Pair> findPairs(int[] arr, int value){
        List<Pair> pairs = new ArrayList<>();
        for(int i: arr){
            for (int j = i+1; j < arr.length; j++){
                if(arr[i] + arr[j] == 1){
                    pairs.add(new Pair(arr[i], arr[j]));
                }
            }
        }
        return pairs;
    }
    
    public static int findTheMissingNumber(int[] arr, int n){
        Arrays.sort(arr);
        int missingNum = 0;
        for(int i = 1; i <= n; i++){
            if(arr[i-1] != i){
                return i;
            }
        }
        return missingNum;
    }

}
