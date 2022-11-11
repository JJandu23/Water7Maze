package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Luffy extends Hero {
    private final int myMinSpecialDamage = 25;
    private final int myMaxSpecialDamage = 35;

    public Luffy() {
        super("Luffy", 120, 100, 10, 10,
                20, 0.8, 0.2, 0.20, 0, 4);


        try{
            setMyDownIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/kevinDown.png")));
            setMyUpIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/kevinUp.png")));
            setMyLeftIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/kevinLeft.png")));
            setMyRightIm1(ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/kevinRight.png")));
        }catch (IOException e){
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
