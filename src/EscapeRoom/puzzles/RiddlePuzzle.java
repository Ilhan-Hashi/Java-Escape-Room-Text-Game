package EscapeRoom.puzzles;

public class RiddlePuzzle  extends Puzzle {
    // Private properties.
    private String correctAnswer;

    /**
     * Creates a new RiddlePuzzle with a name, description, and correct answer.
     * @param name name The name of the puzzle.
     * @param description The riddle text shown to the player.
     * @param correctAnswer The correct answer to the riddle.
     */
    public RiddlePuzzle(String name, String description, String correctAnswer  ) {
        super(name, description);
        this.correctAnswer = correctAnswer;
    }

    /**
     * Attempts to solve the riddle by comparing
     * the player's answer to the correct answer.
     * @param answer The player's input.
     * @return true if the answer is correct, false otherwise.
     */
    @Override
    public boolean attempt(String answer) {
        // Flag to track if the answer is correct.
        boolean correct = false;

        // Check to see if the puzzle is already solved.
        if (isSolved()) {
            correct = true;
        }
        else {
            // Compare the player's answer to the correct answer.
            if (correctAnswer.equalsIgnoreCase(answer)) {
                // mark puzzle as solved.
                setSolved(true);
                correct = true;
            }
        }

        // Return the result.
        return correct;
    }
}
