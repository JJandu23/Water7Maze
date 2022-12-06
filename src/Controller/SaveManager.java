package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Hero.Hero;

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
     */
    public static void getSaveGame() throws IOException, ClassNotFoundException {
        SaveCurrentState mySaveCurrentState = new SaveCurrentState((Hero) GameManager.getHero(), GameManager.getGameView());
        File myFile = new File("save.ser");
        FileOutputStream myFileOutputStream = new FileOutputStream(myFile);
        ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
        myObjectOutputStream.writeObject(mySaveCurrentState);
        myObjectOutputStream.close();
        myFileOutputStream.close();
    }

    /**
     * This method is used to load the game.
     *
     * @return Hero object that is loaded
     * @throws ClassNotFoundException
     */
    public static void getLoadGame() throws ClassNotFoundException, IOException {
        try {
            File myFile = new File("save.ser");
            FileInputStream myFileInputStream = new FileInputStream(myFile);
            ObjectInputStream myObjectInputStream = new ObjectInputStream(myFileInputStream);
            SaveCurrentState mySaveCurrentState = (SaveCurrentState) myObjectInputStream.readObject();
            GameManager.setGameView(mySaveCurrentState.getGameView());
            GameManager.setHero(mySaveCurrentState.getHero());
            myObjectInputStream.close();
            myFileInputStream.close();
        } catch (IOException e) {
            System.out.println("No Save File Found");
            e.printStackTrace();
        }
    }
}