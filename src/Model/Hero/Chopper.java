package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * This class represents the Chopper hero.
 *
 * @author Kevin Nguyen
 * @version 1.0
 */
public class Chopper extends Hero {

    /**
     * The minimum special heal.
     */
    private final int myMinSpecialHeal = 20;

    /**
     * The maximum special heal.
     */
    private final int myMaxSpecialHeal = 30;

    /**
     * Chopper constructor
     */
    public Chopper() {
        super("Chopper", 100, 10, 10,
                20, 0.5, 0.3, 0.20, 3);
        try {
            BufferedImage downIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/down1.png")));
            BufferedImage downIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/down2.png")));
            BufferedImage downIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/down3.png")));

            BufferedImage leftIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/left1.png")));
            BufferedImage leftIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/left2.png")));
            BufferedImage leftIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/left3.png")));

            BufferedImage rightIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/right1.png")));
            BufferedImage rightIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/right2.png")));
            BufferedImage rightIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/right3.png")));

            BufferedImage upIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/up1.png")));
            BufferedImage upIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/up2.png")));
            BufferedImage upIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/up3.png")));

            setImages(downIm1, downIm2, downIm3, leftIm1, leftIm2, leftIm3, rightIm1, rightIm2, rightIm3,  upIm1, upIm2, upIm3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method represents the special attack of the hero.
     * @param theEnemy the enemy to attack
     * @Override the specialAttack method in the MazeCharacter class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        Random chance = new Random();
        Random heal = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            int healthGained = heal.nextInt(myMaxSpecialHeal + 1 - myMinSpecialHeal) + myMinSpecialHeal;
            if (getHealthPoints() + healthGained > getOriginalHealthPoints()) {
                healthGained = getOriginalHealthPoints() - getHealthPoints();
                setHealthPoints(getOriginalHealthPoints());
            } else {
                setHealthPoints(getHealthPoints() + healthGained);
            }
            System.out.println(getName() + " healed and gained " + healthGained + " health!");
            System.out.println(getName() + " now has " + getHealthPoints() + " health!");
        } else {
            System.out.println(getName() + " failed to heal!");
        }
    }
}