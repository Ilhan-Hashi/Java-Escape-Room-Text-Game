package EscapeRoom.game;

import EscapeRoom.items.Item;
import EscapeRoom.items.Usable;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.Puzzle;
import EscapeRoom.world.Direction;
import EscapeRoom.world.Exit;
import EscapeRoom.world.Room;

import java.util.List;

/**
 * The GameManager class controls the overall
 * game flow and player interactions.
 *
 * @author Ilhan Hashi
 */
public class GameManager {
    private Player player;
    private GameState gameState;

    /**
     * Creates a GameManager with a player.
     * @param player the player of the game.
     */
    public GameManager(Player player) {
        this.player = player;
        this.gameState = GameState.NOT_STARTED;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        gameState = GameState.STARTED;
        System.out.println("Game started.");
        describeCurrentRoom();
    }

    /**
     * Returns the current game state.
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * Displays the current room description.
     */
    public void describeCurrentRoom() {
        Room room = player.getCurrentRoom();
        System.out.println(room.getDescription());
    }

    /**
     * Investigates a specific direction without moving.
     */
    public void exploreDirection(Direction direction) {

        Room currentRoom = player.getCurrentRoom();
        String wallDescription = currentRoom.getWallDescription(direction);

        if (wallDescription != null) {
            System.out.println(wallDescription);
        } else {
            System.out.println("There is nothing unusual here.");
        }
    }

    /**
     * Attempts to move through an exit in a direction.
     */
    public void goDirection(Direction direction) {

        Room currentRoom = player.getCurrentRoom();
        Exit exit = currentRoom.getExit(direction);

        if (exit == null) {
            System.out.println("There is no door in that direction.");
            return;
        }

        if (!exit.isAccessible(player)) {
            System.out.println("The door is locked.");
            return;
        }

        player.setCurrentRoom(exit.getDestination());
        describeCurrentRoom();
        checkWin(exit);
    }

    /**
     * Checks if the player has reached the final exit.
     */
    private void checkWin(Exit exit) {

        if (exit.isFinalExit()) {
            gameState = GameState.WON;
            System.out.println("Congrats " + player.getName() + "! You have escaped! You win!");
        }
    }

    /**
     * Displays the player's inventory.
     */
    public void showInventory() {

        List<Item> items = player.getInventory().getItems();

        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("You are carrying:");
        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }

    /**
     * Takes an item from the room.
     */
    public void takeItem(String itemName) {

        Room room = player.getCurrentRoom();

        for (Item item : room.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {

                player.getInventory().addItem(item);
                room.removeItem(item);

                System.out.println("You picked up: " + item.getName());
                return;
            }
        }

        System.out.println("That item is not here.");
    }

    /**
     * Drops an item into the current room.
     */
    public void dropItem(String itemName) {

        Item item = player.getInventory().getItemByName(itemName);

        if (item == null) {
            System.out.println("You do not have that item.");
            return;
        }

        player.getInventory().removeItem(item);
        player.getCurrentRoom().addItem(item);

        System.out.println("You dropped: " + item.getName());
    }

    /**
     * Uses an item from inventory.
     */
    public void useItem(String itemName) {

        Item item = player.getInventory().getItemByName(itemName);

        if (item == null) {
            System.out.println("You do not have that item.");
            return;
        }

        if (item instanceof Usable usable) {
            usable.use(player);
        } else {
            System.out.println("That item cannot be used.");
        }
    }

    /**
     * Examines an item in inventory.
     */
    public void examineItem(String itemName) {

        Item item = player.getInventory().getItemByName(itemName);

        if (item == null) {
            System.out.println("You do not have that item.");
            return;
        }

        System.out.println(item.getDescription());
    }

    /**
     * Attempts to enter a code for puzzles in the room.
     */
    public void enterCode(String code) {

        Room room = player.getCurrentRoom();
        List<Puzzle> puzzles = room.getPuzzles();

        for (Puzzle puzzle : puzzles) {

            if (!puzzle.isSolved()) {

                boolean success = puzzle.attempt(code);

                if (success) {
                    System.out.println("The code worked!");
                } else {
                    System.out.println("Incorrect code.");
                }

                return;
            }
        }

        System.out.println("There is nothing here to enter a code into.");
    }

    /**
     * Displays available commands.
     */
    public void showHelp() {

        System.out.println("Available commands:");
        System.out.println("look");
        System.out.println("look <direction>");
        System.out.println("explore <direction>");
        System.out.println("go <direction>");
        System.out.println("inventory");
        System.out.println("take <item>");
        System.out.println("drop <item>");
        System.out.println("use <item>");
        System.out.println("examine <item>");
        System.out.println("enter <code>");
        System.out.println("help");
        System.out.println("quit");
    }

    /**
     * Ends the game.
     */
    public void endGame() {
        gameState = GameState.LOST;
        System.out.println("Game ended.");
    }
}