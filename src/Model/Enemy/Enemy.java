package Model.Enemy;

import Model.MazeCharacter;

/**
 * This class represents an enemy in the game.
 *
 * @author Kevin Nguyen, Jashanpreet Jandu, Nicholas Zhuk
 * @version 1.0
 */
public abstract class Enemy extends MazeCharacter {

    /**
     * Contructor for the Enemy class.
     */
    public Enemy(final String theName, final int theHealthPoints, final int theAttackSpeed,
                 final int theMinDamage, final int theMaxDamage, final double theHitChance, final double theDodgeChance,
                 final double theSpecialChance) {

        /* Call the super constructor of the parent class */
        super(theName, theHealthPoints, theAttackSpeed,
                theMinDamage, theMaxDamage, theHitChance, theDodgeChance,
                theSpecialChance);
    }
}
