package Model;

import java.util.Random;

public class MazeCharacter {
    private String myName;
    private int myHealthPoints;
    private int myAttackSpeed;
    private int myMinDamage;
    private int myMaxDamage;
    private double myHitChance;

    private double myDodgeChance;
    private double mySpecialChance;

    protected MazeCharacter(String theName, int theHealthPoints, int theAttackSpeed,
                            int theMinDamage, int theMaxDamage, double theHitChance, double theDodgeChance,
                            double theSpecialChance) {
        setName(theName);
        setHealthPoints(theHealthPoints);
        setOriginalHealthPoints(theHealthPoints);
        setAttackSpeed(theAttackSpeed);
        setMinDamage(theMinDamage);
        setMaxDamage(theMaxDamage);
        setHitChance(theHitChance);
        setDodgeChance(theDodgeChance);
        setSpecialChance(theSpecialChance);
    }

    protected final void setName(String theName) {
        myName = theName;
    }

    protected final void setHealthPoints(int theHealthPoints) {
        myHealthPoints = theHealthPoints;
    }

    protected final void setOriginalHealthPoints(int theHealthPoints) {
        myHealthPoints = theHealthPoints;
    }

    protected final void setAttackSpeed(int theAttackSpeed) {
        myAttackSpeed = theAttackSpeed;
    }

    protected final void setMinDamage(int theMinDamage) {
        myMinDamage = theMinDamage;
    }

    protected final void setMaxDamage(int theMaxDamage) {
        myMaxDamage = theMaxDamage;
    }

    protected final void setHitChance(double theHitChance) {
        myHitChance = theHitChance;
    }
    protected final void setDodgeChance(double theDodgeChance){
        myDodgeChance = theDodgeChance;
    }

    protected final void setSpecialChance(double theSpecialChance) {
        mySpecialChance = theSpecialChance;
    }

    protected final String getName() {
        return myName;
    }

    protected final int getHealthPoints() {
        return myHealthPoints;
    }

    protected final int getOriginalHealthPoints() {
        return myHealthPoints;
    }

    protected final int getAttackSpeed() {
        return myAttackSpeed;
    }

    protected final int getMinDamage() {
        return myMinDamage;
    }

    protected final int getMaxDamage() {
        return myMaxDamage;
    }

    protected final double getHitChance() {
        return myHitChance;
    }
    protected final double getDodgeChance() {
        return myDodgeChance;
    }
    protected final double getSpecialChance() {
        return mySpecialChance;
    }
    public final int subtractHealth(int theDamage) {
        myHealthPoints -= theDamage;
        return myHealthPoints;
    }

    public final int addHealth(int theHeal) {
        if (myHealthPoints + theHeal > getOriginalHealthPoints()) {
            myHealthPoints = getOriginalHealthPoints();
        } else {
            myHealthPoints += theHeal;
        }
        return myHealthPoints;
    }

    public boolean blockAttack() {
        Random rand = new Random();
        double chance = rand.nextDouble();
        return chance < myDodgeChance;
    }

    public final void attack(final MazeCharacter theEnemy) {
        if (blockAttack()) {
            System.out.println("Attack Blocked!");
        } else {
            Random rand = new Random();
            double chance = rand.nextDouble();
            if (chance < myHitChance) {
                int damage = rand.nextInt(myMaxDamage - myMinDamage + 1) + myMinDamage;
                theEnemy.subtractHealth(damage);
                System.out.println(myName + " hit " + theEnemy.getName() + " for " + damage + " damage!");
            } else {
                System.out.println(myName + " missed!");
            }
        }
    }

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
