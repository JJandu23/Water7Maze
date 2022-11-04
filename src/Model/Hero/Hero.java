package Model.Hero;

import Model.MazeCharacter;

public class Hero extends MazeCharacter {
    private int mySenzuBean;
    private int myOriginalHealthPoints;
    public Hero(String theName, int theHealthPoints, int theOriginalHealthPoints, int theAttackSpeed, int theMinDamage,
                int theMaxDamage, double theHitChance, double theDodgeChance, double theSpecialChance, int theSenzuBean) {
        super(theName, theHealthPoints,  theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        setSenzuBean(theSenzuBean);
        setOriginalHealthPoints(theOriginalHealthPoints);
    }
    protected final int getSenzuBean() {
        return mySenzuBean;
    }
    protected final int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }

    protected final void setSenzuBean(int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }
    protected final void setOriginalHealthPoints(int theOriginalHealthPoints) {
        myOriginalHealthPoints = theOriginalHealthPoints;
    }

    protected final void addSenzuBean(int theSenzuBean) {
        mySenzuBean += theSenzuBean;
        setSenzuBean(mySenzuBean);
    }
    public final void useSenzuBean() {
        if (getSenzuBean() > 0) {
            if (getHealthPoints() == getOriginalHealthPoints()) {
                System.out.println("You are already at full health!");
            } else {
                mySenzuBean--;
                setSenzuBean(mySenzuBean);
                if(getHealthPoints() + 20 > getOriginalHealthPoints()) {
                    setHealthPoints(getOriginalHealthPoints());
                } else {
                    setHealthPoints(getHealthPoints() + 20);
                }
                System.out.println(getName() + " used a senzu bean and gained 10 health!");
                System.out.println(getName() + " now has " + getHealthPoints() + " health!");
            }
        } else {
            System.out.println(getName() + " has no senzu beans left!");
        }
    }
}
