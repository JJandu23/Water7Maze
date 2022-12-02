package Model;

import java.util.Random;

/**
 * This class is the parent class for all water7 characters.
 *
 * @author Kevin Nguyen, Jashanpreet Jandu, Nicholas Zhuk
 * @version 1.0
 */
public abstract class MazeCharacter {

    /**
     * The name of the character.
     */
    private String myName;

    /**
     * The health points of the character.
     */
    private int myHealthPoints;

    /**
     * The attack speed of the character.
     */
    private int myAttackSpeed;

    /**
     * The minimum damage of the character.
     */
    private int myMinDamage;

    /**
     * The maximum damage of the character.
     */
    private int myMaxDamage;

    /**
     * The hit chance of the character.
     */
    private double myHitChance;

    /**
     * The dodge chance of the character.
     */
    private double myDodgeChance;

    /**
     * The special chance of the character.
     */
    private double mySpecialChance;

    /**
     * Constructor for MazeCharacter.
     *
     * @param theName          the name of the character
     * @param theHealthPoints  the health points of the character
     * @param theAttackSpeed   the attack speed of the character
     * @param theMinDamage     the minimum damage of the character
     * @param theMaxDamage     the maximum damage of the character
     * @param theHitChance     the hit chance of the character
     * @param theDodgeChance   the dodge chance of the character
     * @param theSpecialChance the special chance of the character
     */
    protected MazeCharacter(final String theName, final int theHealthPoints, final int theAttackSpeed,
                            final int theMinDamage, final int theMaxDamage, final double theHitChance, final double theDodgeChance,
                            final double theSpecialChance) {
        setName(theName);
        setHealthPoints(theHealthPoints);
        setAttackSpeed(theAttackSpeed);
        setMinDamage(theMinDamage);
        setMaxDamage(theMaxDamage);
        setHitChance(theHitChance);
        setDodgeChance(theDodgeChance);
        setSpecialChance(theSpecialChance);
    }

    /**
     * This method sets the name of the character.
     *
     * @param theName the name of the character
     */
    protected void setName(final String theName) {
        myName = theName;
    }

    /**
     * This method sets the health points of the character.
     *
     * @param theHealthPoints the health points of the character
     */
    protected void setHealthPoints(final int theHealthPoints) {
        myHealthPoints = theHealthPoints;
    }

    /**
     * This method sets the attack speed of the character.
     *
     * @param theAttackSpeed the attack speed of the character
     */
    protected void setAttackSpeed(final int theAttackSpeed) {
        myAttackSpeed = theAttackSpeed;
    }

    /**
     * This method sets the minimum damage of the character.
     *
     * @param theMinDamage the minimum damage of the character
     */
    protected void setMinDamage(final int theMinDamage) {
        myMinDamage = theMinDamage;
    }

    /**
     * This method sets the maximum damage of the character.
     *
     * @param theMaxDamage the maximum damage of the character
     */
    protected void setMaxDamage(final int theMaxDamage) {
        myMaxDamage = theMaxDamage;
    }

    /**
     * This method sets the hit chance of the character.
     *
     * @param theHitChance the hit chance of the character
     */
    protected void setHitChance(final double theHitChance) {
        myHitChance = theHitChance;
    }

    /**
     * This method sets the dodge chance of the character.
     *
     * @param theDodgeChance the dodge chance of the character
     */
    protected void setDodgeChance(final double theDodgeChance) {
        myDodgeChance = theDodgeChance;
    }

    /**
     * This method sets the special chance of the character.
     *
     * @param theSpecialChance the special chance of the character
     */
    protected void setSpecialChance(final double theSpecialChance) {
        mySpecialChance = theSpecialChance;
    }

    /**
     * This method returns the name of the character.
     */
    public String getName() {
        return myName;
    }

    /**
     * This method returns the health points of the character.
     */
    public int getHealthPoints() {
        return myHealthPoints;
    }

    /**
     * This method returns the attack speed of the character.
     */
    public int getAttackSpeed() {
        return myAttackSpeed;
    }

    /**
     * This method returns the minimum damage of the character.
     */
    public int getMinDamage() {
        return myMinDamage;
    }

    /**
     * This method returns the maximum damage of the character.
     */
    public int getMaxDamage() {
        return myMaxDamage;
    }

    /**
     * This method returns the hit chance of the character.
     */
    public double getDodgeChance() {
        return myDodgeChance;
    }

    /**
     * This method returns the special chance of the character.
     */
    protected double getSpecialChance() {
        return mySpecialChance;
    }

    /**
     * This method subtracts the health points of the character.
     *
     * @param theDamage the damage to be subtracted
     * @return the health points of the character
     */
    public int subtractHealth(final int theDamage) {
        myHealthPoints -= theDamage;
        if (myHealthPoints < 0) {
            myHealthPoints = 0;
        }
        return myHealthPoints;
    }

    /**
     * This method is used to determine if the opponent blocked the attack.
     *
     * @return whether the attack was successful or not
     */
    public boolean blockAttack() {
        Random rand = new Random();
        double chance = rand.nextDouble();
        return chance < myDodgeChance;
    }

    /**
     * This method is used to attack the enemy.
     *
     * @param theEnemy the enemy that is being attacked
     */
    public void attack(final MazeCharacter theEnemy) {
        if (blockAttack()) {
            System.out.println(theEnemy.getName() + " has blocked the attack!");
        } else {
            Random rand = new Random();
            double chance = rand.nextDouble();
            if (chance < myHitChance) {
                int damage = rand.nextInt(myMaxDamage - myMinDamage + 1) + myMinDamage;
                theEnemy.subtractHealth(damage);
                System.out.println(myName + " hit " + theEnemy.getName() + " for " + damage + " damage!");
                System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
            } else {
                System.out.println(myName + " missed!");
            }
        }
    }

    /**
     * This method is used to perform a special attack.
     *
     * @param theEnemy the enemy that is being attacked
     */
    public void specialAttack(final MazeCharacter theEnemy) {
        Random rand = new Random();
        double chance = rand.nextDouble();
        if (chance <= mySpecialChance) {
            int damageDealt = rand.nextInt(myMaxDamage - myMinDamage + 1) + myMinDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(myName + " attacks " + theEnemy.getName() + " for " + damageDealt + " damage.");
        }
    }
}