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
    private static String myGameState = "Intro";

    public static void setGameState(String state){
        if (state.equals("Intro") || state.equals("Maze") || state.equals("Battle") ||
                state.equals("Dialogue") || state.equals("Ending")) {
            myGameState = state;
            try {
                GameManager.music();
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Error!!!");
        }
    }

    public static String getGameState() {
        return myGameState;
    }
}
