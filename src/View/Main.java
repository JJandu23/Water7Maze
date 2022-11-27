package View;

import Controller.GameManager;
import Model.Hero.Luffy;

import javax.swing.*;

/**
 * This class is used to create the game view.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Water 7 Maze");

        GameManager.setHero(new Luffy());
        GameView gameView = new GameView();
        window.add(gameView);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameView.startGameThread();
    }
}