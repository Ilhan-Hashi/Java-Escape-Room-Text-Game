package EscapeRoom.puzzles;

import EscapeRoom.game.StoryPrinter;

public class CodePuzzle extends Puzzle {
    //region Fields
    private final String answer;

    //endregion

    //region Constructor

    /**
     * Creates a puzzle code with the answer.
     * @param answer the code required to solve the puzzle
     */
    public CodePuzzle(String answer) {
        super("Keypad");
        this.answer = answer;
    }
    //endregion

    //region Behavior

    /**
     * Attempts to solve the puzzle using the given code.
     */
    public void attempt(String input) {
        if (isSolved()) {
            System.out.println("The door is already open.");
            return;
        }

        StoryPrinter.printStoryBlock("mainRoom.keypad.enter");

        if (input.equals(answer)) {
            setSolved(true);
            StoryPrinter.printStoryBlock("mainRoom.keypad.correct");
        } else {
            StoryPrinter.printStoryBlock("mainRoom.keypad.wrong");
        }
    }

    /**
     * Returns a hint for solving the puzzle.
     */
    @Override
    public String getHint() {
        return "You must enter a four-digit code.";
    }

    //endregion
}
