package EscapeRoom.game;
/**
 * The GameState enum represents the current state of the game.
 *
 * @author Ilhan Hashi
 */
public enum GameState {
    /**
     * The game has not started yet.
     */
    NOT_STARTED,

    /**
     * The game is currently running.
     */
    STARTED,

    /**
     * The player has successfully escaped.
     */
    WON,

    /**
     * The player has quit or lost the game.
     */
    LOST
}