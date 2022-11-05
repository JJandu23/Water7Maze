package Model.Enemy;

import Model.MazeCharacter;

public class Nikolai extends Enemy {
    public Nikolai() {
        super("Nikolai", 100,  11, 20, 30, 0.40,
                0.20, 0.20);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        theEnemy.subtractHealth(60);
        System.out.println(getName() + " used his Berserker Armor and dealt 60 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints());
    }
}
