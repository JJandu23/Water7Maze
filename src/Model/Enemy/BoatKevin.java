package Model.Enemy;

import Model.MazeCharacter;

public class BoatKevin extends Enemy {
    public BoatKevin() {
        super("BoatKevin", 40,  4, 10, 20, 0.8,
                0.2, 0.05);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        theEnemy.subtractHealth(99999999);
        System.out.println(getName() + " went sicko mode and dealt 99999999 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
    }
}
