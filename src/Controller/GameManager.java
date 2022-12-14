package Controller;

import Model.Battle;
import Model.Hero.Hero;
import Model.MazeGenerator.Maze;
import Music.SoundsPlay;
import View.BattleView;
import View.GameView;
import View.Intro;
import View.Menus;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

import static Controller.SaveManager.getSaveGame;

/**
 * This class is used to control the input from the user.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class GameManager {

    /**
     * The hero object.
     */
    private static Hero myHero;

    /**
     * The GameView object.
     */
    private static GameView myGameView;

    /**
     * The SaveCurrentGame object.
     */
    private static SaveCurrentState mySaveCurrentState;

    /**
     * The SaveManger object.
     */
    private static SaveManager mySaveManager;

    /**
     * The InputControls object.
     */
    private static InputControls myInputControls;
    
    /**
     * The Maze object.
     */
    private static Maze myMaze;

    private static boolean isLastFrameDrawn = false;

    private static Battle myCurrentBattle;
    private static BattleView myCurrentBattleView;

    public enum HeroName{
        LUFFY,
        NAMI,
        CHOPPER,
        ZORO
    }



    /**
     * This is our constructor.
     *
     * @param theGameView is the GameView object.
     */
    public static void setGameView(final GameView theGameView) {
        myGameView = theGameView;
    }

    /**
     * This method is used to get the GameView object.
     *
     * @return the GameView object.
     */
    public static GameView getGameView() {
        return myGameView;
    }

    /**
     * This method is used to get the Hero object.
     *
     * @return the Hero object.
     */
    public static Hero getHero() {
        return myHero;
    }

    /**
     * This method is used to set the Hero object.
     *
     * @param theHero is the Hero object.
     */
    public static void setHero(final Hero theHero) {
        myHero = theHero;
    }

    /**
     * This method is used to set the save current state.
     *
     * @param theSaveCurrentState is the current state of the game.
     */
    public static void setSaveCurrentState(final SaveCurrentState theSaveCurrentState) {
        mySaveCurrentState = theSaveCurrentState;
    }

    /**
     * This method is used to get the save current state.
     *
     * @return the current state of the game.
     */
    public static SaveCurrentState getSaveCurrentState() {
        return mySaveCurrentState;
    }

    /**
     * This method is used to set the save manager.
     *
     * @param theSaveManager is the save manager.
     */
    public static void setSaveManager(final SaveManager theSaveManager) {
        mySaveManager = theSaveManager;
    }

    /**
     * This method is used to get the save manager.
     *
     * @return the save manager.
     */
    public static SaveManager getSaveManager() {
        return mySaveManager;
    }

    /**
     * This method is used to set the input controls.
     *
     * @param theInputControls is the input controls.
     */
    public static void setInputControls(final InputControls theInputControls) {
        myInputControls = theInputControls;
    }

    /**
     * This method is used to get the input controls.
     *
     * @return the input controls.
     */
    public static InputControls getInputControls() {
        return myInputControls;
    }

    /**
     * This method is used draw the maze, the hero, and the maze mini map.
     *
     * @param theGraphics is the graphics object.
     */
    public static void draw(final Graphics2D theGraphics) {
        switch (Menus.getGameState()) {
            case "Maze":

                Maze.drawRoom(theGraphics);
                myHero.draw(theGraphics);
                Maze.drawMiniMap(theGraphics);

                if((Maze.getCurrentRoom().getEnemy() != null || Maze.getCurrentRoom().hasKey()) && !isLastFrameDrawn){
                    Maze.drawRoom(theGraphics);
                    myHero.draw(theGraphics);
                    Maze.drawMiniMap(theGraphics);
                    isLastFrameDrawn = true;
                }
                break;
            case "Intro":
                Intro.draw(theGraphics);
                break;
            case "Battle":

                myCurrentBattleView.draw(theGraphics);
            case "Dialogue", "Ending":
                break;
        }
    }

    /**
     * This method is used to update the hero.
     */
    public static void update() {
        switch (Menus.getGameState()) {
            case "Maze":
                if(InputControls.getK()){
                    try {
                        getSaveGame();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                myHero.update();
                if((Maze.getCurrentRoom().getEnemy() != null || Maze.getCurrentRoom().hasKey()) && isLastFrameDrawn){

                    if(Maze.getCurrentRoom().hasKey()){
                        Maze.getCurrentRoom().setRoomKey();
                    } else if(Maze.getCurrentRoom().getEnemy() != null) {

                        new Battle(myHero, Maze.getCurrentRoom().getEnemy());

                        Maze.killEnemy();
                        Maze.getCurrentRoom().setRoomEnemy(null);

                        /*Menus.setGameState("Battle");*/
                    } else if(Maze.getCurrentRoom().isEnd() && Maze.isFinished()){
                        Menus.setGameState("Ending");
                    }

                    isLastFrameDrawn = false;
                }
                if(Maze.getCurrentRoom().isEnd() && Maze.isFinished()){
                    Menus.setGameState("Ending");
                }
                if(Maze.getCurrentRoom().isEnd()){
                    System.out.println("In end room: "  + Maze.getCurrentRoom().getRoomType());
                }
                if(!myHero.isAlive()){
                    Menus.setGameState("Ending");
                }
                break;
            case "Intro":
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intro.update();
                break;

            case "Battle":
                //myCurrentBattle = new Battle(myHero, Maze.getCurrentRoom().getEnemy(), new BattleView(getHero().getName(), Maze.getCurrentRoom().getEnemy().getName()));

            case "Dialogue", "Ending":
                break;
        }
    }

    /**
     * This method is used to set the maze.
     *
     * @param theMaze is the maze.
     */
    public static void setMaze(final Maze theMaze) {
        myMaze = theMaze;
    }

    /**
     * This method is used to get the maze.
     *
     * @return the maze.
     */
    public static Maze getMaze() {
        return myMaze;
    }


    public static void drawBattle(final Graphics2D theGraphics){
        myCurrentBattleView.draw(theGraphics);
    }

    public static void music() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (Menus.getGameState()) {
            case "Intro":
                SoundsPlay.playSongs(SoundsPlay.Song.OPENING);
                break;
            case "Maze":
                SoundsPlay.playSongs(SoundsPlay.Song.IN_GAME);
                break;
            case "Battle":
                SoundsPlay.playSongs(SoundsPlay.Song.IN_GAME);
                break;
            case "Dialogue", "Ending":
                SoundsPlay.playSongs(SoundsPlay.Song.THE_ONE_PIECE);
                break;

        }
    }

}