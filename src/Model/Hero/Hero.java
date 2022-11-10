package Model.Hero;

import Controller.InputControls;
import Model.MazeCharacter;

import java.awt.event.KeyListener;

public class Hero extends MazeCharacter {
    private int mySenzuBean;
    private int myOriginalHealthPoints;
    private int myMoveSpeed;
    private final InputControls inputCon = new InputControls();
    private int myX = 100;
    private int myY = 100;


    public Hero(String theName, int theHealthPoints, int theOriginalHealthPoints, int theAttackSpeed, int theMinDamage,
                int theMaxDamage, double theHitChance, double theDodgeChance, double theSpecialChance, int theSenzuBean, int theMoveSpeed) {
        super(theName, theHealthPoints,  theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        setSenzuBean(theSenzuBean);
        setOriginalHealthPoints(theOriginalHealthPoints);
        setMoveSpeed(theMoveSpeed);
    }
    protected final int getSenzuBean() {
        return mySenzuBean;
    }
    protected final int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }
    public final int getMoveSpeed(){return myMoveSpeed;}

    protected final void setSenzuBean(int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }
    protected final void setOriginalHealthPoints(int theOriginalHealthPoints) {
        myOriginalHealthPoints = theOriginalHealthPoints;
    }
    protected final void setMoveSpeed(int theMoveSpeed){ myMoveSpeed = theMoveSpeed;}

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

    //controls
    public void update() {

        if (inputCon.getUp()) {
            myY -= myMoveSpeed;
            System.out.println("My movespeed: " + myMoveSpeed);
        } else if (inputCon.getDown()) {
            myY += myMoveSpeed;
        }

        if (inputCon.getLeft()) {
            myX -= myMoveSpeed;
        } else if (inputCon.getRight()) {
            myX += myMoveSpeed;
        }

    }

    public int getX(){return myX;}
    public int getY(){return myY;}
}
