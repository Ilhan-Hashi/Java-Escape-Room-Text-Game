package EscapeRoom.game;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Prints story text for the game.
 *
 * @author Ilhan Hashi
 */
public class StoryPrinter {

    //region Field

    // Load story resource bundle
    private static final ResourceBundle story =
            ResourceBundle.getBundle("story", Locale.getDefault());

    //endregion

    //region Banner

    /**
     * Prints the game banner.
     */
    public static void printBanner() {

        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.println("|          ESCAPE ROOM            |");
        System.out.println("|              GAME               |");
        System.out.println("|                                 |");
        System.out.println("|      Can you find a way out?    |");
        System.out.println("+---------------------------------+");
        System.out.println();

    }

    //endregion

    //region Player

    /**
     * Prints tje welcome message for a new player.
     */
    public static void printNewPlayerWelcome() {
        printStoryBlock("welcome.new");
    }

    /**
     * Prints the welcome message for a returning player.
     */
    public static void printReturningPlayerWelcome(String username) {
        System.out.println(MessageFormat.format(story.getString("welcome.return.1"), username));
        System.out.println(story.getString("welcome.return.2"));
        System.out.println(story.getString("welcome.return.3"));
        System.out.println();
    }

    //endregion

    //region Story Helper

    /**
     * Prints a story block from the resource file.
     */
    public static void printStoryBlock(String keyPrefix) {

        int line = 1;

        while (true) {

            String key = keyPrefix + "." + line;

            if (!story.containsKey(key)) {
                break;
            }

            System.out.println(story.getString(key));
            line++;
        }

        System.out.println();
    }

    //endregion
}