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

    // Load story resource bundle
    private static final ResourceBundle story =
            ResourceBundle.getBundle("story", Locale.getDefault());

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