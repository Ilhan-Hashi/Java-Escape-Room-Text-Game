package EscapeRoom.player;

import EscapeRoom.world.Room;

/**
 * The Player class represents the user playing the game.
 * It tracks the player's current location and inventory.
 *
 * @author Ilhan Hashi
 */
public class Player {
    //region Fields

    // Unique database ID for the player.
    private int id;
    private final String userName;
    private Inventory inventory;

    //endregion

    //region Constructor

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

    //endregion

    //region Getters

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

    //endregion

    //region Helper Methods

    /**
     * Returns a simple string showing the player's id and username.
     */
    @Override
    public String toString() {
        return "Player{id=" + id + ", userName='" + userName + "'}";
    }

    //endregion
}
