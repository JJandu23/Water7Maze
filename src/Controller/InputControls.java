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
    private static boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, jPressed, kPressed, pPressed, oPressed, lPressed;

    /**
     * This method is used to check if the up key is pressed.
     * @return true if the up key is pressed.
     */
    public boolean getUp() {
        return upPressed;
    }

    /**
     * This method is used to check if the down key is pressed.
     * @return true if the down key is pressed.
     */
    public boolean getDown() {
        return downPressed;
    }

    /**
     * This method is used to check if the left key is pressed.
     * @return true if the left key is pressed.
     */
    public static boolean getLeft() {
        return leftPressed;
    }

    /**
     * This method is used to check if the right key is pressed.
     * @return true if the right key is pressed.
     */
    public static boolean getRight() {
        return rightPressed;
    }

    /**
     * This method is used to check if the enter key is pressed.
     * @return true if the enter key is pressed.
     */
    public static boolean getEnter() {
        return enterPressed;
    }

    /**
     * This method is used to check if the j key is pressed.
     * @return true if the j key is pressed.
     */
    public static boolean getJ() {
        return jPressed;
    }

    /**
     * This method is used to check if the k key is pressed.
     * @return true if the k key is pressed.
     */
    public static boolean getK() {
        return kPressed;
    }

    /**
     * This method is used to check if the p key is pressed.
     * @return true if the p key is pressed.
     */
    public static boolean getP() {
        return pPressed;
    }

    /**
     * This method is used to check if the o key is pressed.
     * @return true if the o key is pressed.
     */
    public static boolean getO() {
        return oPressed;
    }

    /**
     * This method is used to check if the l key is pressed.
     * @return true if the l key is pressed.
     */
    public static boolean getL() {
        return lPressed;
    }

    /**
     * Empty method to satisfy the KeyListener interface.
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
        if (code == KeyEvent.VK_J) {
            jPressed = true;
        }
        if (code == KeyEvent.VK_K) {
            kPressed = true;
        }
        if (code == KeyEvent.VK_P) {
            pPressed = true;
        }
        if (code == KeyEvent.VK_O) {
            oPressed = true;
        }
        if (code == KeyEvent.VK_L) {
            lPressed = true;
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
        if (code == KeyEvent.VK_J) {
            jPressed = false;
        }
        if (code == KeyEvent.VK_K) {
            kPressed = false;
        }
        if (code == KeyEvent.VK_P) {
            pPressed = false;
        }
        if (code == KeyEvent.VK_O) {
            oPressed = false;
        }
        if (code == KeyEvent.VK_L) {
            lPressed = false;
        }
    }
}