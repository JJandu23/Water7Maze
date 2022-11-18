package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Hero.Hero;
import View.GameView;

/**
 * This class is used to save the game.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

public class SaveManager {

    /**
     * This method is used to save the game.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void saveGame() throws IOException, ClassNotFoundException {
        File file = new File("save.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(GameManager.getHero());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * This method is used to load the game.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @return Hero
     */
    public static void loadGame() throws IOException, ClassNotFoundException {
        try {
            File file = new File("save.ser");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Hero hero = (Hero) objectInputStream.readObject();
            GameManager.setHero(hero);
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("No save file found.");
            e.printStackTrace();
        }
    }
}