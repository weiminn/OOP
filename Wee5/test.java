import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.graalvm.compiler.nodes.calc.IntegerBelowNode;

/**
 * test
 */
public class test {

    public static void main(String[] args) throws IOException {
        //read char by char
        // InputStreamReader ir = new InputStreamReader(System.in);

        // //buffer the char into chunks to collate a string
        // BufferedReader br = new BufferedReader(ir);
        
        // String bs1 = br.readLine();
        // String bs2 = br.readLine();
        // String bs3 = br.readLine();

        // System.out.println(bs1 + "  |   " + bs2 + " |   " + bs3);

        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(44);
        someList.add(4324);
        someList.add(4354);
        someList.add(4654);

        Collections.sort(someList, new CustomComparator());

    }
}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        if(a < b){
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0;
    }
}