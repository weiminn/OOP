import java.util.ArrayList;
import java.util.List;

/**
 * ItemPack
 */
public abstract class ItemPack extends Item {
    List<Item> items;
    public ItemPack(String name) {
        super(name);
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }

    
}