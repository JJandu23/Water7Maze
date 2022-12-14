package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import Controller.GameManager.HeroName;

import javax.imageio.ImageIO;

import static Controller.GameManager.HeroName.*;

/**
 * This class is used for the BattleView.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class BattleView {

    private HashMap<String, BufferedImage> myBattleImages = new HashMap<>();
    private int myHeroX1 = 200, myHeroY1 = 500, myHeroX2 = myHeroX1 + 100, myHeroY2 = myHeroY1 + 100;
    private int myEnemyX1 = 500, myEnemyY1 = 200, myEnemyX2 = myEnemyX1 + 100, myEnemyY2 = myEnemyY1 + 100;




    public BattleView(String theHero, String theEnemy){
        try {
            switch (theHero) {
                case "Luffy":
                    myBattleImages.put("hero", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up1.png")));
                    myBattleImages.put("moveset", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/luffytext.png")));
                    break;
                case "Zoro":
                    myBattleImages.put("hero", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up1.png")));
                    myBattleImages.put("moveset", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/zorotext.png")));
                    break;
                case "Nami":
                    myBattleImages.put("hero", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/up1.png")));
                    myBattleImages.put("moveset", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/namitext.png")));
                    break;
                case "Chopper":
                    myBattleImages.put("hero", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/up1.png")));
                    myBattleImages.put("moveset", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/choppertext.png")));
                    break;
            }
            switch (theEnemy) {
                case "Boat Kevin" -> myBattleImages.put("enemy", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/EnemySprites/Boat Kevin.png")));
                case "Nikolai" -> myBattleImages.put("enemy", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/EnemySprites/Nikolai.png")));
                case "SadBoySea" -> myBattleImages.put("enemy", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/EnemySprites/SadBoySea.png")));
                case "Eli" -> myBattleImages.put("enemy", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/EnemySprites/Eli.png")));
            }

            myBattleImages.put("textbox", ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/EnemySprites/Boat Kevin.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(final Graphics2D theG) {
        theG.setColor(Color.white);
        theG.fillRect(0,0,GameView.getScreenWidth(), GameView.getScreenHeight());
        theG.drawImage(myBattleImages.get("hero"), myHeroX1, myHeroY1, null);
        theG.drawImage(myBattleImages.get("enemy"), myEnemyX1, myEnemyY1, null);
        theG.drawImage(myBattleImages.get("texbox"), 0, GameView.getScreenHeight()-200, null);

    }

}
