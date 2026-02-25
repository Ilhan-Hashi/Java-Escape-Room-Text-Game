package EscapeRoom.database;

import EscapeRoom.player.Player;

import java.sql.*;

/**
 * Manages all database actions related to the PLAYER table.
 * This class is responsible for creating the table,
 * adding new players, retrieving player information,
 * and checking if a username already exists.
 *
 * @author Ilhan Hashi
 * @course Java part 2
 */
public class PlayerDatabase {

    /**
     * Creates the PLAYER table in the database if
     * it doesn;t already exists.
     */
    public static void createPlayerTable() {
        String sql = """
                CREATE TABLE PLAYER (
                    ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                    USERNAME VARCHAR(255) NOT NULL UNIQUE
                )
                """;

        // Retrieves database connection.
        Connection conn = DatabaseManager.getInstance().getConnection();

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);

            // Feedback for debugging.
            //System.out.println("PLAYER table created.");
        } catch (SQLException ex) {
            // Print SQL error message for debugging.
            if (!"X0Y32".equals(ex.getSQLState())) {
                System.err.println("Database Error: Failed to create PLAYER table.");
                System.err.println("Message: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method to insert a new player into the
     * PLAYER table.
     * @param username the userName to store in the database.
     */
    public static int insertPlayer(String username) {
        // SQL statement to insert a new username into the PLAYER table.
        String sql = "INSERT INTO PLAYER (USERNAME) VALUES (?)";

        // Retrieves database connection.
        Connection conn = DatabaseManager.getInstance().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            // Set the username parameter.
            ps.setString(1, username);

            // Execute the INSERT statement.
            ps.executeUpdate();

            // Retrieve the auto-generated ID.
            ResultSet rs = ps.getGeneratedKeys();

            // If a key was generated, return it.
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.err.println("Database Error inserting PLAYER.");
            ex.printStackTrace();
        }

        // Return -1 if the insert did not succeed.
        return -1;
    }

    /**
     * Retrieves a Player from the database based on the provided username.
     * @param username the username to search for in the database.
     * @return  Player object if found, otherwise null.
     */
    public static Player getPlayer(String username) {
        // SQL query to select ID and USERNAME from the PLAYER table.
        String sql = "SELECT ID, USERNAME FROM PLAYER WHERE USERNAME = ?";

        // Retrieves database connection.
        Connection conn = DatabaseManager.getInstance().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the username parameter in the SQL query
            ps.setString(1, username);

            // Execute the query and store the result.
            ResultSet rs = ps.executeQuery();

            // If a matching record is found, create and return a Player object
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("USERNAME");
                return new Player(id, name);
            }
        } catch (SQLException ex) {
            // Print SQL error message for debugging.
            System.err.println("Database Error: Failed to retrieve PLAYER record.");
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace();
        }

        // Return null if no player was found
        return null;
    }

    /**
     * Checks if a username already exists in the PLAYER table.
     * @param username the username to search for
     * @return true if the username exists, otherwise false.
     */
    public static boolean usernameExists(String username) {
        // Flag to track if username is found.
        boolean exists = false;

        // SQL query to check if a record with the given username exists.
        String sql = "SELECT 1 FROM PLAYER WHERE USERNAME = ?";

        // Retrieves database connection.
        Connection conn = DatabaseManager.getInstance().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the username parameter in the SQL query.
            ps.setString(1, username);

            // Execute the query and store the result.
            ResultSet rs = ps.executeQuery();

            // If a record is found, update the flag.
            if (rs.next()) {
                exists = true;
            }

        } catch (SQLException ex) {
            // Print SQL error message for debugging.
            System.err.println("Database Error: Failed to check username existence.");
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace();
        }

        // Return true if a record is found or false otherwise.
        return exists;
    }
}
