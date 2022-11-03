package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Luffy extends Hero {
    private final int myMinSpecialDamage = 20;
    private final int myMaxSpecialDamage = 30;

    public Luffy() {
        super("Luffy", 100, 10, 10, 20, 0.8,
                0.2, 0.1, 1);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        Random damage = new Random();
        int damageDealt = 0;
        if (chance.nextFloat() <= getSpecialChance()) {
            damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used Gum Gum Pistol and dealt " + damageDealt + " damage!");
        } else {
            System.out.println(getName() + " failed to use Gum Gum Pistol!");
        }
    }
}
