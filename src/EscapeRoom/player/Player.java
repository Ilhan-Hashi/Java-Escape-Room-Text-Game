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

    // Current location in the game.
    private Room currentRoom;

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
     * Constructor used when starting a new game.
     * @param id the unique database ID
     * @param userName the player's username
     * @param startingRoom the room where the player begins
     */
    public Player(int id, String userName, Room startingRoom) {
        this.id = id;
        this.userName = userName;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
    }

    /**
     * Returns the player's unique database ID.
     * @return the player's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the player's username.
     * @return the player's username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the player's current room.
     * @return the room of the player.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Updates the player's current room.
     * @param currentRoom the player's current room.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Returns the player's inventory.
     * @return the player's inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }
}
