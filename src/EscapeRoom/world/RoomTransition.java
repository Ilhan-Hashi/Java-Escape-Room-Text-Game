package EscapeRoom.world;

import EscapeRoom.enums.Location;

/**
 * Listens for when the player moves to a different room.
 *
 * @author Ilhan Hashi
 */
public interface RoomTransition {
    /**
     * When the player transitions to a new room.
     * @param destination the room the player entered.
     */
    void transition(Location destination);
}
