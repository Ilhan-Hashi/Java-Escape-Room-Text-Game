package EscapeRoom.puzzles;

/**
 * The Puzzle class represents a challenge
 * that the player must solve.
 *
 * @author
 */
public abstract class Puzzle {
    // Private properties.
    private String name;
    private String description;
    private boolean solved;

    /**
     * Creates a puzzle with a name and description.
     *
     * @param name The name of the puzzle.
     * @param description A description of the puzzle.
     */
    public Puzzle(String name, String description) {
        this.name = name;
        this.description = description;
        this.solved = false;
    }

    /**
     * Attempts to solve the puzzle using the given answer.
     * @param answer the player's answer to the puzzle
     * @return true if the answer is correct, false otherwise.
     */
    public abstract boolean attempt (String answer);

    /**
     * Returns whether the puzzle has been solved.
     *
     * @return true if solved, and false if not.
     */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Sets the puzzle as solved.
     * @param solved solved true if the puzzle is solved, false otherwise.
     */
    protected void setSolved(boolean solved) {
        this.solved = solved;
    }

    /**
     * Returns the description of the puzzle.
     * @return the puzzle description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the puzzle.
     * @return the puzzle name.
     */
    public String getName() {
        return name;
    }
}
