package EscapeRoom.game;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The StoryPrinter class is responsible for
 * displaying narrative text to the player.
 * Story text is loaded from the ResourceBundle.
 *
 * @author Ilhan Hashi
 */
public class StoryPrinter {

    // Load story resource bundle
    private static final ResourceBundle story =
            ResourceBundle.getBundle("story", Locale.getDefault());

    //region Banner
    /**
     * Prints the game banner shown at the start of the game.
     */
    public static void printGameBanner() {
        System.out.println("+---------------------------------+");
        System.out.println("|          ESCAPE ROOM            |");
        System.out.println("|              GAME               |");
        System.out.println("|                                 |");
        System.out.println("|      Can you find a way out?    |");
        System.out.println("+---------------------------------+");
        System.out.println();
    }
    //endregion

    //region Intro
    /**
     * Prints the intro story block.
     */
    public static void printIntro() {
        printStoryBlock("intro");
    }

    /**
     * Prints the welcome message for a new player.
     */
    public static void printNewPlayerWelcome() {
        System.out.println();
        System.out.println(story.getString("welcome.new"));
        System.out.println();
    }

    /**
     * Prints the welcome message for a returning player.
     *
     * @param username the returning player's username
     */
    public static void printReturningPlayerWelcome(String username) {
        System.out.println();

        String line1 = MessageFormat.format(
                story.getString("welcome.return.line1"),
                username
        );

        System.out.println(line1);
        System.out.println(story.getString("welcome.return.line2"));
        System.out.println(story.getString("welcome.return.line3"));
        System.out.println();
    }
    //endregion

    //region Story Helper
    /**
     * Prints all story lines that match the given key prefix.
     *
     * @param keyPrefix the prefix used to find story lines.
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