package EscapeRoom.game;
import EscapeRoom.database.DatabaseManager;
import EscapeRoom.database.PlayerDatabase;
import EscapeRoom.player.Player;
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

    //region Fields

    // Logger for recording game events
    final static Logger log = LogManager.getLogger("GameLogger");

    //endregion

    //region Main

    public static void main(String[] args) {
        try {
            // Initialize database and player table.
            initializeDatabase();

            Scanner scanner = new Scanner(System.in);

            // Print game banner.
            StoryPrinter.printBanner();

            // Ask player for username.
            System.out.print("Enter your username: ");
            String username = scanner.nextLine().trim().toLowerCase();

            while (username.isEmpty()) {
                System.out.println();
                System.out.print("Username cannot be blank.");
                System.out.println();
                System.out.print("Please enter your username: ");
                username = scanner.nextLine().trim().toLowerCase();
            }

            // Load or create player.
            Player player = loadPlayer(username);

            // Create game manager.
            GameManager gameManager = new GameManager(player);
            log.info("Game started: " + player);
            Logging.writeLog("Game started: " + player);

            // Create command handler.
            CommandHandler commandHandler = new CommandHandler(gameManager);
            System.out.println();

            // Game intro.
            StoryPrinter.printStoryBlock("mainRoom.intro");
            System.out.println();
            System.out.println("Type 'help' to see available commands.");

            // Main game loop
            while (true) {

                System.out.print("> ");

                String input = scanner.nextLine();

                commandHandler.handleCommand(input);
            }

        } catch (Exception e) {

            System.out.println("An unexpected error occurred.");
            e.printStackTrace();

            log.error("Game crashed", e);
            Logging.writeLog("Game crashed " + e);
        } finally {
            System.out.println("Thanks for playing. Goodbye!");
        }
    }

    //endregion

    //region Helper Methods

    /**
     * Initializes the database connection
     * and ensures the player table exists.
     */
    private static void initializeDatabase() {
        DatabaseManager.getInstance();
        PlayerDatabase.createPlayerTable();

        log.info("Database initialized.");
        Logging.writeLog("Database initialized.");
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

             StoryPrinter.printNewPlayerWelcome();
             log.info("New player created:  " + player);
            Logging.writeLog("New player created: " + player);

        } else {
            player = PlayerDatabase.getPlayer(username);

             StoryPrinter.printReturningPlayerWelcome(player.getUserName());
             log.info("Returning player " + player);
            Logging.writeLog("Returning player logged in: " + player);
        }

        return player;
    }

    //endregion

}
