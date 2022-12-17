package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class is the ending view.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Ending {
    /**
     * The ending image
     */
    private static BufferedImage endscreen;

    static {
        try {
            endscreen = ImageIO.read(Ending.class.getResourceAsStream("../View/Sprites/ending.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method draws the ending screen.
     *
     * @param theG the graphics object.
     */
    public static void draw(final Graphics2D theG) {
        theG.drawImage(endscreen, 0, 0, GameView.getScreenWidth(), GameView.getScreenWidth(), null);
    }
}