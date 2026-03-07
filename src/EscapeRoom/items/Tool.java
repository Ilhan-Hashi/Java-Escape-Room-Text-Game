package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * The Tool class represents a usable tool in the game.
 *
 * @author Ilhan Hashi
 */
public class Tool extends Item implements Usable {

    //region Fields
    private boolean active;
    //endregion

    //region Constructor

    /**
     * Creates a tool.
     */
    public Tool(String name, String description) {
        super(name, description, true);
        this.active = false;
    }

    //endregion

    //region Getters

    /**
     * Returns whether the tool is active.
     */
    public boolean isActive() {
        return active;
    }

    //endregion

    //region Behavior

    /**
     * Uses the tool.
     */
    @Override
    public void use(Player player) {
        active = !active;

        if (active) {
            System.out.println("You turn on the " + getName() + ".");
        } else {
            System.out.println("You turn off the " + getName() + ".");
        }
    }

    //endregion
}