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
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

public class SaveManager {
}

//    private static final SaveManager saveManager = null;
//    private static SaveCurrentState saveCurrentState = null;
//
//    public static Object getSaveManager() {
//        return null;
//    }
//
//    public static void setSaveManager(SaveManager saveManager) {
//    }
//
//    public static void setSaveCurrentState(SaveCurrentState saveCurrentState) {
//    }
//
//    /**
//     * This method is used to save the game.
//     * @throws IOException
//     * @throws ClassNotFoundException
//     */
//    public static void saveGame() throws IOException, ClassNotFoundException {
//        try {
//            File file = new File("save.ser");
//            FileOutputStream fileOut = new FileOutputStream(file);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(saveCurrentState);
//            out.close();
//            fileOut.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
//    }
//
//    /**
//     * This method is used to load the game.
//     * @throws IOException
//     * @throws ClassNotFoundException
//     */
//    public static void loadGame() throws IOException, ClassNotFoundException {
//        try {
//            File file = new File("save.ser");
//            FileInputStream fileIn = new FileInputStream(file);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            saveCurrentState = (SaveCurrentState) in.readObject();
//            in.close();
//            fileIn.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Save file not found");
//            c.printStackTrace();
//        }
//    }
//}