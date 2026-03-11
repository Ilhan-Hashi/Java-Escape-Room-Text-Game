package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.items.Item;
import EscapeRoom.items.Key;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;

/**
 * The NorthRoom class represents the north room containing the drawer clue.
 *
 * @author Ilhan Hashi
 */
public class NorthRoom extends Room {
    //region Fields

    private boolean drawerUnlocked = false;
    private boolean drawerOpen = false;
    private boolean clueFound = false;

    //endregion

    //region Constructor

    /**
     * Creates the north table and adds the table.
     */
    public NorthRoom() {
        super("North Room", Location.NORTH_ROOM, true);
        addItem(new Item("table", "A small wooden table with a locked drawer."));
    }

    //endregion

    //region Actions

    /**
     * Handles examining items in the north room.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("table")) {
            examineTable(flashlightOn);
            return;
        }

        if (itemName.equalsIgnoreCase("drawer")) {
            examineDrawer(flashlightOn);
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items in the north room.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("table")) {
            takeTable();
            return;
        }

        if (itemName.equalsIgnoreCase("drawer")) {
            takeDrawer();
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items in the north room.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("table") || itemName.equalsIgnoreCase("drawer")) {
            useDrawer(flashlightOn);
            return;
        }

        if (itemName.equalsIgnoreCase("key") || itemName.equalsIgnoreCase("brass key")) {
            useKey(player, flashlightOn);
            return;
        }

        System.out.println("You can't use that.");
    }

    //endregion

    //region Helpers Methods

    /**
     * Examines the table.
     */
    private void examineTable(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("north.table.dark");
            return;
        }

        if (!drawerUnlocked) {
            StoryPrinter.printStoryBlock("north.table.examine");
            StoryPrinter.printStoryBlock("north.drawer.locked");
            return;
        }

        if (!drawerOpen) {
            StoryPrinter.printStoryBlock("north.table.examine");
            System.out.println("The drawer is unlocked.");
            return;
        }

        StoryPrinter.printStoryBlock("north.drawer.afterClue");
    }

    /**
     * Examines the drawer.
     */
    private void examineDrawer(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("north.table.dark");
            return;
        }

        if (!drawerUnlocked) {
            StoryPrinter.printStoryBlock("north.drawer.locked");
            return;
        }

        if (!drawerOpen) {
            StoryPrinter.printStoryBlock("north.drawer.open");
            drawerOpen = true;
            clueFound = true;
            return;
        }

        StoryPrinter.printStoryBlock("north.drawer.afterClue");
    }

    /**
     * Attempts to take the table.
     */
    private void takeTable() {
        System.out.println("The table is too heavy to move.");
    }

    /**
     * Attempts to take the drawer.
     */
    private void takeDrawer() {
        System.out.println("The drawer is built into the table.");
        System.out.println("You cannot remove it.");
    }

    /**
     * Uses the drawer.
     */
    private void useDrawer(boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("north.table.dark");
            return;
        }

        if (!drawerUnlocked) {
            StoryPrinter.printStoryBlock("north.drawer.locked");
            return;
        }

        if (!drawerOpen) {
            StoryPrinter.printStoryBlock("north.drawer.open");
            drawerOpen = true;
            clueFound = true;
            return;
        }

        StoryPrinter.printStoryBlock("north.drawer.afterClue");
    }

    /**
     * Uses the key on the drawer.
     */
    private void useKey(Player player, boolean flashlightOn) {

        if (!flashlightOn) {
            StoryPrinter.printStoryBlock("north.table.dark");
            return;
        }

        Key key = (Key) player.getInventory().getItem("brass key");

        if (key == null) {
            System.out.println("You don't have a key.");
            return;
        }

        if (!key.getUnlocks().equalsIgnoreCase("drawer")) {
            System.out.println("This key doesn't seem to fit anything here.");
            return;
        }

        if (drawerUnlocked) {
            System.out.println("The drawer is already unlocked.");
            return;
        }

        StoryPrinter.printStoryBlock("north.drawer.unlock");
        drawerUnlocked = true;
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
