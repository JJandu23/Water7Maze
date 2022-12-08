package View;

import Controller.GameManager;
import Model.MazeGenerator.Maze;
import Music.SoundsPlay;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * This class is used to start the game.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Water 7 Maze");
        GameManager.setMaze(new Maze(1, 10, 10));
        GameView gameView = new GameView();
        window.add(gameView);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameView.startGameThread();

        try {
            GameManager.music();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}