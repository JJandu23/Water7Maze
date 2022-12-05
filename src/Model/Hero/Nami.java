package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Nami extends Hero {
    public Nami() {
        super("Nami", 90, 10, 10,
                20, 0.5, 0.4, 0.20, 3);
        try {
            setMyDownIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/down1.png")));
            setMyUpIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/up1.png")));
            setMyLeftIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/left1.png")));
            setMyRightIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/right1.png")));
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
        if (chance.nextFloat() <= getSpecialChance()) {
            System.out.println(getName() + " used mirage tempo!");
            if (getDodgeChance() < 1.0) {
                setDodgeChance(getDodgeChance() + 0.1);
                System.out.println(getName() + "'s dodge is now " + getDodgeChance() + "!");
            } else {
                System.out.println(getName() + "'s dodge is already at max!");
            }
        } else {
            System.out.println(getName() + " failed to use mirage tempo!");
        }
    }
}
