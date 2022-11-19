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
    public Hero myHero;
    public GameView myGameView;

    /**
     * This method is used to save the current state of the hero.
     * @param hero
     */
    public SaveCurrentState(Hero hero) {
        myHero = hero;
    }

    /**
     * This method is used to save the current state of the game view.
     * @param gameView
     */
    public SaveCurrentState(GameView gameView) {
        myGameView = gameView;
    }
}