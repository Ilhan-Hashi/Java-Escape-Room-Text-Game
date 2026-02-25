package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * CLueNote class represents a readable not that gives hints.
 *
 * @author Ilhan Hashi
 */
public class ClueNote extends Item implements Usable{
    /**
     * reates a ClueNote with a name and description.
     * @param name the name of the note.
     * @param description the description of the note.
     */
    public ClueNote(String name, String description){
        super(name, description);
    }

    /**
     * Displays the clue when used.
     * @param player the player using the item.
     */
    @Override
    public void use(Player player){
        System.out.println("You read the note:");
    }

    /**
     * Displays detailed info about the note.
     */
    @Override
    public void examine(){
        System.out.println(getDescription());
    }
}
