package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * The PuzzlePiece class represents a collectible item
 * that contains part of a larger code needed to solve a puzzle.
 *
 * @author Ilhan Hashi
 */
public class PuzzlePiece extends Item implements Usable{
    // Stores the value associated with this puzzle piece
    private String puzzleValue;

    /**
     *
     * @param name the name of the puzzle piece.
     * @param description the description shown when examined.
     * @param puzzleValue the portion of the final code this piece contains.
     */
    public PuzzlePiece(String name, String description, String puzzleValue) {
        super(name, description);
        this.puzzleValue = puzzleValue;
    }

    /**
     * Returns the puzzle value.
     * @return the portion of the final code represented by this piece.
     */
    public String getPuzzleValue() {
        return puzzleValue;
    }

    /**
     * Displays the clue when used.
     * @param player the player using the item.
     */
    @Override
    public void use(Player player){
        System.out.println("This appears to be part of a larger code.");
    }

    /**
     * Displays detailed info about the note.
     */
    @Override
    public void examine(){
        System.out.println(getDescription());
    }
}
