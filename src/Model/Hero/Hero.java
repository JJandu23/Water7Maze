package Model.Hero;

import Model.MazeCharacter;

public class Hero extends MazeCharacter {
    private int mySenzuBean;
    public Hero(String theName, int theHealthPoints, int theOriginalHealthPoints, int theAttackSpeed, int theMinDamage,
                int theMaxDamage, double theHitChance, double theDodgeChance, double theSpecialChance, int theSenzuBean) {
        super(theName, theHealthPoints, theOriginalHealthPoints, theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        setSenzuBean(theSenzuBean);
    }
    public final int getSenzuBean() {
        return mySenzuBean;
    }

    protected final void setSenzuBean(int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }

    protected final void addSenzuBean(int theSenzuBean) {
        mySenzuBean += theSenzuBean;
        setSenzuBean(mySenzuBean);
    }

    public final void useSenzuBean(int mySenzuBean) {
        if (mySenzuBean > 0) {
            if (getHealthPoints() == getOriginalHealthPoints()) {
                System.out.println("You are already at full health!");
            } else {
                mySenzuBean -= mySenzuBean;
                setSenzuBean(mySenzuBean);
                int newHealth = getHealthPoints() + 10;
                setHealthPoints(newHealth);
                System.out.println(getName() + " used a senzu bean and gained 10 health!");
                System.out.println(getName() + " now has " + getHealthPoints() + " health!");
            }
        } else {
            System.out.println(getName() + " has no senzu beans left!");
        }
    }
}
