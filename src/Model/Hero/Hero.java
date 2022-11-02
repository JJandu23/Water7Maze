package Model.Hero;

import Model.MazeCharacter;

public class Hero extends MazeCharacter {
    private int myPotion = 0;
    protected Hero(String theName, int theHealthPoints, int theAttackSpeed, int theMinAttack, int theMaxAttack,
                   double theHitChance, double theDodgeChance, double theSpecialChance, int thePotion) {
        super(theName, theHealthPoints, theAttackSpeed, theMinAttack, theMaxAttack, theHitChance, theDodgeChance,
                theSpecialChance);
    }
    protected final int getPotion() {
        return myPotion;
    }
    protected final void setPotion(int thePotion){
        myPotion = thePotion;
    }
    protected final void addPotion(int thePotion){
        myPotion += thePotion;
    }
}
