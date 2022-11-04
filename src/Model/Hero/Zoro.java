package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Zoro extends Hero{
    private final int myMinSpecialDamage = 30;
    private final int myMaxSpecialDamage = 40;
    public Zoro(){
        super("Zoro", 90, 90, 8, 15, 25,
                .4, .3, .3, 0);
    }
    @Override
    public void specialAttack(MazeCharacter theEnemy){
        Random chance = new Random();
        Random damage = new Random();
        int damageDealt = 0;
        if (chance.nextFloat() <= getSpecialChance()) {
            damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used purgatory onigiri and dealt " + damageDealt + " damage!");
        } else {
            System.out.println(getName() + " failed to use Gum Gum Pistol!");
        }
    }
}
