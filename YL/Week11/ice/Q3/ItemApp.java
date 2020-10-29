import java.util.*;

public class ItemApp {
  public static void main(String[] args) {

    ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
    items.add(new Book("B001", "Java rocks", 100, 'A', "SIS"));
    items.add(new Book("B002", "OO rocks", 150, 'B', "SIS"));
    items.add(new Book("B003", "Inheritance rocks", 200, 'C', "SIS"));
    items.add(new Book("B004", "Interface rocks", 250, 'D', "SIS"));
    items.add(new Book("B005", "Exceptions rocks", 3000, 'E', "SIS"));
    items.add(new Laptop("L001", "MacBook", 2000, 'A',2));
    items.add(new Laptop("L002", "MacBookPro", 1800, 'B',3));
    items.add(new Laptop("L003", "MacBookAir", 1000, 'C',4));
    items.add(new Laptop("L004", "NetBook Fly", 700, 'D',1));
    items.add(new Laptop("L005", "xPad", 600, 'E',1));

    items.add(new Magazine("M001", "Lifestyle", 50, 'A',2));
    items.add(new Magazine("M002", "No Style", 60, 'B',3));
    items.add(new Magazine("M003", "Mugging", 70, 'C',4));
    items.add(new Magazine("M004", "Sleep", 80, 'D',5));
    items.add(new Magazine("M005", "Programming", 150, 'E',6));
    InventoryItem[] itemArr = items.toArray(new InventoryItem[items.size()]);

    List<InventoryItem> lightItems = ItemTool.getAllInventoryItemsLighterThan(items, 700);
    System.out.println("Items Lighter than 700: ");
    for (InventoryItem item : lightItems) {
      System.out.println(item.getId());
    }
    System.out.println();

    List<Magazine> magazines = ItemTool.getAllMagazines(itemArr);
    System.out.println("All Magazines: ");
    for (Magazine item : magazines) {
      System.out.println(item.getId());
    }
    System.out.println();

    List<InventoryItem> nonBookItems = ItemTool.getAllNonBooksOfCategory(itemArr, 'A');
    System.out.println("All non-book of Category: ");
    for (InventoryItem item : nonBookItems) {
      System.out.println(item.getId());
    }
    System.out.println();

    HashMap<String,InventoryItem> map = new HashMap<String,InventoryItem>();
    for (InventoryItem item : items) {
      map.put(item.getId(), item);
    }
    Laptop[] laptops = ItemTool.getAllLaptopsWithNumCpuGreaterThan(map, 2);
    System.out.println("Laptops with more than 2 cpu: ");
    for (Laptop item : laptops) {
      System.out.println(item.getId());
    }
    System.out.println();

  }
}
