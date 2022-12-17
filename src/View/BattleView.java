package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * This class is used for the BattleView.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class BattleView {
    /**
     * HashMap of the images
     */
    private HashMap<String, BufferedImage> myBattleImages = new HashMap<>();
    /**
     * The hero's image dimensions
     */
    private int myHeroX1 = 200, myHeroY1 = 500, myHeroX2 = myHeroX1 + 100, myHeroY2 = myHeroY1 + 100;
    /**
     * The enemy's image dimensions
     */
    private int myEnemyX1 = 500, myEnemyY1 = 200, myEnemyX2 = myEnemyX1 + 100, myEnemyY2 = myEnemyY1 + 100;

    /**
     * This method draws the battle view.
     *
     * @param theG the graphics object.
     */
    public void draw(final Graphics2D theG) {
        theG.setColor(Color.white);
        theG.fillRect(0, 0, GameView.getScreenWidth(), GameView.getScreenHeight());
        theG.drawImage(myBattleImages.get("hero"), myHeroX1, myHeroY1, null);
        theG.drawImage(myBattleImages.get("enemy"), myEnemyX1, myEnemyY1, null);
        theG.drawImage(myBattleImages.get("texbox"), 0, GameView.getScreenHeight() - 200, null);
    }
}
