package Controller;

import Model.Battle;
import Model.Hero.Hero;
import Model.MazeGenerator.Maze;
import Music.SoundsPlay;
import View.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

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
    public static Hero myHero;

    /**
     * The GameView object.
     */
    private static GameView myGameView;

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
        LUFFY, NAMI, CHOPPER, ZORO
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
                Ending.draw(theGraphics);
                break;
                case "Save", "Load":
                    GameManager Save = new GameManager();
                    Save.draw(theGraphics);
                break;
        }
    }

    /**
     * This method is used to update the hero.
     */
    public static void update() throws IOException, ClassNotFoundException {
        switch (Menus.getGameState()) {
            case "Maze":

                myHero.update();
                if((Maze.getCurrentRoom().getEnemy() != null || Maze.getCurrentRoom().hasKey()) && isLastFrameDrawn){
                    try {

                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

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