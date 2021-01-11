import java.util.Scanner;

public class Q6PartB {
    public static void main(String[] args) {
    
        /* Creates a community garden. */
        CommunityGarden garden = new CommunityGarden("Duke Garden");


        System.out.println();

        System.out.println("Part B: getNumSmallLandPlots");
        System.out.println("Expected:3");
        System.out.println("Actual  :" + getNumSmallLandPlots(garden, 3000));

        System.out.println();
    }

    /*
     * Returns the number of plots in the specified garden
     * whose area is smaller than the specified area.
     * garden   - the specified community garden, assumed not null.
     * area     - the specified area
     *
     * Note: Although you can use a for loop here, it is not necessary.
     */
    public static int getNumSmallLandPlots(CommunityGarden garden, int area) {
        // insert your code here.
        return 0;

    }

}