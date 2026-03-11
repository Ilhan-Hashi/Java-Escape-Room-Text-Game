package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.items.Item;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;

/**
 * The WestRoom class represents the west room containing the bookshelf clue.
 *
 * @author Ilhan Hashi
 */
public class WestRoom extends Room {
    //region Fields
    private boolean clueFound = false;
    //endregiom

    //region Constructor

    /**
     * Creates the west room and adds the bookshelf.
     */
    public WestRoom() {
        super("West Room", Location.WEST_ROOM, true);
        addItem(new Item("bookshelf", "A tall wooden bookshelf."));
    }

    //endregion

    //region Actions

    /**
     * Handles examining objects in the west room.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("bookshelf")) {
            examineBookshelf(flashlightOn);
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items in the west room.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("bookshelf")) {
            takeBookshelf(flashlightOn);
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items in the west room.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("bookshelf")) {
            useBookshelf(flashlightOn);
            return;
        }

        System.out.println("You can't use that.");
    }

    //endregion

    //region Helpers Methods

    /**
     * Examines the bookshelf.
     */
    private void examineBookshelf(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("west.bookshelf.dark");
            return;
        }

        if (!clueFound) {
            StoryPrinter.printStoryBlock("west.bookshelf.examine");
            clueFound = true;
        } else {
            StoryPrinter.printStoryBlock("west.bookshelf.afterClue");
        }
    }

    /**
     * Attempts to take the bookshelf.
     */
    private void takeBookshelf(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("west.bookshelf.dark");
            return;
        }

        StoryPrinter.printStoryBlock("west.bookshelf.examine");
        clueFound = true;
    }

    /**
     * Uses the bookshelf.
     */
    private void useBookshelf(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("west.bookshelf.dark");
            return;
        }

        StoryPrinter.printStoryBlock("west.bookshelf.examine");
        clueFound = true;
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
