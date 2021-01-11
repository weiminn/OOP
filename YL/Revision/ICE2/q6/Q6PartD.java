import java.util.Scanner;

public class Q6PartD {
    public static void main(String[] args) {
    
        /* Creates a community garden. */
        CommunityGarden garden = new CommunityGarden("Duke Garden");

        System.out.println();

        System.out.println("Part D: getPercentageOfLeasedPlotsWithCrop");
        System.out.println("Test 1: Passed in category V(vegetable)");
        System.out.println("Expected:50.0");
        System.out.println("Actual  :" + getPercentageOfLeasedPlotsWithCrop(garden, 'V'));
        System.out.println();
        System.out.println("Test 2: Passed in category F(flower)");
        System.out.println("Expected:33.333333333333336"); 
        System.out.println("Actual  :" + getPercentageOfLeasedPlotsWithCrop(garden, 'F'));
        System.out.println("Note: output may differ slightly due to floating point error.");
        System.out.println();
    }

   
    /*
     * garden     - the specified community garden, assumed not null.
     * category   - the crop's category (F, V or H)
     * (F - Flower, V - Vegetable , H - Herb)
     *
     * Returns the percentage of leased plots (i.e.
     * plots that has a farmer) with the specified category of crop planted
     * i.e.
     *     total leased plots with specified category of crop planted
     *     ------------------------------------------------------------
     *                         total leased plots
     *
     * If there is no leased plots, print 0.0.
     * */
    public static double getPercentageOfLeasedPlotsWithCrop(CommunityGarden garden, char category) {
        // insert your code here.
        return 0.0;
       
    }
}