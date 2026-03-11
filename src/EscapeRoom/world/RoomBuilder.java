package EscapeRoom.world;

import EscapeRoom.enums.Location;
import EscapeRoom.world.rooms.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages all of the rooms in the game.
 *
 * @author Ilhan Hashi
 */
public class RoomBuilder {
    //region Fields

    private Map<Location, Room> rooms;

    //endregion

    //region Constructor

    /**
     * Creates the game room and initializes the rooms.
     */
    public RoomBuilder() {
        rooms = new HashMap<>();
        buldRooms();
    }

    //endregion

    //region Room Builder
    private void buldRooms() {
    }

    //endregion

    //region Getters

    /**
     * Gets a room by its location.
     */
    public Room getRoom(Location location) {
        return rooms.get(location);
    }

    /**
     * Gets all rooms in the room builder.
     */
    public Collection<Room> getRooms() {
        return rooms.values();
    }
    //endregion


}
