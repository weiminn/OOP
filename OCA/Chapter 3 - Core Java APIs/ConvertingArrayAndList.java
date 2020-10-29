import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertingArrayAndList {
    public static void main(String[] args) {
        
        List<String> list = new ArrayList();
        list.add("str");

        //returns Object-type array
        Object[] _list = list.toArray();

        //can specify type in parameter
        String[] slist = list.toArray(new String[0]);

        //Getting ArrayList from array
        String[] arr = {"hawk", "robin"};
        //creates a backed List
        //change element in list also reflects in array
        //and vice versa
        //can't remove element in list because tied to array
        List<String> aList = Arrays.asList(arr);
    }
    
}
