public class PartAndQuantityEntry {
    static void enterPartAndQuantity(int a, int b) throws IllegalArgumentException{
        if(a < 0){
            throw new IllegalArgumentException("Part number too low!");
        }
        if(a > 999){
            throw new IllegalArgumentException("Part number too high!");
        }
        if(b < 1){
            throw new IllegalArgumentException("Quantity too low!");
        }
        if(b > 5000){
            throw new IllegalArgumentException("Quantity too high!");
        }
    }
    
}
