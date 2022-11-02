package Model;

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
                            int theMinAttack, int theMaxAttack, double theHitChance, double theDodgeChance,
                            double theSpecialChance) {
        myName = theName;
        myHealthPoints = theHealthPoints;
        myAttackSpeed = theAttackSpeed;
        myMinDamage = theMinAttack;
        myMaxDamage = theMaxAttack;
        myHitChance = theHitChance;
        myDodgeChance = theDodgeChance;
        mySpecialChance = theSpecialChance;
    }
    protected final void setName(String theName){
        myName = theName;
    }
    protected final void setHealth(int theHealthPoints){
        myHealthPoints = theHealthPoints;
    }
    protected final void setAttackSpeed(int theAttackSpeed){
        myAttackSpeed = theAttackSpeed;
    }
    protected final void setMinDamage(int theMinDamage){
        myMinDamage = theMinDamage;
    }
    protected final void setMaxDamage(int theMaxDamage){
        myMaxDamage = theMaxDamage;
    }
    protected final void setHitChance(double theHitChance){
        myHitChance = theHitChance;
    }
    protected final void setDodgeChance(double theDodgeChance){
        myDodgeChance = theDodgeChance;
    }
    protected final void setSpecialChance(double theSpecialChance){
        mySpecialChance = theSpecialChance;
    }
    protected final String getName() {
        return myName;
    }
    protected final int getHealth() {
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
        myHealthPoints += theHeal;
        return myHealthPoints;
    }
    public final int attack(final MazeCharacter theEnemy) {
        int damage = 0;
        if (Math.random() <= myHitChance) {
            damage = (int) (Math.random() * (myMaxDamage - myMinDamage + 1)) + myMinDamage;
            theEnemy.subtractHealth(damage);
        }
        return damage;
    }
    public final int specialAttack(final MazeCharacter theEnemy) {
        int damage = 0;
        if (Math.random() <= mySpecialChance) {
            damage = (int) (Math.random() * (myMaxDamage - myMinDamage + 1)) + myMinDamage;
            theEnemy.subtractHealth(damage);
        }
        return damage;
    }

}
