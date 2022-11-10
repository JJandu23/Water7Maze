package Controller;

import Model.Hero.Hero;
import View.GameView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Model.Hero.Hero;
import View.GameView;

import java.io.*;

/**
 * This class is used to save the game.
 *
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

public class SaveManager {
 /*       public static void saveCurrentGame() throws IOException {
            File file = new File("save.ser");

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(GameManager.getHero());
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Hero loadHero() throws IOException, ClassNotFoundException {
            File file = new File("save.txt");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Hero hero = (Hero) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return hero;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void deleteSave() {
            File file = new File("save.txt");
            file.delete();
        }

        public static boolean saveExists() {
            File file = new File("save.txt");
            return file.exists();
        }

    public static void loadGame() {
        File file = new File("save.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Hero hero = (Hero) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            GameManager.setHero(hero);
            GameView gameView = new GameView();
            gameView.startGame();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
