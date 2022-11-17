package Model.Hero;

import Controller.InputControls;
import Model.MazeCharacter;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Hero extends MazeCharacter {
    private int mySenzuBean;
    private int myPowerPowerFruit;
    private int mySpeedSpeedFruit;
    private int myTorch;
    private int myOriginalHealthPoints;
    private int myMoveSpeed;
    private final InputControls inputCon = new InputControls();
    private int myX = 100;
    private int myY = 100;

    private BufferedImage myUpIm1, myUpIm2, myUpIm3, myDownIm1, myDownIm2, myDownIm3, myLeftIm1, myLeftIm2,myLeftIm3,  myRightIm1, myRightIm2, myRightIm3;
    private String myDirection = "down";
    private int spriteNum = 1;
    private int spriteCounter = 0;


    public Hero(String theName, int theHealthPoints, int theAttackSpeed, int theMinDamage,
                int theMaxDamage, double theHitChance, double theDodgeChance, double theSpecialChance, int theMoveSpeed) {
        super(theName, theHealthPoints, theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);

        setSenzuBean(2);
        setPowerPowerFruit(2);
        setSpeedSpeedFruit(2);
        setTorch(0);
        setOriginalHealthPoints(theHealthPoints);
        setMoveSpeed(theMoveSpeed);
    }

    protected int getSenzuBean() {
        return mySenzuBean;
    }

    protected int getPowerPowerFruit() {
        return myPowerPowerFruit;
    }

    protected int getSpeedSpeedFruit() {
        return mySpeedSpeedFruit;
    }

    protected int getTorch() {
        return myTorch;
    }

    protected int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }

    public int getMoveSpeed() {
        return myMoveSpeed;
    }

    protected void setSenzuBean(int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }

    protected void setPowerPowerFruit(int thePowerPowerFruit) {
        myPowerPowerFruit = thePowerPowerFruit;
    }

    protected void setSpeedSpeedFruit(int theSpeedSpeedFruit) {
        mySpeedSpeedFruit = theSpeedSpeedFruit;
    }

    protected void setTorch(int theTorch) {
        myTorch = theTorch;
    }
    protected void setOriginalHealthPoints(int theHealthPoints){
        myOriginalHealthPoints = theHealthPoints;
    }

    protected void setMoveSpeed(int theMoveSpeed) {
        myMoveSpeed = theMoveSpeed;
    }

    protected void addSenzuBean() {
        mySenzuBean++;
        setSenzuBean(mySenzuBean);
    }

    protected void addPowerPowerFruit() {
        myPowerPowerFruit++;
        setPowerPowerFruit(myPowerPowerFruit);
    }

    protected void addSpeedSpeedFruit() {
        mySpeedSpeedFruit++;
        setSpeedSpeedFruit(mySpeedSpeedFruit);
    }

    public void useSenzuBean() {
        if (getSenzuBean() > 0) {
            if (getHealthPoints() == getOriginalHealthPoints()) {
                System.out.println("You are already at full health!");
            } else {
                mySenzuBean--;
                setSenzuBean(mySenzuBean);
                if (getHealthPoints() + 20 > getOriginalHealthPoints()) {
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

    public void usePowerPowerFruit() {
        if (getPowerPowerFruit() > 0) {
            myPowerPowerFruit--;
            setPowerPowerFruit(myPowerPowerFruit);
            setMinDamage(getMinDamage() + 10);
            setMaxDamage(getMaxDamage() + 10);
            System.out.println(getName() + " used a power power fruit and gained 10 attack!");
            System.out.println(getName() + " now has " + getMinDamage() + " min damage and " + getMaxDamage() +
                    " max damage attack!");
        } else {
            System.out.println(getName() + " has no power power fruits left!");
        }
    }

    public void useSpeedSpeedFruit() {
        if (getSpeedSpeedFruit() > 0) {
            mySpeedSpeedFruit--;
            setSpeedSpeedFruit(mySpeedSpeedFruit);
            setAttackSpeed(getAttackSpeed() + 1);
            System.out.println(getName() + " used a speed speed fruit and gained 1 speed!");
            System.out.println(getName() + " now has " + getAttackSpeed() + " speed!");
        } else {
            System.out.println(getName() + " has no speed speed fruits left!");
        }
    }

    public void useTorch() {
    }

    //controls
    public void update() {
        if(inputCon.getDown() || inputCon.getLeft() || inputCon.getUp() || inputCon.getRight()){
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

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if(spriteNum == 2){
                    spriteNum = 3;
                } else if(spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else{
            spriteNum = 2;
        }


    }

    public void draw(Graphics2D g){
        BufferedImage image = null;
        switch (myDirection) {
            case "up":
                System.out.println(spriteNum);
                if(spriteNum == 1){
                    image = myUpIm1;

                } else if(spriteNum == 2){
                    image = myUpIm2;
                } else if(spriteNum == 3){
                    image = myUpIm3;
                }
                break;

            case "down":
                if(spriteNum == 1){
                    image = myDownIm1;
                } else if(spriteNum == 2){
                    image = myDownIm2;
                } else if(spriteNum == 3){
                    image = myDownIm3;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = myLeftIm1;
                } else if(spriteNum == 2){
                    image = myLeftIm2;
                } else if(spriteNum == 3){
                    image = myLeftIm3;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = myRightIm1;
                } else if(spriteNum == 2){
                    image = myRightIm2;
                } else if(spriteNum == 3){
                    image = myRightIm3;
                }
                break;
            default:
                image = null;
        };

        /*try  {
           image = ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/unknown.png"));
        } catch (IOException e){
            e.printStackTrace();
        }*/
        g.drawImage(image , myX, myY, 32, 32, null);

    }


    public int getX(){return myX;}
    public int getY(){return myY;}

    public void setMyDownIm1(BufferedImage myDownIm1) {
        this.myDownIm1 = myDownIm1;
    }
    public void setMyDownIm2(BufferedImage myDownIm2) {
        this.myDownIm2 = myDownIm2;
    }
    public void setMyDownIm3(BufferedImage myDownIm3) {
        this.myDownIm3 = myDownIm3;
    }

    public void setMyLeftIm1(BufferedImage myLeftIm1) {
        this.myLeftIm1 = myLeftIm1;
    }
    public void setMyLeftIm2(BufferedImage myLeftIm2) {
        this.myLeftIm2 = myLeftIm2;
    }
    public void setMyLeftIm3(BufferedImage myLeftIm3) {
        this.myLeftIm3 = myLeftIm3;
    }

    public void setMyRightIm1(BufferedImage myRightIm1) {
        this.myRightIm1 = myRightIm1;
    }
    public void setMyRightIm2(BufferedImage myRightIm2) {
        this.myRightIm2 = myRightIm2;
    }
    public void setMyRightIm3(BufferedImage myRightIm3) {
        this.myRightIm3 = myRightIm3;
    }

    public void setMyUpIm1(BufferedImage myUpIm1) {
        this.myUpIm1 = myUpIm1;
    }
    public void setMyUpIm2(BufferedImage myUpIm2) {
        this.myUpIm2 = myUpIm2;
    }
    public void setMyUpIm3(BufferedImage myUpIm3) {
        this.myUpIm3 = myUpIm3;
    }
}

