package EscapeRoom.game;

import EscapeRoom.enums.Direction;

/**
 * The CommandHandler class is responsible
 * for parsing user input and calling the
 * appropriate GameManager methods.
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

    //region Direction Parser

    /**
     * Converts text input into a Direction
     * @param text the direction entered by the player.
     * @return the matching Direction or null if invalid.
     */
    private Direction parseDirection(String text) {

        switch (text.toLowerCase()) {

            case "north": case "n": return Direction.NORTH;
            case "south": case "s": return Direction.SOUTH;
            case "east":  case "e": return Direction.EAST;
            case "west":  case "w": return Direction.WEST;
            case "center": case "c": return Direction.CENTER;

            default: return null;
        }
    }

    //endregion
}
