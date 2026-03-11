package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.items.Item;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;

/**
 * The EastRoom class represents the east room containing the mirror clue.
 *
 * @author Ilhan Hashi
 */
public class EastRoom extends Room {
    //region Fields

    private boolean clueFound = false;

    //endregion

    //region Constructor

    /**
     * Create the east room and adds the items.
     */
    public EastRoom() {
        super("East Room", Location.EAST_ROOM, true);
        addItem(new Item("mirror", "A large mirror fixed to the wall."));
    }

    //endregion

    //region Actions

    /**
     * Handles examining items in the east room.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("mirror")) {
            examineMirror(flashlightOn);
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items in the east room.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("mirror")) {
            takeMirror();
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items in the east room.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("mirror")) {
            useMirror(flashlightOn);
            return;
        }

        System.out.println("You can't use that.");
    }

    //endregion


    //region Helpers Methods

    /**
     * Examines the mirror in the east room.
     */
    private void examineMirror(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("east.mirror.dark");
            return;
        }

        if (clueFound) {
            StoryPrinter.printStoryBlock("east.mirror.afterClue");
            return;
        }

        StoryPrinter.printStoryBlock("east.mirror.light");
        clueFound = true;
    }

    /**
     * Attempts to take the mirror.
     */
    private void takeMirror() {
        System.out.println("The mirror is fixed tightly to the wall.");
        System.out.println("You cannot remove it.");
    }

    /**
     * Uses the mirror.
     */
    private void useMirror(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("east.mirror.dark");
            return;
        }

        System.out.println("You wipe some dust from the mirror.");
        System.out.println("Your reflection stares back at you.");
    }

    //endregion


    //region Clue

    /**
     * Checks if the clue in this room has been found.
     */
    @Override
    public boolean isClueFound() {
        return clueFound;
    }

    //endregion
}
