package View;

import Controller.GameManager;
import Model.Hero.Luffy;

import javax.swing.*;

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