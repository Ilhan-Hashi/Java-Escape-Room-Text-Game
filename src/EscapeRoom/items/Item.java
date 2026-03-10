package EscapeRoom.items;

/**
 * The Item class represents an object in the game.
 *
 * @author Ilhan Hashi
 */
public class Item {
    //region Fields

    // Properties.
    private String name;
    private String description;

    //endregion

    //region Constructor

    /**
     * Creates a new item.
     * @param name the name of the item.
     * @param description the description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //endregion

    // region Getters

    public String getName() {return name;}
    public String getDescription() {return description;}

    //endregion
}