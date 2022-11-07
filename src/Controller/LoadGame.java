package Controller;

import Model.Hero.Hero;
import View.GameView;

import java.io.*;

/**
 * This class is used to load the game.
 *
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

public class LoadGame {

    public static void loadGame() {
        File file = new File("save.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Hero hero = (Hero) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            //GameManager.setHero(hero);
            GameView gameView = new GameView();
           // gameView.startGame();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}