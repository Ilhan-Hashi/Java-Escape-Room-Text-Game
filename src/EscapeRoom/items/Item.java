package EscapeRoom.items;

/**
 * Represents an item that can exist in the game.
 * Items may be collected, examined, or used by the player.
 *
 * Example: A class that uses the Usable interface.
 *
 * @author Ilhan Hashi
 * @course Java Part 2
 */
public class Item implements Usable {
    // Private fields for the name of the item.
    // A brief description of the item.
    // Tracks whether the item has been used.
    private String name;
    private String description;
    private boolean used;

    /**
     * Default constructor.
     * Creates an empty item with no name or description.
     * Initializes the used status to false.
     */
    public Item() {
        this.used = false;
    }

    /**
     * Constructs an Item with a name and description.
     * @param name the name of the item.
     * @param description the description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.used = false;
    }

    /**
     * Returns the name of the item.
     * @return the item name.
     */
    public String getName() {return name;}

    /**
     * Returns the description of the item.
     * @return the item description.
     */
    public String getDescription() {return description;}

    /**
     * Sets the description of the item.
     * @param description the new item description.
     */
    public void setDescription(String description) {this.description = description;}

    /**
     * Uses the item and marks it as used.
     */
    public void use() {
        System.out.println("items " + name + " is used.");
        used = true;
    }

    /**
     * Displays the description of the item.
     */
    public void examine() {
        System.out.println(description);
    }

    /**
     * Checks whether the item has been used.
     * @return true or false if the item has been used.
     */
    public boolean isUsed() {
        return used;
    }
}
