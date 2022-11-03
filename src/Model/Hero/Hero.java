package Model.Hero;

import Model.MazeCharacter;

public class Hero extends MazeCharacter {
    private int myPotion;
    protected Hero(String theName, int theHealthPoints, int theAttackSpeed, int theMinAttack, int theMaxAttack,
                   double theHitChance, double theDodgeChance, double theSpecialChance, int thePotion) {
        super(theName, theHealthPoints, theAttackSpeed, theMinAttack, theMaxAttack, theHitChance, theDodgeChance,
                theSpecialChance);
        setPotion(thePotion);
    }
    protected final int getPotion() {
        return myPotion;
    }

    protected final void setPotion(int thePotion) {
        myPotion = thePotion;
    }

    protected final void addPotion(int thePotion) {
        myPotion += thePotion;
        setPotion(myPotion);
    }

    public final void usePotion(int thePotion) {
        if (myPotion > 0) {
            if (getHealthPoints() == getOriginalHealthPoints()) {
                System.out.println("You are already at full health!");
            } else {
                myPotion -= thePotion;
                setPotion(myPotion);
                addHealth(10);
                System.out.println(getName() + " used a potion and gained 10 health!");
            }
        } else {
            System.out.println(getName() + " has no potions left!");
        }
    }
}
