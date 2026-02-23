package EscapeRoom.game;

/**
 * GameManager uses the Singleton pattern.
 * Only one instance of this class exists.
 *
 * Example: A class that uses the Singleton Pattern.
 *
 * @author Ilhan Hashi
 * @course Java Part 2
 */
public class GameManager {
    // Tracks current state of the game.
    private GameState currentState;

    // Singleton instance.
    private static final GameManager instance = new GameManager();

    /**
     * Private constructor.
     */
    private GameManager() {
        currentState = GameState.NOT_STARTED;
    }

    /**
     * Global access to the single GamaManager instance.
     * @return the single GameManager object.
     */
    public static GameManager getInstance() {
        return instance;
    }

    /**
     * Changes the game state to Started.
     */
    public void start() {
        currentState = GameState.STARTED;
    }

    /**
     * Return the current game state.
     */
    public GameState getGameState() {
        return currentState;
    }
}