package Model.Enemy;

import Model.MazeCharacter;

public class BoatKevin extends Enemy {
    public BoatKevin() {
        super("Boat Kevin", 100,  11, 20, 30, 0.40,
                0.20, 0.20);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        theEnemy.subtractHealth(99999999);
        System.out.println(getName() + " went sicko mode and dealt 99999999 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
    }
}
