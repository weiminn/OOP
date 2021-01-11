import java.lang.reflect.Array;
import java.util.*;

public class ItemTool {
    public static List<InventoryItem> getAllInventoryItemsLighterThan(List<InventoryItem> items, double weight){
        if(items == null) return null;
        if(items.size() == 0) return null;

        List<InventoryItem> toReturn = new ArrayList<>();
        for (InventoryItem inventoryItem : items) {
            if(inventoryItem.getWeight() < weight){
                toReturn.add(inventoryItem);
            }
        }
        return toReturn;
    }

    
    public static List<Magazine> getAllMagazines(InventoryItem[] items){
        if(items == null) return null;
        if(items.length == 0) return null;

        List<Magazine> toReturn = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if(items[i] instanceof Magazine){
                toReturn.add((Magazine) items[i]);
            }
        }
        return toReturn;
    }

    public static List<InventoryItem> getAllNonBooksOfCategory(InventoryItem[] items, char category){
        if(items == null) return null;
        if(items.length == 0) return null;

        List<InventoryItem> toReturn = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if(!(items[i] instanceof Book) && items[i].getCategory() == category){
                toReturn.add(items[i]);
            }
        }
        return toReturn;

    }

    public static Laptop[] getAllLaptopsWithNumCpuGreaterThan(Map<String, InventoryItem> map, int cpu){
        if(map == null) return null;

        List<Laptop> lArr = new ArrayList<>();
        for(String key: map.keySet()){
            if((map.get(key) instanceof Laptop) && ((Laptop) map.get(key)).getNumCpu() > cpu){
                lArr.add((Laptop) map.get(key));
            }
        }

        return lArr.toArray(new Laptop[lArr.size()]);
    }
}
