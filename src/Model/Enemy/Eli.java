package Model.Enemy;

import Model.MazeCharacter;

/**
 * This class represents the Eli enemy in the game.
 *
 * @author Kevin Nguyen, Jashanpreet Jandu, Nicholas Zhuk
 * @version 1.0
 */
public class Eli extends MazeCharacter {

    /**
     * Constructor for the Eli class.
     */
    public Eli(final String theName, final int theHealthPoints, final int theAttackSpeed,
               final int theMinDamage, final int theMaxDamage, final double theHitChance, final double theDodgeChance,
               final double theSpecialChance) {

        /* Call the super constructor of the parent class */
        super(theName, theHealthPoints, theAttackSpeed,
                theMinDamage, theMaxDamage, theHitChance, theDodgeChance,
                theSpecialChance);
    }

    /**
     * This method represents the special attack of the Eli enemy.
     *
     * @param theEnemy the enemy to attack
     * @Override the specialAttack method in the parent class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        System.out.println("Eli used double attack!");
        System.out.println("First attack!");
        attack(theEnemy);
        System.out.println("Second attack!");
        attack(theEnemy);
    }
}