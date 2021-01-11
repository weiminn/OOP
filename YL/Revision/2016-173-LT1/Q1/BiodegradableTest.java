import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BiodegradableTest {
    public static void main(String[] args) {
        checkClassDeclaration();
        if (checkNumOfMethods()) {
            checkGetDaysToBiodegradeMethod();
        }
    }
    
    private static boolean checkClassDeclaration() {
        boolean result = Biodegradable.class.isInterface();
                    
        System.out.println("Test interface Biodegradable declaration: "
                +  (result?"pass":"fail") );
        System.out.println();
        
        return result;
    }
    
    private static boolean checkNumOfMethods() { 
        boolean result = Biodegradable.class.getDeclaredMethods().length == 1;
        System.out.println("Test Biodegradable has correct number of declared methods: " + (result?"pass":"fail"));
        System.out.println();
        return result;        
    }    
    
    private static boolean checkGetDaysToBiodegradeMethod() { 
        System.out.print("Test Biodegradable's getDaysToBiodegrade(): ");
        try {
            Method getDaysToBiodegrade = Biodegradable.class.getDeclaredMethod("getDaysToBiodegrade");
            int mods = getDaysToBiodegrade.getModifiers();

            boolean result = Modifier.isAbstract(mods)
                && !Modifier.isStatic(mods)
                && Modifier.isPublic(mods)
                && getDaysToBiodegrade.getReturnType().equals(Integer.TYPE);
                
            if (result) {
                System.out.println("pass");
                System.out.println();        
                return true;
            }
        } catch (NoSuchMethodException | SecurityException ex) {
            System.out.print("No such method. ");
        }
        System.out.println("fail");
        System.out.println();        
        return false;

    }
}