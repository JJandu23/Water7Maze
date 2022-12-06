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
     * This method is used to save the current state of the hero and game view.
     *
     * @param theHero is the hero object.
     * @param theGameView is the game view object.
     */
    public SaveCurrentState(final Hero theHero, final GameView theGameView) {
        myHero = theHero;
        myGameView = theGameView;
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
     * This method is used to get the game view object.
     *
     * @return the game view object.
     */
    public GameView getGameView() {
        return myGameView;
    }
}