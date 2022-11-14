package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Nami extends Hero{
    public Nami() {
        super("Nami", 90, 10, 10,
                20, 0.5, 0.4, 0.20, 3);
    }

    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            System.out.println(getName() + " used mirage tempo!");
            if (getDodgeChance() < 0.9) {
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
