package Model.Enemy;

import Model.MazeCharacter;
/**
 * This class represents the Boat Kevin enemy in the game.
 * @author Kevin Nguyen
 * @version 1.0
 */
public class BoatKevin extends Enemy {
    /**
     * Constructor for the BoatKevin class.
     */
    public BoatKevin(final String theName, final int theHealthPoints,  final int theAttackSpeed,
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
     * This method represents the special attack of the Boat Kevin enemy.
     * @param theEnemy the enemy to attack
     * @Override the specialAttack method in the parent class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        theEnemy.subtractHealth(99999999);
        System.out.println(getName() + " went sicko mode and dealt 99999999 damage!");
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
    }
}
