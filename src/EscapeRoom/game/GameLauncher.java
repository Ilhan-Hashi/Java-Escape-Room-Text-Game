package EscapeRoom.game;

import EscapeRoom.player.Player;
import EscapeRoom.puzzles.CodePuzzle;
import EscapeRoom.world.Direction;
import EscapeRoom.world.Exit;
import EscapeRoom.world.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        // Create a room.
        Room roomA = new Room("Room A",
                "You are a dimly liy escape room. the air feels heavy.");

        // Create Room B (final room)
        Room roomB = new Room("Room B",
                "You step into a bright hallway. Freedom is near.");

        // Create a puzzle required to unlock the nor exit.
        CodePuzzle doorPuzzle = new CodePuzzle("Door Code" ,
                "A keypad besides the reads: Enter 4-Digit code",
                "1234"
        );

        // Add puzzle to Room A
        roomA.addPuzzle(doorPuzzle);

        // Set wall descriptions for Room A
        roomA.setWallDescription(Direction.NORTH,
                "A large metal door stands here with a keypad.");

        roomA.setWallDescription(Direction.SOUTH,
                "A wooden chest sits against the wall.");

        roomA.setWallDescription(Direction.EAST,
                "A cracked mirror hangs loosely.");

        roomA.setWallDescription(Direction.WEST,
                "An old bookshelf with dusty books.");

        // Create a locked exit requiring the puzzle
        Exit northExit = new Exit(roomB, doorPuzzle);

        // Mark this exit as the final exit
        northExit.setFinalExit(true);

        // Attach exit to Room A
        roomA.setExit(Direction.NORTH, northExit);

        // Create player starting in Room A
        Player player = new Player("Ilhan", roomA);

        // Create GameManager
        GameManager gameManager = new GameManager(player);

        // Start game
        gameManager.startGame();

        // Test exploration
        gameManager.exploreDirection(Direction.SOUTH);
        gameManager.exploreDirection(Direction.NORTH);

        // Solve puzzle manually for testing
        doorPuzzle.attempt("1234");

        // Try again
        gameManager.exploreDirection(Direction.NORTH);

        // Check state
        if (gameManager.getGameState() == GameState.WON) {
            System.out.println("Game state is WON.");
        }
    }
}
