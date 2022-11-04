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
        System.out.println(getName() + " used his special attack!");
        int damageDealt = theEnemy.getHealthPoints()/2;
        theEnemy.subtractHealth(damageDealt);
    }
}
