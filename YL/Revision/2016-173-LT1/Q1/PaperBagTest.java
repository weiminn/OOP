import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class PaperBagTest {
    public static void main(String[] args) {
        checkClassDeclaration();
        checkConstructors();
        if (checkNumOfMethods()) {
            checkGetDaysToBiodegradeMethod();
        }
    }
    
    private static boolean checkClassDeclaration() {
        boolean result = !Modifier.isAbstract(PaperBag.class.getModifiers())
                    && !PaperBag.class.isInterface()
                    && PaperBag.class.getSuperclass().equals(ItemPack.class)
                    && checkInterfaces();
        
        System.out.println("Test class PaperBag declaration: "
                +  (result?"pass":"fail") );
        System.out.println();
        
        return result;
    }
    
    private static boolean checkInterfaces() {
        Class[] interfaces = PaperBag.class.getInterfaces();
        if (interfaces.length != 2) 
            return false;
        
        Class[] expectedInterfaces = { Disposable.class, Biodegradable.class };
        
        for (Class expInterface: expectedInterfaces) {
            boolean found = false;
            for ( int i=0; !found && i < interfaces.length; i++) {
                found = expInterface.equals( interfaces[i] );
            }
            if (!found) return false;
        }
        
        return true;
    }
    
    private static boolean checkConstructors() {    
        System.out.print("Test PaperBag's constructors: ");
        boolean correctNumOfDeclaredConstructors = PaperBag.class.getDeclaredConstructors().length == 1;
        if (correctNumOfDeclaredConstructors) {
            try {
                PaperBag.class.getDeclaredConstructor(String.class);
                System.out.println("pass");
                System.out.println();
                return true;
            } catch (NoSuchMethodException | SecurityException ex) {
                System.out.print("No such contructor. ");
            }
        }
        
        System.out.println("fail");
        System.out.println();
        return false;
    }
    
    private static boolean checkNumOfMethods() { 
        boolean result = PaperBag.class.getDeclaredMethods().length == 1;
        System.out.println("Test PaperBag has correct number of declared methods: " + (result?"pass":"fail"));
        System.out.println();
        return result;        
    }    
    
    private static boolean checkGetDaysToBiodegradeMethod() { 
        System.out.print("Test PaperBag's getDaysToBiodegrade(): ");
        try {
            Method getDaysToBiodegrade = PaperBag.class.getDeclaredMethod("getDaysToBiodegrade");
            int mods = getDaysToBiodegrade.getModifiers();

            boolean result = !Modifier.isAbstract(mods)
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