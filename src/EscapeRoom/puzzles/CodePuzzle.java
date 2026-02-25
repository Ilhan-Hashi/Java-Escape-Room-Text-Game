package EscapeRoom.puzzles;

/**
 * CodePuzzle represents a puzzle that requires
 * the player to enter a correct code.
 *
 * @author Ilhan Hashi
 */
public class CodePuzzle extends Puzzle {
    // Private property.
    private String solutionCode;

    /**
     * Creates a new CodePuzzle with a name, description, and a
     * solution code.
     *
     * @param name The name of the puzzle.
     * @param description The description shown to the player.
     * @param solutionCode The correct code required to solve the puzzle.
     */
    public CodePuzzle(String name, String description, String solutionCode) {
        super(name, description);
        this.solutionCode = solutionCode;
    }

    /**
     * Attempts to solve the puzzle by comparing the player's answer
     * to the correct solution code.
     *
     * @param answer The player's input.
     * @return true if the answer is correct, false otherwise.
     */
    @Override
    public boolean attempt(String answer) {
        // Flag to track if the code is correct.
        boolean correct = false;

        // Check if the puzzle is already solved.
        if (isSolved()) {
            correct = true;
        }
        else {
            // Compare the player's input to the solution code.
            if (solutionCode.equals(answer)) {
                setSolved(true);
                correct = true;
            }
        }

        // Return the result.
        return correct;
    }
}
