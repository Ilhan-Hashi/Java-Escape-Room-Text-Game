package EscapeRoom.database;

import org.apache.derby.jdbc.EmbeddedDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Manages the database connection using the Singleton pattern.
 * The DatabaseManager class ensures that only one database
 * connection is created and shared throughout the application.
 *
 * @author Ilhan Hashi
 * @course Java part 2
 */
public class DatabaseManager {
    // Single instance of DatabaseManager.
    private static DatabaseManager instance;

    // Active database connection.
    private Connection connection;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the embedded Derby database connection.
     */
    private DatabaseManager() {
        try {
            // Configure embedded Derby data source.
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName("EscapeRoom");
            ds.setCreateDatabase("create");

            // Get connection.
            connection = ds.getConnection();
            //System.out.println("Database connected.");
        } catch (SQLException ex) {
            // Print SQL error details for debugging.
            System.err.println("Database Error: Failed to establish connection.");
            System.err.println("Message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Returns the single instance of DatabaseManager.
     * Creates the instance if it does not already exist.
     * @return the DatabaseManager instance.
     */
    public static DatabaseManager getInstance() {
        // Create the instance if it does not already exist.
        if (instance == null) {
            instance = new DatabaseManager();
        }

        // Return the existing or newly created instance.
        return instance;
    }

    /**
     * Returns the active database connection.
     * @return the active Connection object
     * @throws IllegalStateException if the connection was not created.
     */
    public Connection getConnection() {
        // Check if the connection was successfully initialized.
        if (connection == null) {
            throw new IllegalStateException("Database connection was not created.");
        }

        // Return the active database connection.
        return connection;
    }

    /**
     * Closes the database connection if it is open.
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                System.err.println("Database Error: Failed to close connection.");
                ex.printStackTrace();
            }
        }
    }
}
