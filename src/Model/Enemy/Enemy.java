package Model.Enemy;

import Model.MazeCharacter;

public class Enemy extends MazeCharacter{
    protected Enemy(String theName, int theHealthPoints, int theAttackSpeed, int theMinAttack, int theMaxAttack,
                   double theHitChance, double theDodgeChance, double theSpecialChance) {
        super(theName, theHealthPoints, theAttackSpeed, theMinAttack, theMaxAttack, theHitChance, theDodgeChance,
                theSpecialChance);
    }

}
