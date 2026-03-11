package EscapeRoom.game;

import EscapeRoom.enums.Direction;
import EscapeRoom.enums.GameState;
import EscapeRoom.enums.Location;
import EscapeRoom.items.Item;
import EscapeRoom.items.Tool;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.CodePuzzle;
import EscapeRoom.world.Room;
import EscapeRoom.world.RoomBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static EscapeRoom.game.GameLauncher.log;

/**
 * The GameManager class controls the overall game flow and player interactions.
 * Manages the player's location, handles item actions,
 * room transitions, puzzle solving, and game state.
 *
 * @author Ilhan Hashi
 */
public class GameManager {

    //region Fields

    private Player player;
    private GameState gameState;
    private Location location = Location.MAIN_CENTER;
    private final RoomBuilder roomBuilder = new RoomBuilder();
    private Location previousLocation = null;
    private final LocalDateTime startTime = LocalDateTime.now();

    //endregion

    //region Constructor

    /**
     * Creates the game manager and starts the game.
     * @param player the player playing the game.
     */
    public GameManager(Player player) {
        assert player != null: "player cannot be null";
        this.player = player;
        this.gameState = GameState.STARTED;
        setupRoomTransitions();
    }

    //endregion

    //region Room Setup

    /**
     * Sets up room transitions for all rooms.
     */
    private void setupRoomTransitions() {
        roomBuilder.getRooms().forEach(
                room -> room.setTransitionListener(
                        destination -> location = destination
                )
        );
    }

    //endregion

    //region Movement

    /**
     * Moves the player in a direction.
     * @param direction the direction the player want to go.
     */
    public void goDirection(Direction direction) {
        // Check if the player is already at that location.
        if (isAlreadyAtLocation(direction)) {
            System.out.println("You are already standing there.");
            return;
        }

        // Get the current room and the previous room.
        Room currentRoom = getCurrentRoom();
        Room previousRoom = previousLocation != null ? roomBuilder.getRoom(previousLocation) : null;

        // Prevent moving to the same room again.
        if (previousRoom != null && currentRoom.equals(previousRoom)) {
            System.out.println("You are already standing there.");
            return;
        }

        // Save the current location before moving.
        previousLocation = location;

        // Change location based on direction.
        switch (direction) {
            case NORTH:
                location = Location.MAIN_NORTH;
                StoryPrinter.printStoryBlock("mainRoom.exploreNorth.first");
                break;
            case SOUTH:
                location = Location.MAIN_SOUTH;
                if (allCluesFound()) {
                    StoryPrinter.printStoryBlock("mainRoom.exploreSouth.ready");
                } else {
                    StoryPrinter.printStoryBlock("mainRoom.exploreSouth");
                }
                break;
            case EAST:
                location = Location.MAIN_EAST;
                StoryPrinter.printStoryBlock("mainRoom.exploreEast.first");
                break;
            case WEST:
                location = Location.MAIN_WEST;
                StoryPrinter.printStoryBlock("mainRoom.exploreWest.first");
                break;
            case CENTER:
                returnToCenter();
                break;
        }
    }

    //endregion

    //region Actions

    /**
     * Handles taking an item.
     */
    public void takeItem(String itemName) {
        // Special handling for the flashlight.
        if (itemName.equalsIgnoreCase("flashlight")) {
            handleFlashlightTake();
            return;
        }

        // Let the current room handle the take action.
        getCurrentRoom().onTake(itemName, player, isFlashlightOn());
    }

    /**
     * Handles using an item.
     */
    public void useItem(String itemName) {
        // Special handling for the flashlight.
        if (itemName.equalsIgnoreCase("flashlight")) {
            handleFlashlightUse();
            return;
        }

        // Let the current room handle the use action.
        getCurrentRoom().onUse(itemName, player, isFlashlightOn());
    }

    /**
     * Handles examining an item.
     */
    public void examineItem(String itemName) {
        // Special handling for the flashlight.
        if (itemName.equalsIgnoreCase("flashlight")) {
            handleFlashlightExamine();
            return;
        }

        // Let the current room handle the examine action.
        getCurrentRoom().onExamine(itemName, player, isFlashlightOn());
    }

    //endregion

    //region Flashlight

    /**
     * Handles taking the flashlight.
     */
    private void handleFlashlightTake() {
        // Check if the player already has the flashlight.
        if (player.getInventory().hasItem("flashlight")) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.take.again");
            return;
        }

        // Flashlight can only be taken in the center room.
        if (location != Location.MAIN_CENTER) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.take.away");
            return;
        }

        // Create the flashlight item and add it to the player's inventory
        Item flashlight = new Tool("flashlight", "A small worn flashlight.");
        player.getInventory().addItem(flashlight);
        StoryPrinter.printStoryBlock("mainRoom.flashlight.take");
    }

    /**
     * Handles using the flashlight.
     */
    private void handleFlashlightUse() {
        // Get the flashlight from the player's inventory.
        Tool flashlight = (Tool) player.getInventory().getItem("flashlight");

        // If the player does not have the flashlight.
        if (flashlight == null) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.use.noItem");
            return;
        }

        // Toggle the flashlight on or off.
        flashlight.use(player);

        // If it was turned off.
        if (!flashlight.isActive()) return;

        // Show special messages depending on the room.
        if (location == Location.EAST_ROOM) {
            StoryPrinter.printStoryBlock("east.reveal.light");
        } else if (location == Location.NORTH_ROOM) {
            StoryPrinter.printStoryBlock("north.reveal.light");
        } else if (location == Location.WEST_ROOM) {
            StoryPrinter.printStoryBlock("west.reveal.light");
        } else {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.use");
        }
    }

    /**
     * Handles examining the flashlight.
     */
    private void handleFlashlightExamine() {
        // If the player already has the flashlight.
        if (player.getInventory().hasItem("flashlight")) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.examine.after");
            return;
        }

        if (location != Location.MAIN_CENTER) {
            StoryPrinter.printStoryBlock("mainRoom.flashlight.examine.away");
            return;
        }

        StoryPrinter.printStoryBlock("mainRoom.flashlight.examine.before");
    }

    //endregion

    //region Helpers

    /**
     * Gets the room the player is currently in.
     */
    private Room getCurrentRoom() {
        return roomBuilder.getRoom(location);
    }

    /**
     * Checks if the player's flashlight is on.
     */
    private boolean isFlashlightOn() {
        Tool flashlight = (Tool) player.getInventory().getItem("flashlight");
        return flashlight != null && flashlight.isActive();
    }

    /**
     * Cjecks if the player is already at the location.
     */
    private boolean isAlreadyAtLocation(Direction direction) {
        if (direction == Direction.NORTH)
            return location == Location.MAIN_NORTH || location == Location.NORTH_ROOM;

        if (direction == Direction.EAST)
            return location == Location.MAIN_EAST || location == Location.EAST_ROOM;

        if (direction == Direction.WEST)
            return location == Location.MAIN_WEST || location == Location.WEST_ROOM;

        if (direction == Direction.SOUTH)
            return location == Location.MAIN_SOUTH;

        if (direction == Direction.CENTER)
            return location == Location.MAIN_CENTER;

        return false;
    }

    /**
     * Handles returning the player to the center of the main room.
     */
    private void returnToCenter() {
        if (location == Location.EAST_ROOM ||
                location == Location.WEST_ROOM ||
                location == Location.NORTH_ROOM) {

            printReturnFromRoomMessage();
        } else {
            printReturnToCenterMessage();
        }

        location = Location.MAIN_CENTER;
    }

    /**
     * Prints the message when returning from another room.
     */
    private void printReturnFromRoomMessage() {
        boolean hasFlashlight = player.getInventory().hasItem("flashlight");
        boolean hasKey = player.getInventory().hasItem("brass key");

        String storyKey;

        if (!hasFlashlight && !hasKey) {
            storyKey = "mainRoom.return.fromRoom.items";
        } else if (!hasFlashlight) {
            storyKey = "mainRoom.return.fromRoom.flashlight";
        } else if (!hasKey) {
            storyKey = "mainRoom.return.fromRoom.key";
        } else {
            storyKey = "mainRoom.return.fromRoom";
        }

        StoryPrinter.printStoryBlock(storyKey);
    }

    /**
     * Prints the message when returning to the center of the main room.
     */
    private void printReturnToCenterMessage() {
        boolean hasFlashlight = player.getInventory().hasItem("flashlight");
        boolean hasKey = player.getInventory().hasItem("brass key");

        String storyKey;

        if (!hasFlashlight && !hasKey) {
            storyKey = "mainRoom.return.items";
        } else if (!hasFlashlight) {
            storyKey = "mainRoom.return.flashlight";
        } else if (!hasKey) {
            storyKey = "mainRoom.return.key";
        } else {
            storyKey = "mainRoom.examineRoom.later";
        }

        StoryPrinter.printStoryBlock(storyKey);
    }

    //endregion

    //region Puzzle

    /**
     * Handles entering a code into the keypad code puzzle.
     * @param code the code entered by the player.
     */
    public void enterCode(String code) {

        if (location != Location.MAIN_SOUTH) {
            StoryPrinter.printStoryBlock("mainRoom.key.noKeypad");
            return;
        }

        if (!allCluesFound()) {
            StoryPrinter.printStoryBlock("mainRoom.key.notReady");
            return;
        }

        CodePuzzle puzzle = (CodePuzzle) getCurrentRoom().getPuzzle();
        puzzle.attempt(code);

        if (puzzle.isSolved()) {
            gameState = GameState.WON;
            Logging.writeLog("Puzzle solved by: " + player);
            log.info("Puzzle solved by: " + player);
            endGame();
        }
    }

    //endregion

    //region Clue Checking

    /**
     * Checks if all rooms clues have been discovered.
     */
    private boolean allCluesFound() {
        Location[] clueRooms = {
                Location.EAST_ROOM,
                Location.WEST_ROOM,
                Location.NORTH_ROOM
        };

        boolean allFound = Arrays.stream(clueRooms)
                .allMatch(loc -> roomBuilder.getRoom(loc).isClueFound());

        return allFound;
    }

    //endregion

    //region Player Info

    /**
     * Displays the player's inventory.
     */
    public void showInventory() {
        player.getInventory().showInventory();
    }

    //endregion

    //region Time

    /**
     * Determines the current season based on the month.
     */
    private String getSeason() {
        int month = LocalDate.now().getMonthValue();
        switch (month) {
            case 3, 4, 5:
                return "spring";
            case 6, 7, 8:
                return "summer";
            case 9, 10, 11:
                return "fall";
            default:
                return "winter";
        }
    }

    /**
     * Displays the player current status.
     */
    public void showStatus() {
        long minutes = getElapsedMinutes();
        String season = getSeason();

        System.out.println();
        System.out.println("[ Status ]");
        System.out.println("You have been trapped for " + minutes + " minutes.");

        switch (season) {
            case "spring":
                System.out.println("The smell of rain lingers in the air...");
                break;
            case "summer":
                System.out.println("The room grows uncomfortably warm...");
                break;
            case "fall":
                System.out.println("A chill creeps in as the seasons turn...");
                break;
            case "winter":
                System.out.println("A cold draft seeps through the walls...");
                break;
        }
        System.out.println();
    }

    /**
     * Calculates how many mins have passes sinse the game started.
     */
    private long getElapsedMinutes() {
        long mins = ChronoUnit.MINUTES.between(startTime, LocalDateTime.now());

        return mins;
    }

    //endregion

    //region Game Control

    /**
     * Displays the list of available commands.
     */
    public void showHelp() {
        System.out.println();
        System.out.println("Movement:");
        System.out.println("  north / n");
        System.out.println("  south / s");
        System.out.println("  east  / e");
        System.out.println("  west  / w");
        System.out.println("  center / c");
        System.out.println();
        System.out.println("Actions:");
        System.out.println("  take <item>");
        System.out.println("  use <item>");
        System.out.println("  examine <item>");
        System.out.println();
        System.out.println("Other:");
        System.out.println("  inventory / i");
        System.out.println("  enter <code>");
        System.out.println("  status");
        System.out.println("  help / ?");
        System.out.println("  quit / exit");
        System.out.println();
    }

    /**
     * Ends the game.
     */
    public void endGame() {
        if (gameState == GameState.WON) {
            System.out.println("Thanks for playing. You escaped!");
            Logging.writeLog("Player won: " + player);
            log.info("Player won: " + player);
        } else {
            gameState = GameState.LOST;
            System.out.println("Thanks for playing.");
            Logging.writeLog("Player quit: " + player);
            log.info("Player quit: " + player);
        }
        System.exit(0);
    }

    //endregion
}