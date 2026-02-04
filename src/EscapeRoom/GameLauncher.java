package EscapeRoom;

import java.util.Scanner;

public class GameLauncher {

    public static void main(String[] args) {
        //System.out.println("Starting Game...");

        // Print a message.
        String message = "Starting Game...";
        System.out.println(message);

        // Set up Scanner for user input.
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt for user to enter their name.
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();

            // Initialize Player object.
            Player player = new Player("Ilhan");

            // Display a welcome message.
            System.out.println("Welcome " + player.getName());
        } catch (Exception ex) {
            // Handle unexpected error.
            System.err.println(ex.toString());
        }




    }
}
