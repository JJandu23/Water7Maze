package Controller;

/**
 * This class is used to control the input from the user.
 *
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

import java.awt.event.KeyEvent;

public class InputControls {
    private static final char UP = 'w';
    private static final char DOWN = 's';
    private static final char LEFT = 'a';
    private static final char RIGHT = 'd';
    private static final char ATTACK = 'j';
    private static final char SPECIAL = 'k';
    private static final char ITEM = 'l';
    private static final char MENU = 'm';
    private static final char POTIONS = 'p';

    public static char getUp() {
        return UP;
    }

    public static char getDown() {
        return DOWN;
    }

    public static char getLeft() {
        return LEFT;
    }

    public static char getRight() {
        return RIGHT;
    }

    public static char getAttack() {
        return ATTACK;
    }

    public static char getSpecial() {
        return SPECIAL;
    }

    public static char getItem() {
        return ITEM;
    }

    public static char getMenu() {
        return MENU;
    }

    public static char getPotions() {
        return POTIONS;
    }

public static char getKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                return UP;
            case KeyEvent.VK_S:
                return DOWN;
            case KeyEvent.VK_A:
                return LEFT;
            case KeyEvent.VK_D:
                return RIGHT;
            case KeyEvent.VK_J:
                return ATTACK;
            case KeyEvent.VK_K:
                return SPECIAL;
            case KeyEvent.VK_L:
                return ITEM;
            case KeyEvent.VK_M:
                return MENU;
            case KeyEvent.VK_P:
                return POTIONS;
            default:
                return ' ';
        }
    }

    public static int getKeyCode(char key) {
        switch (key) {
            case UP:
                return KeyEvent.VK_W;
            case DOWN:
                return KeyEvent.VK_S;
            case LEFT:
                return KeyEvent.VK_A;
            case RIGHT:
                return KeyEvent.VK_D;
            case ATTACK:
                return KeyEvent.VK_J;
            case SPECIAL:
                return KeyEvent.VK_K;
            case ITEM:
                return KeyEvent.VK_L;
            case MENU:
                return KeyEvent.VK_M;
            case POTIONS:
                return KeyEvent.VK_P;
            default:
                return KeyEvent.VK_UNDEFINED;
        }
    }
}
