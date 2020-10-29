import java.util.*;

public class IteratorEx {

    public static void main(String[] args) {
        List<String> flavours = new ArrayList<String>();
        flavours.add("chocolate");
        flavours.add("strawberry");
        flavours.add("vanilla");
        flavours.add("durian");
        flavours.add("lychee");
        flavours.add("weird");
        flavours.add("lime");   

        removeMatches(flavours, "weird");
        printAllFlavours(flavours);
        System.out.println("There are " + flavours.size() + " flavours");
    }

    private static void printAllFlavours( List<String> aFlavours ) {
        Iterator<String> flavoursIter = aFlavours.iterator();
        while (flavoursIter.hasNext()){
            String currentFlavour = flavoursIter.next();
            System.out.println(currentFlavour);
        }
    }

    private static void removeMatches (List<String> aFlavours, String toMatch){
        // TODO: Insert code here
        Iterator<String> iter = aFlavours.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            if(next.equals(toMatch)) {
                iter.remove();
            }
        }
    }
}
