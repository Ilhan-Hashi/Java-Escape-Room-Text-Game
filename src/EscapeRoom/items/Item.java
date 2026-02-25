package EscapeRoom.items;

/**
 * The item class reprsents a basic object that can
 * exist in a room or in the player's inventory.
 *
 * @author  Ilhan Hashi
 */
public class Item {
    // Properties.
    private String name;
    private String description;

    /**
     * Creates a new item with a name and description.
     *
     * @param name The name of the item.
     * @param description A short description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     *
     * Returns the name of the item.
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the item.
     *
     * @return item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the string representation of the item.
     * @return the name of the item.
     */
    @Override
    public String toString() {
        return name;
    }
}
