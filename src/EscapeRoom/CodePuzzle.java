package EscapeRoom;

/**
 * A puzzle that is solved by entering the correct code.
 * Extends the Puzzle class.
 *
 * @author Ilhan Hashi
 * @course Java Part 2
 */
public class CodePuzzle extends Puzzle {
    // Private field that stores the correct code needed to solve the puzzle.
    private String validCode;

    /**
     * Constructs a CodePuzzle with a description and a valid code.
     * @param description the puzzle description.
     * @param validCode the correct code needed to solve the puzzle.
     */
    public CodePuzzle(String description, String validCode) {
        this.description = description;
        this.validCode = validCode;
        this.solved = false;
    }

    /**
     * Checks whether the provided input matches the valid code.
     * If the code is correct, the puzzle is marked as solved.
     * @param input the code entered by the player.
     * @return true if the input matches the valid code, false otherwise.
     */
    public boolean checkCode(String input) {
        // Flag to track correctness.
        boolean isValid = false;

        // Check if the input matches the valid code.
        if(input.equals(validCode)) {
            // Mark puzzle as solved.
            solved = true;

            // Update the flag.
            isValid = true;
        }
        // Returns whether the code was valid or not.
        return isValid;
    }
}
