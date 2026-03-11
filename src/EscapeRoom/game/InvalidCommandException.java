package EscapeRoom.game;

/**
 * Exception thrown when the player enters a command that the game does not recognize.
 */
public class InvalidCommandException extends RuntimeException {
    //region Fields

    private final String command;

    //endregion

    //region Constructor

    /**
     * Creates an exception for an invalid command.
     */
    public InvalidCommandException(String command) {
        super("Unknown command: '" + command + "'. Type 'help' to see available commands.");
        this.command = command;
    }

    //endregion

    //region Getters

    /**
     * Returns the invalid command entered by the player.
     */
    public String getCommand() {
        return command;
    }

    //endregion
}
