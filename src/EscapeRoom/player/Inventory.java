package EscapeRoom.player;

import EscapeRoom.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores and manages the player's items.
 *
 * @author Ilhan Hashi
 */
public class Inventory {
    private List<Item> items = new ArrayList<>();

    //region Item Management

    /**
     * Adds an item to the inventory.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Returns an item by name.
     */
    public Item getItem(String itemName) {

        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }

        return null;
    }

    /**
     * Checks if the inventory has an item.
     */
    public boolean hasItem(String itemName) {
        return getItem(itemName) != null;
    }

    /**
     * Returns all inventory items.
     */
    public List<Item> getItems() {
        return items;
    }

    //endregion

    //region Display

    /**
     * Prints the inventory items.
     */
    public void showInventory() {

        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("Inventory:");

        for (Item item : items) {
            System.out.println("- " + item.getName());
        }

    }

    //endregion
}