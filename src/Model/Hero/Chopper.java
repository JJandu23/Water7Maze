package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
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
            setMyDownIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/down1.png")));
            setMyUpIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/up1.png")));
            setMyLeftIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/left1.png")));
            setMyRightIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Chopper/right1.png")));
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
