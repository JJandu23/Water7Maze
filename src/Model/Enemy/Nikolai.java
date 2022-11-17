package Model.Enemy;

import Model.MazeCharacter;

public class Nikolai extends Enemy {
    public Nikolai() {
        super("Nikolai");
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        theEnemy.subtractHealth(60);
        System.out.println(getName() + " used his Berserker Armor and dealt 60 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints());
    }
}
