package EscapeRoom;

/**
 * The Player class represents a player in the game.
 * It stores the play'a name and provides a greeting.
 *
 *  * @author Ilhan Hashi
 *  * @course Java Part 2
 */
public class Player {
    // Private property to store the play's name.
    public String name;

    /**
     * Constructs a Player with the specified name.
     * @param name the player's name.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the player's name.
     * @return they player's name.
     */
    public String getName() {return name;}
}
