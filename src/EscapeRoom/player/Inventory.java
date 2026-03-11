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
    //region Fields
    private List<Item> items = new ArrayList<>();
    //endregion

    //region Item Management

    /**
     * Adds an item to the inventory.
     * @param item the item that is being added to the inventoty.
     */
    public void addItem(Item item) {
        items.add(item);
        System.out.println("[ INVENTORY: " + item.getName() + " added.]");
    }

    /**
     * Removes an item from the inventory.
     * @param item the item being removed.
     */
    public void removeItem(Item item) {
        items.remove(item);
    System.out.println("[ INVENTORY: " + item.getName() + " removed.]");
    }

    /**
     * Gets an item from the inventory.
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
     * Check if the inventory has a specefic item.
     */
    public boolean hasItem(String itemName) {
        return getItem(itemName) != null;
    }

    /**
     * Gets all items in the inventory.
     * @return
     */
    public List<Item> getItems() {
        return items;
    }

    //endregion

    //region Display

    /**
     * Displays the player's inventoty.
     */
    public void showInventory() {

        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println();
        System.out.println("[ Inventory ]");

        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": " + item.getDescription());
        }

        System.out.println();
    }

    //endregion
}