import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class ItemPackTest {
    public static void main(String[] args) {
        checkClassDeclaration();
        checkConstructors();
        if (checkNumOfMethods()) {
            checkAddItemMethod();
            checkGetItemsMethod();
        }
    }
    
    private static boolean checkClassDeclaration() {
        boolean result = Modifier.isAbstract(ItemPack.class.getModifiers())
                    && !ItemPack.class.isInterface()
                    && ItemPack.class.getSuperclass().equals(Item.class);
                    
        System.out.println("Test class ItemPack declaration: "
                +  (result?"pass":"fail") );
        System.out.println();
        
        return result;
    }
    
    private static boolean checkConstructors() {    
        System.out.print("Test ItemPack's constructors: ");
        boolean correctNumOfDeclaredConstructors = ItemPack.class.getDeclaredConstructors().length == 1;
        if (correctNumOfDeclaredConstructors) {
            try {
                ItemPack.class.getDeclaredConstructor(String.class);
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
        boolean result = ItemPack.class.getDeclaredMethods().length == 2;
        System.out.println("Test ItemPack has correct number of declared methods: " + (result?"pass":"fail"));
        System.out.println();
        return result;        
    }    
    
    private static boolean checkAddItemMethod() { 
        System.out.print("Test ItemPack's addItem(): ");
        try {
            Method addItem = ItemPack.class.getDeclaredMethod("addItem", Item.class);
            int mods = addItem.getModifiers();

            boolean result = !Modifier.isAbstract(mods)
                && !Modifier.isStatic(mods)
                && Modifier.isPublic(mods)
                && addItem.getReturnType().equals(Void.TYPE);
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
    
    private static boolean checkGetItemsMethod() { 
        System.out.print("Test ItemPack's getItems(): ");
        try {
            Method getItems = ItemPack.class.getDeclaredMethod("getItems");
            int mods = getItems.getModifiers();

            boolean result = !Modifier.isAbstract(mods)
                && !Modifier.isStatic(mods)
                && Modifier.isPublic(mods)
                && getItems.getReturnType().equals(List.class);
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