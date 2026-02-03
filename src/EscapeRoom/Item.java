package EscapeRoom;

/**
 * Represents an item that can exist in the game.
 * Items may be collected, examined, or used by the player.
 *
 *  * @author Ilhan Hashi
 *  * @course Java Part 2
 */
public class Item {
    // Private fields for the name of the item.
    // A brief description of the item.
    private String name;
    private String description;

    /**
     * Default constructor.
     * Creates an empty item with no name or description.
     */
    public Item() { };

    /**
     * Constructs an Item with a name and description.
     * @param name the name of the item.
     * @param description the description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the name of the item.
     * @return the item name.
     */
    public String getName() {return name;}

    /**
     * Sets the name of the item.
     * @param name the new item name.
     */
    public void setName(String name) {this.name = name;}

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
}
