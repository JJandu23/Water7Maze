package Controller;

import Model.Hero.Hero;
import Model.MazeGenerator.Maze;

import java.io.Serializable;

/**
 * This class is used to save the game.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class SaveCurrentState implements Serializable {

    /**
     * The hero object.
     */
    public Hero myHero;

     /**
      * The Maze object.
      */
    public static Maze myMaze;

    /**
     * This method is used to save the current state of the hero and game view.
     *
     * @param theHero is the hero object.
     *
     */
    public SaveCurrentState(Hero theHero, Maze theMaze) {
        myHero = theHero;
        myMaze = theMaze;
    }

    /**
     * This method is used to get the hero object.
     *
     * @return the hero object.
     */
    public Hero getHero() {
        return myHero;
    }

    /**
     * This method is used to get the Maze view object.
     *
     * @return the game view object.
     */
    public static Maze getMaze() {
        return myMaze;
    }
}