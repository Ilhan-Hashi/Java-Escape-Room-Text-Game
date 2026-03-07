package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * The Key class represents a key item in the game.
 *
 * @author Ilhan Hashi
 */
public class Key extends Item implements Usable {

    //region Fields
    private String unlocks;
    //endregion

    //region Constructor

    /**
     * Creates a key.
     */
    public Key(String name, String description, String unlocks) {
        super(name, description, true);
        this.unlocks = unlocks;
    }

    //endregion

    //region Behavior

    /**
     * Uses the key.
     */
    @Override
    public void use(Player player) {
        System.out.println("You try using the " + getName() + ".");
    }

    //endregion
}