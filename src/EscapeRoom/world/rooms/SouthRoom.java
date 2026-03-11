package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.CodePuzzle;
import EscapeRoom.world.Room;

/**
 * Represents the south room where the player can escape the game.
 *
 * @author Ilhan Hashi
 */
public class SouthRoom extends Room {
    //region Constructor

    /**
     * Represents the south room containing the exit door and keypad puzzle.
     * The player must enter the correct code to escape.
     *
     * @param code the code used to solve the puzzle.
     */
    public SouthRoom(String code) {
        super("South Wall", Location.MAIN_SOUTH, false);
        setPuzzle(new CodePuzzle(code));
    }

    //endregion

    //region Actions

    /**
     * Handles examining items in the south room.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("keypad")) {
            examineKeypad();
            return;
        }

        if (itemName.equalsIgnoreCase("door")) {
            examineDoor();
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items in the south room.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("keypad")) {
            takeKeypad();
            return;
        }

        if (itemName.equalsIgnoreCase("door")) {
            takeDoor();
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items in the south room.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("keypad")) {
            useKeypad();
            return;
        }

        if (itemName.equalsIgnoreCase("door")) {
            useDoor();
            return;
        }

        System.out.println("You can't use that.");
    }

    //endregion

    //region Helpers Methods

    /**
     * Examines the keypad.
     */
    private void examineKeypad() {
        StoryPrinter.printStoryBlock("mainRoom.keypad.examine");
    }

    /**
     * Examines the south door.
     */
    private void examineDoor() {
        StoryPrinter.printStoryBlock("mainRoom.doorSouth.examine");
    }

    /**
     * Attempts to take the keypad.
     */
    private void takeKeypad() {
        StoryPrinter.printStoryBlock("mainRoom.keypad.take");
    }

    /**
     * Attempts to take the door.
     */
    private void takeDoor() {
        System.out.println("The door is far too heavy to move.");
    }

    /**
     * Uses the keypad.
     */
    private void useKeypad() {
        System.out.println(getPuzzle().getHint());
    }

    /**
     * Uses the door.
     */
    private void useDoor() {
        System.out.println("The door has no handle. The keypad must control it.");
    }

    //endregion
}
