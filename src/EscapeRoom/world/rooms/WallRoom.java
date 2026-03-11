package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;

/**
 * Represents a wall with a door that leads to another room.
 *
 * @author Ilhan Hashi
 */
public class WallRoom extends Room {
    //region Fields

    private Location destination;
    private String enterLightKey;
    private String enterDarkKey;

    //endregion

    //region Constructor

    /**
     * Creates a wall room that leads to another room.
     *
     * @param name the name of the room.
     * @param location the room location.
     * @param destination the room this wall leads to.
     * @param enterLightKey story key when light is available.
     * @param enterDarkKey story key when it is dark.
     */
    public WallRoom(String name, Location location, Location destination,
                    String enterLightKey, String enterDarkKey) {
        super(name, location, false);
        this.destination = destination;
        this.enterLightKey = enterLightKey;
        this.enterDarkKey = enterDarkKey;
    }

    //endregion

    //region Actions

    /**
     * Handles examining items on the wall.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("door")) {
            enterRoom(flashlightOn);
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items on the wall.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("door")) {
            System.out.println("The door is far too heavy to move.");
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items on the wall.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("door")) {
            enterRoom(flashlightOn);
            return;
        }

        System.out.println("You can't use that.");
    }

//endregion

    //region Helpers Methods

    /**
     * Enters the connected room.
     */
    private void enterRoom(boolean flashlightOn) {

        if (flashlightOn) {
            StoryPrinter.printStoryBlock(enterLightKey);
        } else {
            StoryPrinter.printStoryBlock(enterDarkKey);
        }

        transitionTo(destination);
    }

    //endregion
}
