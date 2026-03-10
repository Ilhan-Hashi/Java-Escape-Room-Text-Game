package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * The Key class represents a key item in the game.
 *
 * @author Ilhan Hashi
 */
public class Key extends Item {
    //region Fields

    private String unlocks;

    //endregion

    //region Constructor

    /**
     * Creates a key.
     *
     * @param name the name of a key.
     * @param description the key description.
     * @param unlocks what the key unlocks.
     */
    public Key(String name, String description, String unlocks) {
        super(name, description);
        this.unlocks = unlocks;
    }

    //endregion

    //region Getters

    public String getUnlocks() {return unlocks;}

    //endregion
}