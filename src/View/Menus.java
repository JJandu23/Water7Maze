package View;

import Controller.GameManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class is used to create the game menu.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Menus {

    /**
     * The gamestate of the view.
     */
    private static String myGameState = "Intro";

    /**
     * This method is used to get the gamestate.
     *
     * @return The gamestate.
     */
    public static String getGameState() {
        return myGameState;
    }

    /**
     * This method is used to set the gamestate.
     *
     * @param theState The gamestate.
     */
    public static void setGameState(final String theState) {
        if (theState.equals("Intro") || theState.equals("Maze") || theState.equals("Battle") ||
                theState.equals("Dialogue") || theState.equals("Ending")) {
            myGameState = theState;
            try {
                GameManager.music();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Error!!!");
        }
    }
}