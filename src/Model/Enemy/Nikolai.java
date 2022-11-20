package Model.Enemy;

import Model.MazeCharacter;

/**
 * This class represents the Nikolai enemy in the game.
 * @author Kevin Nguyen
 * @version 1.0
 */
public class Nikolai extends Enemy {
    /**
     * Constructor for the Nikolai class.
     */
    public Nikolai(final String theName, final int theHealthPoints, final int theAttackSpeed,
                   final int theMinDamage, final int theMaxDamage, final double theHitChance, final double theDodgeChance,
                   final double theSpecialChance) {
        /**
         * Calls the constructor of the parent class.
         */
        super(theName, theHealthPoints, theAttackSpeed,
                theMinDamage, theMaxDamage, theHitChance, theDodgeChance,
                theSpecialChance);
    }
    /**
     * This method represents the special attack of the Nikolai enemy.
     * @param theEnemy the enemy to attack
     * @Override the specialAttack method in the parent class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        theEnemy.subtractHealth(60);
        System.out.println(getName() + " used his Berserker Armor and dealt 60 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints());
    }
}
