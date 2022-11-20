package Model.Enemy;

import Model.MazeCharacter;

/**
 * This class represents the SadBoySea enemy in the game.
 * @author Kevin Nguyen
 * @version 1.0
 */
public class SadBoySea extends Enemy {
    /**
     * Constructor for the SadBoySea class.
     */
    public SadBoySea(final String theName, final int theHealthPoints,  final int theAttackSpeed,
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
     * This method represents the special attack of the SadBoySea enemy.
     * @param theEnemy the enemy to attack
     * @Override the specialAttack method in the parent class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        System.out.println(getName() + " used Santoryu Ougi: Ichidai Sanzen Daisen Sekai!");
        int damageDealt = theEnemy.getHealthPoints() / 4;
        theEnemy.subtractHealth(damageDealt);
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
        theEnemy.subtractHealth(damageDealt);
    }
}
