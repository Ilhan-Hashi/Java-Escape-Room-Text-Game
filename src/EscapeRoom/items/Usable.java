package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * The Usable interface represents behavior
 * for items that can be used by the player.
 *
 * @author Ilhan Hashi
 */
public interface Usable {
    /**
     * Defines what happens when the item is used.
     * @param player the player using the item.
     */
    void use(Player player);
}
