package EscapeRoom.player;

import EscapeRoom.world.Room;

/**
 * The Player class represents the user playing the game.
 * It tracks the player's current location and inventory.
 *
 * @author Ilhan Hashi
 */
public class Player {
    // Unique database ID for the player.
    private int id;

    // Username chosen by the player
    private String userName;

    // Player's inventory.
    private Inventory inventory;

    /**
     * Constructor used when loading player from database.
     * @param id the unique database ID
     * @param userName the player's username
     */
    public Player(int id, String userName) {
        this.id = id;
        this.userName = userName;
        this.inventory = new Inventory();
    }

    /**
     * Returns the player's username.
     * @return the player's username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the player's inventory.
     * @return the player's inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }

}
