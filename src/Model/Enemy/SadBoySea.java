package Model.Enemy;

import Model.MazeCharacter;

import java.util.Random;

public class SadBoySea extends Enemy {

    public SadBoySea() {
        super("SadBoySea", 300, 12, 10, 20, 0.8,
                0.2, 0.2);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        System.out.println(getName() + " used Santoryu Ougi: Ichidai Sanzen Daisen Sekai!");
        int damageDealt = theEnemy.getHealthPoints()/4;
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints()+ " health left!");
        theEnemy.subtractHealth(damageDealt);
    }
}
