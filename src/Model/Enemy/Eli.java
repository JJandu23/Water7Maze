package Model.Enemy;

import Model.MazeCharacter;

import java.util.Random;

public class Eli extends Enemy{
    public Eli() {
        super("Eli", 100,  11, 20, 30, 0.40,
                0.20, 0.20);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        System.out.println(getName() + " hit the nae nae!");
        System.out.println(theEnemy.getName() + " has been stunned!");
        Random chance = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            specialAttack(theEnemy);
        } else {
            attack(theEnemy);
        }
    }
}
