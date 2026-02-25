package EscapeRoom.items;

import EscapeRoom.player.Player;

/**
 * Tool represents an item that can be used
 * to interact with objects in a room.
 *
 * @author Ilhan Hashi
 */
public class Tool extends Item implements Usable{
    /**
     * Creates a Tool with a name and description.
     * @param name the name of the tool.
     * @param description the description of the tool.
     */
    public Tool(String name, String description) {
        super(name, description);
    }

    /**
     * Displays the clue when used.
     * @param player the player using the item.
     */
    @Override
    public void use(Player player){
        System.out.println("You use the " + getName() + " to interact with the room.");
    }

    /**
     * Displays detailed info about the note.
     */
    @Override
    public void examine(){
        System.out.println(getDescription());
    }
}
