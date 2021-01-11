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

    //octal
    int octNum = 017;
    //hexa
    int hexNum = 0xFF;
    //binary
    int binNum = 0b10;

    //Can also be assigned to primitive types
    //hexa
    double _hexNum = 0xFF;
    //binary
    double _binNum = 0b10;

    //underscore for easier read
    //can be anywhere but start, end or beside decimal point
    int million = 1_00_0;

    // find range
    { System.out.println(Integer.MAX_VALUE); }

    // reference types
    // points to an object by storing memory address
    String greeting = "How are you";
    Date today = new Date();

    // int value = null; doesn't compile; no null value in int
    String str = null; // address can be null

    //DOES NOT COMPILE
    //lossy conversion
    // int j = 9.0;
    // int k = 9L;
    
    
}
