import java.util.Scanner;

public class Q6PartC {
    public static void main(String[] args) {
    
        /* Creates a community garden. */
        CommunityGarden garden = new CommunityGarden("Duke Garden");

        System.out.println();

        System.out.println("Part C: getFarmerDetails");
        System.out.println("Test 1");
        System.out.println("Expected:Bill[Male]");
        System.out.println("Actual  :" + getFarmerDetails(garden, 2));
        System.out.println();
        System.out.println("Test 2");
        System.out.println("Expected:Henny[Female]");
        System.out.println("Actual  :" + getFarmerDetails(garden, 3));
        System.out.println();
        System.out.println("Test 3");
        System.out.println("Expected:available");
        System.out.println("Actual  :" + getFarmerDetails(garden, 4));
        System.out.println();
        System.out.println("Test 4");
        System.out.println("Expected:N.A.");
        System.out.println("Actual  :" + getFarmerDetails(garden, 10));
        System.out.println();
        

    }



    /*
     * Returns the name & gender of farmer who owns this plot of land.
     * garden     - the specified community garden, assumed not null.
     * plotNumber - the specified plotNumber
     *
     * If the plotNumber is invalid, return "N.A."
     * If the plot is currently vacant (i.e. not owned by any farmer),
     * return  "available".
     * Otherwise, return the farmer's name and gender
     *    e.g. "Amy[Female]"
     *    e.g. "Bill[Male]"
     */
    public static String getFarmerDetails(CommunityGarden garden, int plotNumber) {
        // insert your code here.
        return ""; // added to make this code compile.

    }

}