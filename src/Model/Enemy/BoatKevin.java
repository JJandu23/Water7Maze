package Model.Enemy;

import Model.MazeCharacter;

import java.util.Random;

public class BoatKevin extends Enemy {
    public BoatKevin() {
        super("Boat Kevin", 40, 4, 10, 20, 0.8,
                0.2, 0.01);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            System.out.println(getName() + " used his special attack!");
            theEnemy.subtractHealth(99999999);
        } else {
            System.out.println(getName() + " failed to use his special attack!");
        }
    }
}
