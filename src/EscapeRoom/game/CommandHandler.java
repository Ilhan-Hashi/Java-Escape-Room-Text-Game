package EscapeRoom.game;

import EscapeRoom.world.Direction;

/**
 * The CommandHandler class is responsible
 * for parsing user input and calling the
 * appropriate GameManager methods.
 *
 * @author Ilhan Hashi
 */
public class CommandHandler {
    private GameManager gameManager;

    /**
     * Constructor to create a CommandHandler with a GameManager.
     * @param gameManager the game manager instance.
     */
    public CommandHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Parses and handles a command entered by the user.
     *
     * @param input the full command typed by the user.
     */
    public void handleCommand(String input) {
        // Check if null/empty input.
        if (input == null || input.isBlank()) {
            return;
        }
        // Split input into words.
        String[] parts = input.trim().split(" ");

        // First phrase is the main command.
        String command = parts[0].toLowerCase();

        switch (command) {
            case "look":

                // If direction is provided.
                if (parts.length == 1) {
                    gameManager.describeCurrentRoom();
                    return;
                }

                // If player typed "look north", allow the player to explore a specific
                // direction.
                if (parts.length >= 2) {
                    try {
                        // Convert input to Direction enum.
                        Direction direction = Direction.valueOf(parts[1].toUpperCase());
                        gameManager.exploreDirection(direction);
                    } catch (IllegalArgumentException e) {
                        // Invalid direction entered.
                        System.out.println("Invalid direction.");
                    }
                }
                break;

            case "explore":
                // Ensures a direction was provided.
                if (parts.length < 2) {
                    System.out.println("Explore which direction?");
                    return;
                }

                try {
                    // Convert input to Direction enum.
                    Direction direction = Direction.valueOf(parts[1].toUpperCase());
                    gameManager.exploreDirection(direction);
                } catch (IllegalArgumentException e) {
                    // Invalid direction entered.
                    System.out.println("Invalid direction.");
                }
                break;

            case "go":
                // Ensure a direction was provided.
                if (parts.length < 2) {
                    System.out.println("Go where?");
                    return;
                }

                try {
                    // Convert input to Direction enum.
                    Direction direction = Direction.valueOf(parts[1].toUpperCase());
                    gameManager.goDirection(direction);

                } catch (IllegalArgumentException e) {
                    // Invalid direction entered,
                    System.out.println("Invalid direction.");
                }
                break;

            case "inventory":
                // Show player's inventory.
                gameManager.showInventory();
                break;

            case "take":
                // Ensure an item name was provided.
                if (parts.length < 2) {
                    System.out.println("Take what?");
                    return;
                }

                // Attempt to take the item.
                gameManager.takeItem(parts[1]);
                break;

            case "drop":
                // Ensure an item name was provided.
                if (parts.length < 2) {
                    System.out.println("Drop what?");
                    return;
                }

                // Attempt to drop the item.
                gameManager.dropItem(parts[1]);
                break;

            case "use":
                // Ensure an item name was provided.
                if (parts.length < 2) {
                    System.out.println("Use what?");
                    return;
                }

                // Attempt to use the item.
                gameManager.useItem(parts[1]);
                break;

            case "examine":
                // Ensure an item name was provided.
                if (parts.length < 2) {
                    System.out.println("Examine what?");
                    return;
                }

                // Attempt to examine the item.
                gameManager.examineItem(parts[1]);
                break;

            case "enter":
                // Ensure a code was provided.
                if (parts.length < 2) {
                    System.out.println("Enter what?");
                    return;
                }

                // Attempt to enter a code.
                gameManager.enterCode(parts[1]);
                break;

            case "help":
                // Display help menu.
                gameManager.showHelp();
                break;

            case "quit":
                // End the game.
                gameManager.endGame();
                break;

            default:
                // Command not recognized.
                System.out.println("Unknown command.");
        }
    }
}
