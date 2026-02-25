package EscapeRoom.items;

import EscapeRoom.player.Player;

public class Key extends Item implements Usable{
    /**
     * reates a Key with a name and description.
     * @param name the name of the key.
     * @param description the description of the key.
     */
    public Key(String name, String description) {
        super(name, description);
    }

    /**
     * Displays the clue when used.
     * @param player the player using the item.
     */
    @Override
    public void use(Player player){
        System.out.println("You try using the " + getName() + ".");
    }

    /**
     * Displays detailed info about the note.
     */
    @Override
    public void examine(){
        System.out.println(getDescription());
    }
}
