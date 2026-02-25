package EscapeRoom.player;

import EscapeRoom.world.Room;

/**
 * The Player class represents the user playing the game.
 * It tracks the player's current location and inventory.
 *
 * @author Ilhan Hashi
 */
public class Player {
    // Private fields.
    private String name;
    private Room currentRoom;
    private Inventory inventory;

    /**
     * Creates a player with a name and starting room.
     * @param name The player's name.
     * @param startingRoom The room where the player begins.
     */
    public Player(String name, Room startingRoom) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
    }

    /**
     * Returns the player's name.
     * @return the name of the player.
     */
    public String getName() {
        return name;
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
