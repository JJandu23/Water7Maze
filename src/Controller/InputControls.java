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
    private static boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, jPressed, kPressed, pPressed, oPressed, lPressed;
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

    public static boolean getJ() {
        return jPressed;
    }

    public static boolean getK() {
        return kPressed;
    }

    public static boolean getP() {
        return pPressed;
    }

    public static boolean getO() {
        return oPressed;
    }

    public static boolean getL() {
        return lPressed;
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