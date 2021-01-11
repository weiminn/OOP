public class PartAndQuantity {

    public static void enterPartAndQuantity (int a, int b) {

        if(a < 0){
            throw new IllegalArgumentException("The part number is too low.");
        }
        if(a > 999){
            throw new IllegalArgumentException("The part number is too high.");
        }
        if(b < 1){
            throw new IllegalArgumentException("The quantity ordered is too low.");
        }
        if(b > 5000){
            throw new IllegalArgumentException("The quantity ordered is too high.");
        }

        System.out.println("Successfully insered order.");
    }

    
    
}
