package EscapeRoom.game;

import EscapeRoom.enums.Direction;

/**
 * Handles player input and sends commands to the GameManager.
 *
 * @author Ilhan Hashi
 */
public class CommandHandler {
    //region Fields

    private GameManager gameManager;

    //endregion

    //region Constructor

    /**
     * Creates a command handler for the game.
     * @param gameManager the game manager used to process commands.
     */
    public CommandHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    //endregion

    //region Command Handling

    /**
     * Handles the command entered by the player.
     * @param input the command entered by the player.
     */
    public void handleCommand(String input) {
        // Ignore empty or null input.
        if (input == null || input.isBlank()) {
            return;
        }

        // Split input into command and argument.
        try {
            String[] parts = input.trim().split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            // Check if the command is a direction.
            Direction direction = parseDirection(command);

            // If it is a direction, move the player.
            if (direction != null) {
                gameManager.goDirection(direction);
                return;
            }

            // Otherwise process other commands.
            processCommand(command, argument);

        } catch (InvalidCommandException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //endregion

    //region Helper Methods

    /**
     * Converts text input into a Direction
     * @param text the direction entered by the player.
     * @return the matching Direction or null if invalid.
     */
    private Direction parseDirection(String text) {

        switch (text.toLowerCase()) {
            // Match the player input to a direction.
            case "north": case "n":
                return Direction.NORTH;
            case "south": case "s":
                return Direction.SOUTH;
            case "east":  case "e":
                return Direction.EAST;
            case "west":  case "w":
                return Direction.WEST;
            case "center": case "c":
                return Direction.CENTER;
            default: return null;
        }
    }

    /**
     * Processes the player's command.
     * @param command the command entered by the player.
     * @param argument the argument associated with the command.
     */
    private void processCommand(String command, String argument) {
        // Process player commands and call the correct game action.
        switch (command) {
            case "take":
                if (!requiresArgument(argument, "Take what?")) return;
                gameManager.takeItem(argument);
                break;
            case "use":
                if (!requiresArgument(argument, "Use what?")) return;
                gameManager.useItem(argument);
                break;
            case "examine":
                if (!requiresArgument(argument, "Examine what?")) return;
                gameManager.examineItem(argument);
                break;
            case "inventory":
            case "i":
                gameManager.showInventory();
                break;
            case "enter":
                if (!requiresArgument(argument, "Enter what?")) return;
                gameManager.enterCode(argument);
                break;
            case "help":
            case "?":
                gameManager.showHelp();
                break;
            case "status":
                gameManager.showStatus();
                break;
            case "quit":
            case "exit":
                gameManager.endGame();
                break;
            default:
                throw new InvalidCommandException(command);
        }
    }

    /**
     * Checks if a command requires an argument.
     * @param argument the argument entered by the player.
     * @param prompt the message to display if missing.
     * @return true if the argument is present.
     */
    private boolean requiresArgument(String argument, String prompt) {
        // Checks if a command argument is provided.
        if (argument.isEmpty()) {
            System.out.println(prompt);
            return false;
        }
        return true;
    }

    //endregion
}
