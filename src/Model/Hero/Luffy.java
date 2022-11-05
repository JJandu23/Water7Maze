package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Luffy extends Hero {
    private final int myMinSpecialDamage = 25;
    private final int myMaxSpecialDamage = 35;

    public Luffy() {
        super("Luffy", 120, 100, 10, 10,
                20, 0.8, 0.2, 0.20, 0);
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
