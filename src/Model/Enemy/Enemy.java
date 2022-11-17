package Model.Enemy;

import Model.MazeCharacter;

public class Enemy extends MazeCharacter{
    public Enemy(String theName, int theHealthPoints, int theAttackSpeed, int theMinDamage, int theMaxDamage,
                 double theHitChance, double theDodgeChance, double theSpecialChance) {
        super(theName, theHealthPoints, theAttackSpeed, theMinDamage, theMaxDamage, theHitChance,
                theDodgeChance, theSpecialChance);
    }
}
