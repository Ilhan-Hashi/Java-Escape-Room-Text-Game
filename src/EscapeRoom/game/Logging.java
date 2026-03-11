package EscapeRoom.game;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Handles writing and reading log messages for the game.
 *
 * @author Ilhan Hashi
 */
public class Logging {
    private static final String LOGFILE = "logs/debug.log";

    /**
     * Writes a message to the log file.
     * @param message the message to record in the log.
     */
    public static void writeLog(String message) {
        try (FileWriter fw = new FileWriter(LOGFILE, true)) {

            fw.write(LocalDateTime.now() + " - " + message + "\n");

        } catch (IOException ex) {
            System.err.println("Failed to write log file.");
            ex.printStackTrace();
        }
    }

    /**
     * Reads and prints the contents of the log file.
     */
    public static void readLog() {
        try (FileReader fr = new FileReader(LOGFILE)) {

            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            
        } catch (IOException ex) {
            System.err.println("Failed to read log file.");
            ex.printStackTrace();
        }
    }
}
