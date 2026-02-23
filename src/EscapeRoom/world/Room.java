package EscapeRoom.world;

import EscapeRoom.items.Item;
import EscapeRoom.puzzles.Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Room class represents a location in the game.
 * A room contains directional descriptions, exits,
 * items, and puzzles.
 *
 * @author Ilhan Hashi
 */
public class Room {
    // Basic room information.
    private String name;
    private String description;

    // Stores descriptive content for each direction.
    private Map<Direction, String> wallDescriptions;

    // Stores exits mapped to directions.
    private Map<Direction, Exit> exits;

    // Stores items currently in the room.
    private List<Item> items;

    // Stores puzzles in the room.
    private List<Puzzle> puzzles;

    /**
     * Constructor to create a room with a name and description.
     * @param name the name of the room.
     * @param description the description of the room.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.wallDescriptions = new HashMap<>();
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.puzzles = new ArrayList<>();
    }

    /**
     * Returns the name of the room.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for a specific direction.
     * @param direction the direction to describe.
     * @param description the description for that direction.
     */
    public void setWallDescription(Direction direction, String description) {
        wallDescriptions.put(direction, description);
    }

    /**
     * Returns the description for a specific direction.
     * @param direction the direction requested.
     * @return description of that wall.
     */
    public String getWallDescription(Direction direction) {
        return wallDescriptions.get(direction);
    }

    /**
     * Sets an exit for a given direction.
     * @param direction the direction of the exit.
     * @param exit the exit object.
     */
    public void setExit(Direction direction, Exit exit) {
        exits.put(direction, exit);
    }

    /**
     * Returns the exit in a given direction.
     * @param direction the direction requested.
     * @return the Exit object or null if none exists.
     */
    public Exit getExit(Direction direction) {
        return exits.get(direction);
    }

    /**
     * Adds an item to the room.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the room.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Returns all items in the room.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Adds a puzzle to the room.
     */
    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    /**
     * Returns all puzzles in the room.
     */
    public List<Puzzle> getPuzzles() {
        return puzzles;
    }
}
