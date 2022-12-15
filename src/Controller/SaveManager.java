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
        SaveCurrentState mySaveCurrentState = new SaveCurrentState(GameManager.getHero(), GameManager.getMaze());
        FileOutputStream fileOut = new FileOutputStream("save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(mySaveCurrentState);
        out.close();
        fileOut.close();
    }

    /**
     * This method is used to load the game.
     *
     * @return Hero object that is loaded
     * @throws ClassNotFoundException
     */
    public static void getLoadGame() throws ClassNotFoundException, IOException {
        SaveCurrentState mySaveCurrentState;
        FileInputStream fileIn = new FileInputStream("save.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        mySaveCurrentState = (SaveCurrentState) in.readObject();
        in.close();
        fileIn.close();
        GameManager.setHero(mySaveCurrentState.getHero());
        GameManager.setMaze(mySaveCurrentState.getMaze());
    }
}