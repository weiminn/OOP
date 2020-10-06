import java.util.Date;

public class ReferencesAndPrimitives {

    //primitives

    // numbers without decimal points
    byte b; // 8-bit integral -128 to 127
    short s; // 16-bit integral
    int i; // 32-bit integral
    long l; // 64-bit integral

    // decimal
    float f; // 32-bit floating point
    double d; // 64-bit floating point

    char c; // 16-bit unicode
    boolean bl; // true or false

    // Java assumes int declaration by default
    // long max = 3123456789; doesn't compile; out of range
    long max2 = 3123456789L; // tell Java it is long

    // find range
    { System.out.println(Integer.MAX_VALUE); }

    // reference types
    // points to an object by storing memory address
    String greeting = "How are you";
    Date today = new Date();

    // int value = null; doesn't compile; no null in int
    String str = null; // address can be null
    
    
}
