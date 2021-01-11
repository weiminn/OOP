import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    
    public static void main(String[] args) {

        //OLD way Java ver. <5
        ArrayList list1 = new ArrayList(); //default number of elements
        ArrayList list2 = new ArrayList(23); //specific size
        ArrayList list3 = new ArrayList(list2); //copy both size and contents

        //Java ver. 5>=
        //generics introducted
        //user Wrapper classes for primiticves
        ArrayList<Integer> list4 = new ArrayList<Integer>();

        //Java ver. 7>=
        //can omit type in right side
        ArrayList<String> list5 = new ArrayList<>();
        
        //adding
        //other methods in Java.Collections uses boolean in their algo
        boolean res = list5.add("str");
        //add to index
        list5.add(1, "str2");

        //remove at index
        list5.remove(1);
        //removes only one match
        boolean res2 = list5.remove("str");

        //changes element without changing the size
        list5.set(1, "newStr");

        boolean isEmpty = list5.isEmpty();
        int size = list4.size();

        //discard all elements
        list5.clear();

        //check for a value
        boolean containsStr = list5.contains("str");

        boolean isEqual = list4.equals(list5);

        //sorting
        Collections.sort(list4);

    }
}
