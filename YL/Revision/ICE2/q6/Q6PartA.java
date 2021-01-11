import java.util.Scanner;

public class Q6PartA {
    public static void main(String[] args) {
    
        /* Creates a community garden. */
        CommunityGarden garden = new CommunityGarden("Duke Garden");


        System.out.println("Part A: InsertPlot");
        insertPlot(garden, 40, 60);
        System.out.println("Expected:9");
        System.out.println("Actual  :" + garden.getTotalPlots());

        System.out.println();

    }

    /*
     * Adds a new Plot object to the specified garden.
     *
     * garden - the specified community garden, assumed not null.
     * length - the plot's length
     * breadth  - the plot's breadth
     *
     * Note: There is no need to create a Plot object.
     */

    public static void insertPlot(CommunityGarden garden, int length, int breadth) {
        // insert your code here.
        
    }

}