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
     * @param name tbe name of the tool.
     * @param description tool description.
     */
    public Tool(String name, String description) {
        super(name, description);
        this.active = false;
    }

    //endregion

    //region Getters

    public boolean isActive() {return active;}

    //endregion

    //region void Use

    /**
     * Uses the tool.
     * @param player the player using the item.
     */
    @Override
    public void use(Player player) {
        boolean turningOn = !active;
        active = turningOn;

        if (turningOn) {
            System.out.println("You turn on the " + getName() + ".");
            System.out.println();
        } else {
            System.out.println("You turn off the " + getName() + ".");
            System.out.println();
        }
    }

    //endregion
}