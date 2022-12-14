package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * This class represents the Zoro hero.
 *
 * @author Kevin Nguyen
 * @version 1.0
 */
public class Zoro extends Hero {
    /**
     * The minimum special damage.
     */
    private final int myMinSpecialDamage = 50;

    /**
     * The maximum special damage.
     */
    private final int myMaxSpecialDamage = 60;

    /**
     * Zoro constructor
     */
    public Zoro() {
        super("Zoro", 110, 8, 15, 25,
                .6, .2, .4, 9);
        try {
            BufferedImage downIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down1.png")));
            BufferedImage downIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down2.png")));
            BufferedImage downIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down3.png")));

            BufferedImage leftIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left1.png")));
            BufferedImage leftIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left2.png")));
            BufferedImage leftIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left3.png")));

            BufferedImage rightIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right1.png")));
            BufferedImage rightIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right2.png")));
            BufferedImage rightIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right3.png")));

            BufferedImage upIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up1.png")));
            BufferedImage upIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up2.png")));
            BufferedImage upIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up3.png")));

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
        Random chance = new Random();
        Random damage = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            int damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used purgatory onigiri and dealt " + damageDealt + " damage!");
        } else {
            System.out.println(getName() + " failed to use purgatory onigiri!");
        }
    }
}
