package Model.Enemy;

import Model.MazeCharacter;

import java.util.Random;

public class BoatKevin extends Enemy {
    public BoatKevin() {
        super("BoatKevin", 40,  4, 10, 20, 0.8,
                0.2, 0.05);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        theEnemy.subtractHealth(99999999);
        System.out.println(getName() + " used final explosion!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints());
    }
}
