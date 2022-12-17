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

    /**
     * Boolean to check if the key is pressed.
     */
    private static boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, oPressed;

    /**
     * This method is used to check if the up key is pressed.
     *
     * @return true if the up key is pressed.
     */
    public boolean getUp() {
        return upPressed;
    }

    /**
     * This method is used to check if the down key is pressed.
     *
     * @return true if the down key is pressed.
     */
    public boolean getDown() {
        return downPressed;
    }

    /**
     * This method is used to check if the left key is pressed.
     *
     * @return true if the left key is pressed.
     */
    public static boolean getLeft() {
        return leftPressed;
    }

    /**
     * This method is used to check if the right key is pressed.
     *
     * @return true if the right key is pressed.
     */
    public static boolean getRight() {
        return rightPressed;
    }

    /**
     * This method is used to check if the enter key is pressed.
     *
     * @return true if the enter key is pressed.
     */
    public static boolean getEnter() {
        return enterPressed;
    }

    /**
     * This method is used to check if the o key is pressed.
     *
     * @return true if the o key is pressed.
     */
    public static boolean getO() {
        return oPressed;
    }

    /**
     * Empty method to satisfy the KeyListener interface.
     *
     * @param theEvent the event to be processed
     */
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
        if (code == KeyEvent.VK_O) {
            oPressed = true;
        }
    }

    /**
     * This method is used to get the key released.
     *
     * @param theEvent KeyEvent
     */
    @Override
    public void keyReleased(final KeyEvent theEvent) {
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
        if (code == KeyEvent.VK_O) {
            oPressed = false;
        }
    }
}