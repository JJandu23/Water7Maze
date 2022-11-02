package Controller;

/**
 * This class is used to control the input from the user.
 *
 * @author  Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */

import java.awt.event.KeyEvent;

public class InputControls {
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final int ATTACK = 4;
    private static final int SPECIAL = 5;
    private static final int POTION = 6;
    private static final int QUIT = 7;
    private static final int NUM_OF_INPUTS = 8;
    private static final int NUM_OF_KEYS = 256;
    private static final boolean[] myKeys = new boolean[NUM_OF_KEYS];
    private static final boolean[] myKeysLast = new boolean[NUM_OF_KEYS];
    private static final boolean[] myInputs = new boolean[NUM_OF_INPUTS];
    private static final boolean[] myInputsLast = new boolean[NUM_OF_INPUTS];

    public static void update() {
        for (int i = 0; i < NUM_OF_KEYS; i++) {
            myKeysLast[i] = myKeys[i];
        }
        for (int i = 0; i < NUM_OF_INPUTS; i++) {
            myInputsLast[i] = myInputs[i];
        }
    }

    public static void setKey(int theKey, boolean theBool) {
        myKeys[theKey] = theBool;
    }

    public static boolean isKey(int theKey) {
        return myKeys[theKey];
    }

    public static boolean isKeyUp(int theKey) {
        return !myKeys[theKey] && myKeysLast[theKey];
    }

    public static boolean isKeyDown(int theKey) {
        return myKeys[theKey] && !myKeysLast[theKey];
    }

    public static boolean isInput(int theInput) {
        return myInputs[theInput];
    }

    public static boolean isInputUp(int theInput) {
        return !myInputs[theInput] && myInputsLast[theInput];
    }

    public static boolean isInputDown(int theInput) {
        return myInputs[theInput] && !myInputsLast[theInput];
    }

    public static void setInput(int theInput, boolean theBool) {
        myInputs[theInput] = theBool;
    }

    public static void setInputs() {
        myInputs[UP] = myKeys[KeyEvent.VK_W] || myKeys[KeyEvent.VK_UP];
        myInputs[DOWN] = myKeys[KeyEvent.VK_S] || myKeys[KeyEvent.VK_DOWN];
        myInputs[LEFT] = myKeys[KeyEvent.VK_A] || myKeys[KeyEvent.VK_LEFT];
        myInputs[RIGHT] = myKeys[KeyEvent.VK_D] || myKeys[KeyEvent.VK_RIGHT];
        myInputs[ATTACK] = myKeys[KeyEvent.VK_SPACE];
        myInputs[SPECIAL] = myKeys[KeyEvent.VK_SHIFT];
        myInputs[POTION] = myKeys[KeyEvent.VK_P];
        myInputs[QUIT] = myKeys[KeyEvent.VK_ESCAPE];
    }
}
