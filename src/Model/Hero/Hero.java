package Model.Hero;

import Controller.InputControls;
import Model.MazeCharacter;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Hero extends MazeCharacter {
    private int mySenzuBean;
    private int myTorch;
    private int myOriginalHealthPoints;
    private int myMoveSpeed;
    private final InputControls inputCon = new InputControls();
    private int myX = 100;
    private int myY = 100;

    private BufferedImage myUpIm1, myUpIm2, myDownIm1, myDownIm2, myLeftIm1, myLeftIm2, myRightIm1, myRightIm2;
    private String myDirection = "down";


    public Hero(String theName, int theHealthPoints, int theAttackSpeed, int theMinDamage,
                 int theMaxDamage, double theHitChance, double theDodgeChance, double theSpecialChance, int theMoveSpeed) {
        super(theName, theHealthPoints,  theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        this.myOriginalHealthPoints = theHealthPoints;
        mySenzuBean = 0;
        myTorch = 0;
    }
    protected  int getSenzuBean() {
        return mySenzuBean;
    }
    protected int getMyTorch(){
        return myTorch;
    }
    protected int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }
    public int getMoveSpeed(){return myMoveSpeed;}

    protected void setSenzuBean(int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }
    protected void setMyTorch(int theTorch){
        myTorch = theTorch;
    }
    protected void setMoveSpeed(int theMoveSpeed){ myMoveSpeed = theMoveSpeed;}

    protected void addSenzuBean(int theSenzuBean) {
        mySenzuBean += theSenzuBean;
        setSenzuBean(mySenzuBean);
    }
    public void useSenzuBean() {
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
            myDirection = "up";
            myY -= myMoveSpeed;

        } else if (inputCon.getDown()) {
            myDirection = "down";
            myY += myMoveSpeed;
        }

        if (inputCon.getLeft()) {
            myDirection = "left";
            myX -= myMoveSpeed;
        } else if (inputCon.getRight()) {
            myDirection = "right";
            myX += myMoveSpeed;
        }

    }

    public void draw(Graphics2D g){
        BufferedImage image = switch (myDirection) {
            case "up" -> myUpIm1;
            case "down" -> myDownIm1;
            case "left" -> myLeftIm1;
            case "right" -> myRightIm1;
            default -> null;
        };

        /*try  {
           image = ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/unknown.png"));
        } catch (IOException e){
            e.printStackTrace();
        }*/
        g.drawImage(image , myX, myY, 128, 128, null);

    }


    public int getX(){return myX;}
    public int getY(){return myY;}

    public void setMyDownIm1(BufferedImage myDownIm1) {
        this.myDownIm1 = myDownIm1;
    }
    public void setMyDownIm2(BufferedImage myDownIm2) {
        this.myDownIm2 = myDownIm2;
    }

    public void setMyLeftIm1(BufferedImage myLeftIm1) {
        this.myLeftIm1 = myLeftIm1;
    }

    public void setMyLeftIm2(BufferedImage myLeftIm2) {
        this.myLeftIm2 = myLeftIm2;
    }

    public void setMyRightIm1(BufferedImage myRightIm1) {
        this.myRightIm1 = myRightIm1;
    }

    public void setMyRightIm2(BufferedImage myRightIm2) {
        this.myRightIm2 = myRightIm2;
    }

    public void setMyUpIm1(BufferedImage myUpIm1) {
        this.myUpIm1 = myUpIm1;
    }

    public void setMyUpIm2(BufferedImage myUpIm2) {
        this.myUpIm2 = myUpIm2;
    }
}

