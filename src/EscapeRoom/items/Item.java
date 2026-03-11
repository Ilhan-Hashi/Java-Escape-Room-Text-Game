package EscapeRoom.items;

/**
 * The Item class represents an object in the game.
 *
 * @author Ilhan Hashi
 */
public class Item implements Comparable<Item> {
    //region Fields

    // Properties.
    private final String name;
    private final String description;

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

    /**
     * Creates an item with a name and a default description.
     */
    public Item(String name) {
        this(name, "No Description");
    }


    //endregion

    // region Getters

    public String getName() {return name;}
    public String getDescription() {return description;}

    //endregion

    //region Helper Methods

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }

    //endregion
}