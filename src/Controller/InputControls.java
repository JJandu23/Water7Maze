package Controller;

import Model.Hero.Hero;
import View.GameView;
import java.util.*;
import java.io.*;


/**
 * This class is used to control the input from the user.
 *
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

import java.awt.event.KeyEvent;

public class InputControls {
    private final char UP = 'w';
    private final char DOWN = 's';
    private final char LEFT = 'a';
    private final char RIGHT = 'd';
    private final char ATTACK = 'j';
    private final char SPECIAL = 'k';
    private final char ITEM = 'l';
    private final char MENU = 'm';
    private final char POTIONS = 'p';

    public char getUp() {
        return UP;
    }

    public char getDown() {
        return DOWN;
    }

    public char getLeft() {
        return LEFT;
    }

    public char getRight() {
        return RIGHT;
    }

    public char getAttack() {
        return ATTACK;
    }

    public char getSpecial() {
        return SPECIAL;
    }

    public char getItem() {
        return ITEM;
    }

    public char getMenu() {
        return MENU;
    }

    public char getPotions() {
        return POTIONS;
    }

    public static int getKeyCode(char key) {
        return switch (key) {
            case 'w' -> KeyEvent.VK_UP;
            case 's' -> KeyEvent.VK_DOWN;
            case 'a' -> KeyEvent.VK_LEFT;
            case 'd' -> KeyEvent.VK_RIGHT;
            case 'j' -> KeyEvent.VK_J;
            case 'k' -> KeyEvent.VK_K;
            case 'l' -> KeyEvent.VK_L;
            case 'm' -> KeyEvent.VK_M;
            case 'p' -> KeyEvent.VK_P;
            default -> KeyEvent.VK_UNDEFINED;
        };
    }

    public static String getKeyText(char key) {
        return switch (key) {
            case 'w' -> "Up";
            case 's' -> "Down";
            case 'a' -> "Left";
            case 'd' -> "Right";
            case 'j' -> "Attack";
            case 'k' -> "Special";
            case 'l' -> "Item";
            case 'm' -> "Menu";
            case 'p' -> "Potions";
            default -> "Undefined";
        };
    }

    public static void saveGame() {
        try {
            FileOutputStream fileOut = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameView.getHero());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in save.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream("save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Hero hero = (Hero) in.readObject();
            GameView.setHero(hero);
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Hero class not found");
            c.printStackTrace();
            return;
        }
    }
}