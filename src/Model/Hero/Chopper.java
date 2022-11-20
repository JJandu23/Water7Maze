package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;
/**
 * Created by 204g07 on 07.06.2016.
 */
public class Chopper extends Hero {
    private final int myMinSpecialHeal = 20;
    private final int myMaxSpecialHeal = 30;

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

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        Random heal = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            int healthGained = heal.nextInt(myMaxSpecialHeal + 1 - myMinSpecialHeal) + myMinSpecialHeal;
            if(getHealthPoints() + healthGained > getOriginalHealthPoints()) {
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
