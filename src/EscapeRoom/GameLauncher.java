package EscapeRoom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameLauncher {
    // Insantiate logging object.
    final static Logger log = LogManager.getLogger("GameLogger");

    public static void main(String[] args) {
        //System.out.println("Starting Game...");

        // Print a message.
        String message = "Starting Game...";
        System.out.println(message);

        // Records when the game starts.
        log.info("Game started");

        // For debugging to confirm main() is running.
        log.debug("Main method entered");

    }
}
