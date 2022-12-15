package Controller;

import java.io.*;

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
    public static void getSaveGame() throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameManager.getSaveCurrentState());
            out.close();
            fileOut.close();
        } catch (IOException i) {
            throw new RuntimeException(i);
        }
    }

    /**
     * This method is used to load the game.
     *
     * @return Hero object that is loaded
     * @throws ClassNotFoundException
     */
    public static void getLoadGame() throws ClassNotFoundException, IOException {
        try {
            FileInputStream fileIn = new FileInputStream("save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameManager.setSaveCurrentState((SaveCurrentState) in.readObject());
            in.close();
            fileIn.close();
        } catch (IOException i) {
            throw new RuntimeException(i);
        }
    }
}