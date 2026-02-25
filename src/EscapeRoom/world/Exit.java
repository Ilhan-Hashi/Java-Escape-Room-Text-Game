package EscapeRoom.world;

import EscapeRoom.items.Item;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.Puzzle;

/**
 * The Exit class represents a connection from one room
 * to another. An exit may be locked and require either
 * a key or a solved puzzle to become accessible.
 *
 * @author Ilhan Hashi
 */
public class Exit {
    // The room this exit leads to.
    private Room destination;

    // Indicates whether the exit is currently locked.
    private boolean locked;

    // The name of the key required to unlock this exit.
    private String requiredItemName;

    // The puzzle required to unlock this exit.
    private Puzzle requiredPuzzle;

    // Indicates whether this exit leads to the final win state.
    private boolean finalExit;

    /**
     * Constructor that creates an unlocked exit leading to another room.
     * @param destination the room this exit leads to.
     */
    public Exit (Room destination) {
        this.destination = destination;
        this.locked = false;
    }

    /**
     * Constructor that creates a locked exit requiring a specific key.
     * @param destination the room this exit leads to.
     * @param requiredItemName the name of the required key.
     */
    public Exit(Room destination, String requiredItemName) {
        this.destination = destination;
        this.requiredItemName = requiredItemName;
        this.locked = true;
    }

    /**
     * Constructor that creates a locked exit requiring a solved puzzle.
     * @param destination the room this exit leads to.
     * @param requiredPuzzle the puzzle that must be solved.
     */
    public Exit(Room destination, Puzzle requiredPuzzle) {
        this.destination = destination;
        this.requiredPuzzle = requiredPuzzle;
        this.locked = true;
    }

    /**
     * Determines whether the player can use this exit.
     * The exit becomes unlocked if the required puzzle
     * is solved or the required key is present.
     * @param player the player attempting to use the exit.
     * @return true if the exit is accessible, false otherwise.
     */
    public boolean isAccessible(Player player) {

        // If the exit is not locked, it is accessible.
        if (!locked) {
            return true;
        }

        // Check if a puzzle is required and solved.
        if (requiredPuzzle != null && requiredPuzzle.isSolved()) {
            unlock();
            return true;
        }

        // Check if a specific key is required.
        if (requiredItemName != null) {

            Item item = player.getInventory().getItemByName(requiredItemName);

            if (item != null) {
                unlock();
                return true;
            }
        }

        return false;
    }

    /**
     * Unlocks the exit.
     */
    public void unlock() {
        this.locked = false;
    }

    /**
     * Returns the destination room.
     * @return destination.
     */
    public Room getDestination() {
        return destination;
    }

    /**
     * Return whether this exit leads to the final win state.
     * @return
     */
    public boolean isFinalExit() {
        return finalExit;
    }

    /**
     * Sets whether this exit is the final exit.
     * @param finalExit true if this is the final exit.
     */
    public void setFinalExit(boolean finalExit) {
        this.finalExit = finalExit;
    }
}
