package EscapeRoom.items;
/**
 * The Usable interface represents an item
 * that can be used and examined in the game.
 *
 * Example: Class interface with at least four methods.
 *
 * @author Ilhan Hashi
 * @course Java Part 2
 */
public interface Usable {
    /**
     * Performs the action of the using item.
     */
    public void use();

    /**
     * Displays information about the item.
     */
    public void examine();

    /**
     * Returns the name of the item.
     * @return the item's name.
     */
    public String getName();

    /**
     * Determines whether the item has been used.
     * @return true or false whether if the item has been used.
     */
    public boolean isUsed();
}
