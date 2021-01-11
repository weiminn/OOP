/**
 * AccessModifiers
 */
public abstract class DesigningMethods {

    //JAVABEANS naming convention
    //getter/setter methods start with get/is/set

    // Access modifier optional
    // Cannot be after return
    public final void nap(int minutes) throws InterruptedException {
        
    }

    // Can call from any class
    public void pubMethod() {

    }

    // Can only call from same class
    private void priMethod() {
        
    }

    // Can only be called from same package or subclasses
    protected void proMethod() {
        
    }

    // Default Package Access
    // no keyword
    void pkgMethod() {
        
    }

    //////////////////////////////////////////////////////
    
    // Optional specifier optional
    // Can be before Access Modifier
    // Cannot be after Return Type

    // Class Methods
    static void staticMethod(){

    }
    
    // Not providing a method body
    // Cannot be private or static
    abstract void abstractMethod();

    // Not allowed to be overridden
    final void finalMethod(){}

    ///////////////////////////////////////////////

    // Return type required
    
    ///////////////////////////////////////////////
    
    // Method name required

    // Can only start with letters, $ or _
    // Can not have @
    // Can not be reserved words
    // Can not appear before Return Type

    ///////////////////////////////////////////////

    // Parameter list required by can be empty

    //////////////////////////////////////////////

    // Exception list optional

    // Can throw as many exceptions as you want
    public void someExceptions() throws
    IllegalAccessException, InterruptedException {}

    //////////////////////////////////////////////

    // Method body required but can be empty

    //////////////////////////////////////////////


}