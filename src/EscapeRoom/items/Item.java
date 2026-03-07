package EscapeRoom.items;

/**
 * The Item class represents an object in the game.
 *
 * @author Ilhan Hashi
 */
public class Item {

    //region Fields
    private String name;
    private String description;
    private boolean takeable;
    //endregion

    //region Constructor

    /**
     * Creates an item.
     */
    public Item(String name, String description, boolean takeable) {
        this.name = name;
        this.description = description;
        this.takeable = takeable;
    }
    //endregion

    //region Getters

    /**
     * Returns the item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the item can be taken.
     */
    public boolean isTakeable() {
        return takeable;
    }
    //endregion

    //region Behavior

    /**
     * Prints the item description.
     */
    public void examine() {
        System.out.println(description);
    }
    //endregion
}