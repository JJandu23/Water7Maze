package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Chopper extends Hero {
    private final int myMinSpecialHeal = 20;
    private final int myMaxSpecialHeal = 30;

    public Chopper() {
        super("Chopper", 100, 10, 10,
                20, 0.5, 0.3, 0.20, 3);
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
