package Controller;

import Model.Hero.Hero;
import Model.MazeGenerator.Maze;
import View.GameView;
import Music.SoundsPlay;

import java.awt.*;

/**
 * This class is used to control the input from the user.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class GameManager {

    private static Hero myHero;
    private static GameView myGameView;
    private static SoundsPlay mySoundsPlay;
    private static SaveCurrentState mySaveCurrentState;
    private static SaveManager mySaveManager;
    private static InputControls myInputControls;

    /**
     * This is our constructor.
     *
     * @param gameView
     */
    public static void setGameView(GameView gameView) {
        myGameView = gameView;
    }

    /**
     * This method is used to get the game view.
     *
     * @return GameView
     */
    public static GameView getGameView() {
        return myGameView;
    }

    /**
     * This method is used to set the sounds play.
     *
     * @param soundsPlay
     */
    public static void setSoundsPlay(SoundsPlay soundsPlay) {
        mySoundsPlay = soundsPlay;
    }

    /**
     * This method is used to get the sounds play.
     *
     * @return SoundsPlay
     */
    public static SoundsPlay getSoundsPlay() {
        return mySoundsPlay;
    }

    public static Object getHero() {
        return myHero;
    }

    public static void setHero(Hero hero) {
        myHero = hero;
    }

    public static void setSaveCurrentState(SaveCurrentState saveCurrentState) {
        mySaveCurrentState = saveCurrentState;
    }

    public static SaveCurrentState getSaveCurrentState() {
        return mySaveCurrentState;
    }

    public static void setSaveManager(SaveManager saveManager) {
        mySaveManager = saveManager;
    }

    public static SaveManager getSaveManager() {
        return mySaveManager;
    }

    public static void setInputControls(InputControls inputControls) {
        myInputControls = inputControls;
    }

    public static InputControls getInputControls() {
        return myInputControls;
    }

    public static void draw(Graphics2D g) {
        Maze.drawRoom(g);
        Hero.draw(g);
        Maze.drawMiniMap(g);
    }

    public static void update() {
        Hero.update();
    }
}