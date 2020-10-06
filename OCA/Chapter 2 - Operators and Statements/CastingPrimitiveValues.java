public class CastingPrimitiveValues {
    public static void main(String[] args) {
        //does not compile
        /*
        int x = 1.0;
        short y = 1921222
        int z = 9f;
        long t  = 1203984712321432145315;
        */

        int x = (int) 1.0;
        short y = (short) 1921222; //stored as 20678
        int z = (int) 9l;
        long t = 192301398193810323L;

        short a = 10;
        short b = 3;
        /* Does not compile
        short c = a * b;
        a and b are promoted to int
        and thus should be casted before assignment
        */

        boolean five = 5 == 5.00;
        //5 is promoted to double
        
        

        
    }
    
}
