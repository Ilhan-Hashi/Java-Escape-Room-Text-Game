package EscapeRoom;

/**
 * The Puzzle class is an abstract class for all puzzle types
 * in the game. It stores shared puzzles data such as description and
 * solved state.
 *
 *  * @author Ilhan Hashi
 *  * @course Java Part 2
 */
public abstract class Puzzle {
    // Protected properties that describes the puzzle
    // tracks whether the puzzle has been solved.
    protected String description;
    protected boolean solved;

    /**
     * Default constructor.
     * Initializes a puzzle in an unsolved state.
     */
    public Puzzle() {
        this.solved = false;
    };

    /**
     * Returns the puzzle description.
     * @return the puzzle description.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Returns whether the puzzle has been solved.
     * @return true if the puzzle is solved, false otherwise.
     */
    public boolean isSolved() {
        return solved;
    }
}
