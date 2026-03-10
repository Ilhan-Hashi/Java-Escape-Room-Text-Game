package EscapeRoom.game;
import EscapeRoom.database.DatabaseManager;
import EscapeRoom.database.PlayerDatabase;
import EscapeRoom.player.Player;
import EscapeRoom.world.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 The GameLauncher class starts the Escape Room game.
 * It initializes the database, loads the player,
 * and begins the story.
 *
 * @author Ilhan Hashi
 */
public class GameLauncher {
    // Logger for recording game events
    final static Logger log = LogManager.getLogger("GameLogger");

    public static void main(String[] args) {
        try {
            // Initialize database and player table
            initializeDatabase();

            Scanner scanner = new Scanner(System.in);

            // Print game banner
            //StoryPrinter.printGameBanner();

            // Ask player for username
            System.out.print("Enter your username: ");
            String username = scanner.nextLine().trim().toLowerCase();

            // Load or create player
            Player player = loadPlayer(username);

            // Print intro story
            StoryPrinter.printStoryBlock("mainRoom.examineRoom.start");

        } catch (Exception e) {

            System.out.println("An unexpected error occurred.");
            e.printStackTrace();

            log.error("Game crashed", e);
        }
    }

    /**
     * Initializes the database connection
     * and ensures the player table exists.
     */
    private static void initializeDatabase() {

        DatabaseManager.getInstance();
        PlayerDatabase.createPlayerTable();

        log.info("Database initialized.");
    }

    /**
     * Loads an existing player or creates a new one.
     *
     * @param username the username entered by the player
     * @return the Player object
     */
    private static Player loadPlayer(String username) {

        Player player;

        if (!PlayerDatabase.usernameExists(username)) {

            int id = PlayerDatabase.insertPlayer(username);
            player = new Player(id, username);

           // StoryPrinter.printNewPlayerWelcome();
            log.info("New player created: " + username);

        } else {

            player = PlayerDatabase.getPlayer(username);

           // StoryPrinter.printReturningPlayerWelcome(player.getUserName());
            log.info("Returning player logged in: " + username);
        }

        return player;
    }
}
