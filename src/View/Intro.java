package View;

import Controller.GameManager;
import Controller.InputControls;
import Model.Hero.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class is used to create the character selection screen.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Intro {
    /**
     * The hero object array for selecting the hero.
     */
    private static final Hero[] myCharacterChoice = {new Luffy(), new Zoro(), new Nami(), new Chopper()};
    /**
     * The default scale of Luffy.
     */
    static double selectedScaleLuffy = 1;
    /**
     * The default scale of Zoro.
     */
    static double selectedScaleZoro = 1;
    /**
     * The default scale of Nami.
     */
    static double selectedScaleNami = 1;
    /**
     * The default scale of Chopper.
     */
    static double selectedScaleChopper = 1;
    /**
     * The choice of hero.
     */
    private static int choice = 0;
    /**
     * The value for used for scaling the hero size.
     */
    private static double sinX = 0;
    /**
     * The x cordinate of the hero.
     */
    private static int myX = 60;
    /**
     * The y cordinate of the hero.
     */
    private static int myY = 200;
    /**
     * The image of Luffy.
     */
    private static BufferedImage luffyTxt;
    /**
     * The image of Nami.
     */
    private static BufferedImage namiTxt;
    /**
     * The image of Chopper.
     */
    private static BufferedImage chopperTxt;
    /**
     * The image of the text box.
     */
    private static BufferedImage boxTxt;
    /**
     * The image of Zoro.
     */
    private static BufferedImage zoroTxt;

    static {
        try {
            luffyTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/Luffy/luffytext.png"));
            zoroTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/Zoro/zorotext.png"));
            namiTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/Nami/namitext.png"));
            chopperTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/Chopper/choppertext.png"));
            boxTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/textbox.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method updates the game view.
     */
    public static void update() throws IOException, ClassNotFoundException {
        if (InputControls.getRight()) {
            sinX = 0;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                System.out.println(e);
            }
            if (choice == 3) {
                choice = 0;
            } else {
                choice++;
            }

        }
        if (InputControls.getLeft()) {
            sinX = 0;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                System.out.println(e);
            }
            if (choice == 0) {
                choice = 3;
            } else {
                choice--;
            }
        }
        if (InputControls.getEnter()) {
            GameManager.setHero(myCharacterChoice[choice]);
            Menus.setGameState("Maze");
        }
        if (InputControls.getO()) {
            myCharacterChoice[choice].setNoClip();
            GameManager.setHero(myCharacterChoice[choice]);
            Menus.setGameState("Maze");
        }

    }

    /**
     * This method is used to draw the character selection screen.
     *
     * @param theG
     */
    public static void draw(final Graphics2D theG) {
        BufferedImage img = null;

        if (choice == 0) img = luffyTxt;
        if (choice == 1) img = zoroTxt;
        if (choice == 2) img = namiTxt;
        if (choice == 3) img = chopperTxt;


        bobCharacter();
        theG.setColor(Color.darkGray);
        theG.fillRect(0, 0, GameView.getScreenWidth(), GameView.getScreenHeight());
        theG.drawImage(boxTxt, 0, 0, null);
        theG.drawImage(img, 0, 0, null);

        theG.drawImage(myCharacterChoice[0].getMyDefaultIm(), myX - ((int) (selectedScaleLuffy * 64) - 64), myY - ((int) (selectedScaleLuffy * 64) - 64), (int) (128 * selectedScaleLuffy), (int) (128 * selectedScaleLuffy), null);
        theG.drawImage(myCharacterChoice[1].getMyDefaultIm(), myX + 300 - ((int) (selectedScaleZoro * 64) - 64), myY - ((int) (selectedScaleZoro * 64) - 64), (int) (128 * selectedScaleZoro), (int) (128 * selectedScaleZoro), null);
        theG.drawImage(myCharacterChoice[2].getMyDefaultIm(), myX + 600 - ((int) (selectedScaleNami * 64) - 64), myY - ((int) (selectedScaleNami * 64) - 64), (int) (128 * selectedScaleNami), (int) (128 * selectedScaleNami), null);
        theG.drawImage(myCharacterChoice[3].getMyDefaultIm(), myX + 900 - ((int) (selectedScaleChopper * 64) - 64), myY - ((int) (selectedScaleChopper * 64) - 64), (int) (128 * selectedScaleChopper), (int) (128 * selectedScaleChopper), null);
    }

    /**
     * This method is used to make the character selection screen bob up and down.
     */
    private static void bobCharacter() {
        int size = 6;
        if (choice == 0) {
            sinX += 0.2;
            selectedScaleLuffy = 1 + (Math.sin(sinX)) / size;
        } else {
            selectedScaleLuffy = 1;
        }
        if (choice == 1) {
            sinX += 0.2;
            selectedScaleZoro = 1 + (Math.sin(sinX)) / size;
        } else {
            selectedScaleZoro = 1;
        }
        if (choice == 2) {
            sinX += 0.2;
            selectedScaleNami = 1 + (Math.sin(sinX)) / size;
        } else {
            selectedScaleNami = 1;
        }
        if (choice == 3) {
            sinX += 0.2;
            selectedScaleChopper = 1 + (Math.sin(sinX)) / size;
        } else {
            selectedScaleChopper = 1;
        }
    }
}
