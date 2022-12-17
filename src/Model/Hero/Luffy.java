package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * This class represents the Luffy hero.
 *
 * @author Kevin Nguyen, Nicholas Zhuk and Jashanpreet Jandu
 * @version 1.0
 */
public class Luffy extends Hero {

    /**
     * The minimum special attack damage.
     */
    private final int myMinSpecialDamage = 45;

    /**
     * The maximum special attack damage.
     */
    private final int myMaxSpecialDamage = 55;

    /**
     * Luffy constructor
     */
    public Luffy() {
        super("Luffy", 120, 10, 15,
                25, 0.8, 0.2, 0.40, 10);

        try {

            BufferedImage downIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down1.png")));
            BufferedImage downIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down2.png")));
            BufferedImage downIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down3.png")));


            BufferedImage leftIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left1.png")));
            BufferedImage leftIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left2.png")));
            BufferedImage leftIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left3.png")));

            BufferedImage rightIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right1.png")));
            BufferedImage rightIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right2.png")));
            BufferedImage rightIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right3.png")));



            BufferedImage upIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up1.png")));
            BufferedImage upIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up2.png")));
            BufferedImage upIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up3.png")));

            setImages(downIm1, downIm2, downIm3, leftIm1, leftIm2, leftIm3, rightIm1, rightIm2, rightIm3,  upIm1, upIm2, upIm3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method represents the special attack of the hero.
     * @param theEnemy the enemy that is being attacked
     * @Override the specialAttack method in the MazeCharacter class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        double chance = Math.random();
        Random damage = new Random();
        System.out.println(chance);
        if (chance <= getSpecialChance()) {
            int damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used Gum Gum Pistol and dealt " + damageDealt + " damage!");
            System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
        } else {
            System.out.println(getName() + " failed to use Gum Gum Pistol!");
        }
    }
}
