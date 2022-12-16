package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ending {
    private static BufferedImage endscreen;

    static {
        try {
            endscreen = ImageIO.read(Ending.class.getResourceAsStream("../View/Sprites/ending.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void draw(final Graphics2D theG) {
        theG.drawImage(endscreen, 0, 0, GameView.getScreenWidth(), GameView.getScreenWidth(), null);
    }
}