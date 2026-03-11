package EscapeRoom.world;

import EscapeRoom.enums.Location;
import EscapeRoom.world.rooms.*;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

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
        rooms = new TreeMap<>();
        buildRooms();
    }

    //endregion

    //region Room Builder

    /**
     * Creates and registers all rooms in the game world.
     */
    private void buildRooms() {
        rooms.put(Location.MAIN_CENTER, new MainRoom());
        rooms.put(Location.MAIN_NORTH,  new WallRoom("North Wall", Location.MAIN_NORTH, Location.NORTH_ROOM, "north.enter.light", "north.enter.dark"));
        rooms.put(Location.MAIN_EAST,   new WallRoom("East Wall",  Location.MAIN_EAST,  Location.EAST_ROOM,  "east.enter.light",  "east.enter.dark"));
        rooms.put(Location.MAIN_WEST,   new WallRoom("West Wall",  Location.MAIN_WEST,  Location.WEST_ROOM,  "west.enter.light",  "west.enter.dark"));
        rooms.put(Location.MAIN_SOUTH,  new SouthRoom("1257"));
        rooms.put(Location.EAST_ROOM,   new EastRoom());
        rooms.put(Location.WEST_ROOM,   new WestRoom());
        rooms.put(Location.NORTH_ROOM,  new NorthRoom());
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
