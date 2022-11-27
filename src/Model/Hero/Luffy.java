package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Kevin Nguyen, Nicholas Zhuk and Jashanpreet Jandu
 * @version 1.0
 */
public class Luffy extends Hero {
    private final int myMinSpecialDamage = 35;
    private final int myMaxSpecialDamage = 45;

    public Luffy() {
        super("Luffy", 120, 10, 15,
                25, 0.8, 0.2, 0.20, 5);

        try {
            setMyDownIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down1.png")));
            setMyDownIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down2.png")));
            setMyDownIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/down3.png")));

            setMyUpIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up1.png")));
            setMyUpIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up2.png")));
            setMyUpIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/up3.png")));

            setMyLeftIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left1.png")));
            setMyLeftIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left2.png")));
            setMyLeftIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/left3.png")));

            setMyRightIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right1.png")));
            setMyRightIm2(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right2.png")));
            setMyRightIm3(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Luffy/right3.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        Random damage = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            int damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used Gum Gum Pistol and dealt " + damageDealt + " damage!");
            System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + "health left!");
        } else {
            System.out.println(getName() + " failed to use Gum Gum Pistol!");
        }
    }
}
