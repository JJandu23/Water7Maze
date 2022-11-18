package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputControls implements KeyListener {
    private final char UP = 'w';
    private final char DOWN = 's';
    private final char LEFT = 'a';
    private final char RIGHT = 'd';
    private final char ATTACK = 'j';
    private final char SPECIAL = 'k';
    private final char ITEM = 'l';
    private final char MENU = 'm';
    private final char SENZU_BEAN = 'p';
    private final char SAVE = 'o';
    private final char LOAD = 'i';

    //make static shit idk
    private static boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean getUp() {

        return upPressed;
    }

    public boolean getDown() {

        return downPressed;
    }

    public boolean getLeft() {
        return leftPressed;
    }

    public boolean getRight() {
        return rightPressed;
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

    public char getSenzuBean() {
        return SENZU_BEAN;
    }

    public char getSave() {
        return SAVE;
    }

    public char getLoad() {
        return LOAD;
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
            case 'o' -> KeyEvent.VK_O;
            case 'i' -> KeyEvent.VK_I;
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
            case 'p' -> "Senzu Bean";
            case 'o' -> "Power Fruit";
            case 'i' -> "Speed Fruit";
            default -> "Undefined";
        };
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}