package EscapeRoom.world;

import EscapeRoom.enums.Location;
import EscapeRoom.items.Item;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.Puzzle;

import java.util.*;

/**
 * The Room class represents a location in the game.
 * A room contains directional descriptions, exits,
 * items, and puzzles.
 *
 * @author Ilhan Hashi
 */
public class Room {
    //region Fields

    // Private properties.
    private String name;
    private Location location;
    private boolean requiresLight;
    private Map<String, Item> items;
    private Puzzle puzzle;
    private RoomTransition transitionListener;

    //endregion

    //region Constructor

    /**
     * Creates a new room.
     * @param name the name of the room.
     * @param location the location of the room.
     * @param requiresLight whether the room needs a light too see.
     */
    public Room(String name, Location location, boolean requiresLight) {
        this.name = name;
        this.location = location;
        this.requiresLight = requiresLight;
        this.items = new HashMap<>();
    }

    //endregion

    //region Getters

    public String getName() {return name;}
    public Location getLocation() {return location;}
    public boolean requiresLight() {return requiresLight;}
    public Puzzle getPuzzle() {return puzzle;}

    //endregion

    //region Setters

    public void setPuzzle(Puzzle puzzle) {this.puzzle = puzzle;}

    //endregion

    //region Item Movements

    /**
     * Adds an item to the room.
     * @param item the item that is being added to the room.
     */
    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public Map<String, Item> getItems() {
        return items;
    }

    //endregion

    //region Actions

    /**
     * Handles examining an item in the room.
     */
    public void onExamine(String itemName, Player player, boolean flashlightOn) {
        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking an item.
     */
    public void onTake(String itemName, Player player, boolean flashlightOn) {
        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles using an item.
     */
    public void onUse(String itemName, Player player, boolean flashlightOn) {
        System.out.println("You don't use that here.");
    }

    //endregion

    //region Room Transition

    /**
     * Sets the room transition listener.
     */
    public void setTransitionListener(RoomTransition transitionListener) {
        this.transitionListener = transitionListener;
    }

    /**
     * Transitions the player to the specified room.
     * @param destination the location being transition to.
     */
    public void transitionTo(Location destination) {
        if (transitionListener != null) {
            transitionListener.transition(destination);
        }
    }

    //endregion
}