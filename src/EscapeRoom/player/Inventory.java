package EscapeRoom.player;

import EscapeRoom.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class stores and manages items
 * collected by the player.
 *
 * @author Ilhan Hashi
 */
public class Inventory {
    // Private property.
    private List<Item> items;

    /**
     * Constructor that creates an empty inventory.
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the inventory,
     * @param item the item to add.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Removes an item from the inventory.
     * @param item the item to remove.
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    /**
     * Finds an item by name.
     * @param name the name of the item to search for.
     * @return the matching item or null if not found.
     */
    public Item getItemByName(String name) {
        // Check if name is null.
        if (name == null) {
            return null;
        }

        // Loop through the item list.
        for (Item item : items) {

            // Check if item and item name are not null.
            if (item != null && item.getName() != null) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }

        return null;
    }

    /**
     * Returns all items in the inventory.
     * @return the list of items.
     */
    public List<Item> getItems() {
        return items;
    }
}
