package EscapeRoom.enums;

/**
 * Represents the player's current location in the game.
 *
 * @author Ilhan Hashi
 */
public enum Location {
    // Main room positions.
    MAIN_CENTER,
    MAIN_NORTH,
    MAIN_EAST,
    MAIN_WEST,
    MAIN_SOUTH,

    // Puzzle rooms connected to the main room.
    EAST_ROOM,
    WEST_ROOM,
    NORTH_ROOM
}