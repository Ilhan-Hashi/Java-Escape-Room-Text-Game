package EscapeRoom.puzzles;

/**
 * The Puzzle class represents a challenge
 * that the player must solve.
 *
 * @author Ilhan Hashi
 */
public abstract class Puzzle {
    //region Fields

    private String name;
    private boolean solved;

    //endregion

    //region Constructor

    /**
     * Creates a new puzzle/
     * @param name the name of the puzzle.
     * @param solved whether the puzzle is already solved.
     */
    public Puzzle(String name, boolean solved) {
        this.name = name;
        this.solved = solved;
    }

    //endregion

    //region Getters

    public String getName() {return name;}
    public boolean isSolved() {return solved;}

    //endregion

    //region Helper Methods
    protected void setSolved(boolean solved) {this.solved = solved;}
    //endregion

    //region Abstract Methods
    public abstract void attempt(String input);
    public abstract String getHint();
    //endregion
}