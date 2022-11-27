package Controller;

import Model.Hero.Hero;
import View.GameView;

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
     * The game view object.
     */
    public GameView myGameView;

    /**
     * This method is used to save the current state of the hero.
     *
     * @param theHero is the hero object.
     */
    public SaveCurrentState(final Hero theHero) {
        myHero = theHero;
    }

    /**
     * This method is used to save the current state of the game view.
     *
     * @param theGameView is the game view object.
     */
    public SaveCurrentState(final GameView theGameView) {
        myGameView = theGameView;
    }
}