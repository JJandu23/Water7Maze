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

    protected MazeCharacter(String theName, int theHealthPoints,  int theAttackSpeed,
                            int theMinDamage, int theMaxDamage, double theHitChance, double theDodgeChance,
                            double theSpecialChance) {
        setName(theName);
        setHealthPoints(theHealthPoints);
        setAttackSpeed(theAttackSpeed);
        setMinDamage(theMinDamage);
        setMaxDamage(theMaxDamage);
        setHitChance(theHitChance);
        setDodgeChance(theDodgeChance);
        setSpecialChance(theSpecialChance);
    }

    protected void setName(String theName) {
        myName = theName;
    }

    protected void setHealthPoints(int theHealthPoints) {
        myHealthPoints = theHealthPoints;
    }

    protected void setAttackSpeed(int theAttackSpeed) {
        myAttackSpeed = theAttackSpeed;
    }

    protected void setMinDamage(int theMinDamage) {
        myMinDamage = theMinDamage;
    }

    protected void setMaxDamage(int theMaxDamage) {
        myMaxDamage = theMaxDamage;
    }

    protected void setHitChance(double theHitChance) {
        myHitChance = theHitChance;
    }

    protected void setDodgeChance(double theDodgeChance) {
        myDodgeChance = theDodgeChance;
    }

    protected void setSpecialChance(double theSpecialChance) {
        mySpecialChance = theSpecialChance;
    }

    public String getName() {
        return myName;
    }

    public int getHealthPoints() {
        return myHealthPoints;
    }

    public int getAttackSpeed() {
        return myAttackSpeed;
    }

    public int getMinDamage() {
        return myMinDamage;
    }

    public int getMaxDamage() {
        return myMaxDamage;
    }

    public double getDodgeChance() {
        return myDodgeChance;
    }

    protected double getSpecialChance() {
        return mySpecialChance;
    }

    public int subtractHealth(int theDamage) {
        myHealthPoints -= theDamage;
        if (myHealthPoints < 0) {
            myHealthPoints = 0;
        }
        return myHealthPoints;
    }

    public boolean blockAttack() {
        Random rand = new Random();
        double chance = rand.nextDouble();
        return chance < myDodgeChance;
    }

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
