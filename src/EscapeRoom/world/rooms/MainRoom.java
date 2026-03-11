package EscapeRoom.world.rooms;

import EscapeRoom.enums.Location;
import EscapeRoom.game.StoryPrinter;
import EscapeRoom.items.Item;
import EscapeRoom.items.Key;
import EscapeRoom.items.Tool;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;

/**
 * The MainRoom class represents the center room where the player starts.
 *
 * @author Ilhan Hashi
 */
public class MainRoom extends Room {

    //region Constructor

    /**
     * Creates the main room and adds the starting items.
     */
    public MainRoom() {
        super("Main Room", Location.MAIN_CENTER, false);

        // add items.
        addItem(new Tool("flashlight", "A small worn flashlight."));
        addItem(new Key("brass key", "A small brass key.", "drawer"));
    }

    //endregion

    //region Action

    /**
     * Handles examining items in the main room.
     * @param itemName the name of the item.
     * @param player the player doing the action.
     * @param flashlightOn whether the flashlight is on.
     */
    @Override
    public void onExamine(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("door")) {
            examineDoor();
            return;
        }

        if (itemName.equalsIgnoreCase("flashlight")) {
            examineFlashlight(player);
            return;
        }

        if (itemName.equalsIgnoreCase("key") || itemName.equalsIgnoreCase("brass key")) {
            examineKey();
            return;
        }

        System.out.println("You don't see anything like that here.");
    }

    /**
     * Handles taking items in the main room.
     * @param itemName the name of the item.
     * @param player the player doing the action.
     * @param flashlightOn whether the flashlight is on.
     */
    @Override
    public void onTake(String itemName, Player player, boolean flashlightOn) {

        if (itemName.equalsIgnoreCase("flashlight")) {
            takeFlashlight(player);
            return;
        }

        if (itemName.equalsIgnoreCase("key") || itemName.equalsIgnoreCase("brass key")) {
            takeKey(player);
            return;
        }

        System.out.println("You don't see that here.");
    }

    /**
     * Handles using items in the main room.
     * @param itemName the name of the item.
     * @param player the player doing the action.
     * @param flashlightOn whether the flashlight is on.
     */
    @Override
    public void onUse(String itemName, Player player, boolean flashlightOn) {
        System.out.println("You can't use that here.");
    }

    //endregion

    //region Helpers

    /**
     * Examines the south door which is the main exit.
     */
    private void examineDoor() {
        StoryPrinter.printStoryBlock("mainRoom.center.door");
    }

    /**
     * examines the flashlihgt.
     */
    private void examineFlashlight(Player player) {
        StoryPrinter.printStoryBlock("mainRoom.flashlight.examine");
    }

    /**
     * Examines the key.
     */
    private void examineKey() {
        StoryPrinter.printStoryBlock("mainRoom.key.examine");
    }

    /**
     * Handles taking the flashlight.
     */
    private void takeFlashlight(Player player) {

        if (player.getInventory().hasItem("flashlight")) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.take.again");
            return;
        }

        Item flashlight = new Tool("flashlight", "A small worn flashlight.");
        player.getInventory().addItem(flashlight);
        StoryPrinter.printStoryBlock("mainRoom.flashlight.take");
    }

    /**
     * Hansles taking the key.
     */
    private void takeKey(Player player) {

        if (player.getInventory().hasItem("brass key")) {
            System.out.println("You already picked up the brass key.");
            return;
        }

        Item key = new Key("brass key", "A small brass key.", "drawer");
        player.getInventory().addItem(key);
    }

    //endregion
}
