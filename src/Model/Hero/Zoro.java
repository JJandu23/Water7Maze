package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
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
    private final int myMinSpecialDamage = 40;
    /**
     * The maximum special damage.
     */
    private final int myMaxSpecialDamage = 60;
    /**
     * Zoro constructor
     */
    public Zoro() {
        super("Zoro", 110, 8, 15, 25,
                .6, .2, .4, 7);

        try {
            setMyDownIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down1.png")));
            setMyDownIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down2.png")));
            setMyDownIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/down3.png")));

            setMyUpIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up1.png")));
            setMyUpIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up2.png")));
            setMyUpIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/up3.png")));

            setMyLeftIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left1.png")));
            setMyLeftIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left2.png")));
            setMyLeftIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/left3.png")));

            setMyRightIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right1.png")));
            setMyRightIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right2.png")));
            setMyRightIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Zoro/right3.png")));
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
