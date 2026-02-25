package EscapeRoom.game;

import EscapeRoom.database.DatabaseManager;
import EscapeRoom.database.PlayerDatabase;
import EscapeRoom.player.Player;
import EscapeRoom.puzzles.CodePuzzle;
import EscapeRoom.world.Direction;
import EscapeRoom.world.Exit;
import EscapeRoom.world.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class GameLauncher {
    // Insantiate logging object.
    final static Logger log = LogManager.getLogger("GameLogger");

    public static void main(String[] args) {
//        //System.out.println("Starting Game...");
//
//        // Print a message.
//        String message = "Starting Game...";
//        System.out.println(message);
//
//        // Records when the game starts.
//        log.info("Game started");
//
//        // For debugging to confirm main() is running.
//        log.debug("Main method entered");
        try {
            // DATABASE SETUP
            DatabaseManager.getInstance();
            PlayerDatabase.createPlayerTable();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Escape Room!");
            System.out.print("Enter your username: ");

            String username = scanner.nextLine().trim().toLowerCase();

            Player player;

            if (!PlayerDatabase.usernameExists(username)) {

                int id = PlayerDatabase.insertPlayer(username);
                player = new Player(id, username);

                System.out.println("Welcome, " + player.getUserName().toUpperCase() + "!");

            } else {

                player = PlayerDatabase.getPlayer(username);

                System.out.println("Welcome back, " + player.getUserName().toUpperCase() + "!");
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
