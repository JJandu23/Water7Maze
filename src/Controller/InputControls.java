package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to control the input from the user.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class InputControls implements KeyListener {
    private static boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    private static final int[] mouseClickedCoords = new int[2];

    public boolean getUp() {
        return upPressed;
    }

    public boolean getDown() {
        return downPressed;
    }

    public static boolean getLeft() {
        return leftPressed;
    }

    public static boolean getRight() {
        return rightPressed;
    }

    public static boolean getEnter() {
        return enterPressed;
    }

    public char getAttack() {
        return 'j';
    }

    public char getSpecial() {
        return 'k';
    }

    public char getItem() {
        return 'l';
    }

    public char getMenu() {
        return 'm';
    }

    public char getSenzuBean() {
        return 'p';
    }

    public char getPowerFruit() {
        return 'o';
    }

    public char getSpeedFruit() {
        return 'i';
    }

    /**
     * This method is used to get the key pressed.
     *
     * @param theKey is the key pressed.
     */
    public static int getKeyCode(final char theKey) {
        return switch (theKey) {
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
            case 'u' -> KeyEvent.VK_U;
            case 'y' -> KeyEvent.VK_Y;
            default -> KeyEvent.VK_UNDEFINED;
        };
    }

    /**
     * This method is used to get the key code.
     *
     * @param theKey is the key pressed.
     */
    public static String getKeyText(final char theKey) {
        return switch (theKey) {
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
            case 'u' -> "Save";
            case 'y' -> "Load";
            default -> "Undefined";
        };
    }

    @Override
    public void keyTyped(final KeyEvent theEvent) {
        // this method is set to be empty
    }

    /**
     * This method is used to get the key pressed.
     *
     * @param theEvent KeyEvent
     */
    @Override
    public void keyPressed(final KeyEvent theEvent) {
        int code = theEvent.getKeyCode();

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
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }

    /**
     * This method is used to get the key released.
     *
     * @param theEvent KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent theEvent) {
        int code = theEvent.getKeyCode();

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
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
    }
}