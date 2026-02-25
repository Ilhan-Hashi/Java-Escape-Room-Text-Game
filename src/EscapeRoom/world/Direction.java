package EscapeRoom.world;

/**
 * The Direction enum represents the four directions
 * a player can move in the game.
 *
 * @author Ilhan Hashi
 */
public enum Direction {
    /**
     * Possible directions the player can move.
     */
    NORTH, EAST, SOUTH, WEST;

    /**
     * Converts a user input string into a Direction value.
     *
     * @param input The direction entered by the player.
     * @return The matching Direction enum value.
     * @throws IllegalArgumentException if the input is invalid.
     */
    public static Direction formatString(String input) {
        //
        input = input.toUpperCase();
        if (input.equals("north")) {
            return NORTH;
        } else if (input.equals("east")) {
            return EAST;
        } else if (input.equals("south")) {
            return SOUTH;
        } else if (input.equals("west")) {
            return WEST;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + input);
        }
    }
}
