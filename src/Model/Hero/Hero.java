package Model.Hero;

import Controller.InputControls;
import Model.MazeCharacter;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * this class represents a hero in the game.
 * @author Kevin Nguyen
 * @version 1.0
 */
public abstract class Hero extends MazeCharacter {
    /**
     * The hero's number of senzu bean.
     */
    private int mySenzuBean;
    /**
     * The hero's number of power power fruit.
     */
    private int myPowerPowerFruit;
    /**
     * The hero's number of speed speed fruit.
     */
    private int mySpeedSpeedFruit;
    /**
     * The hero's number of torch.
     */
    private int myTorch;
    /**
     * The hero's original health points.
     */
    private int myOriginalHealthPoints;
    /**
     * The hero's movement speed.
     */
    private int myMoveSpeed;
    /**
     * The hero's input control.
     */
    private final InputControls inputCon = new InputControls();
    /**
     * The hero's x-coordinate.
     */
    private int myX = 100;
    /**
     * The hero's y-coordinate.
     */
    private int myY = 100;
    /**
     * The hero's images.
     */
    private BufferedImage myUpIm1, myUpIm2, myUpIm3, myDownIm1, myDownIm2, myDownIm3, myLeftIm1, myLeftIm2,myLeftIm3,  myRightIm1, myRightIm2, myRightIm3;
    /**
     * The hero's current image.
     */
    private String myDirection = "down";
    /**
     * The hero's current image.
     */
    private int spriteNum = 1;
    /**
     * The hero's current image.
     */
    private int spriteCounter = 0;

    /**
     * Constructor for the Hero class.
     */
    public Hero(final String theName, final int theHealthPoints, final int theAttackSpeed, final int theMinDamage,
                final int theMaxDamage, final double theHitChance, final double theDodgeChance, final double theSpecialChance, final int theMoveSpeed) {
        /**
         * Calls the constructor of the parent class.
         */
        super(theName, theHealthPoints, theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        setSenzuBean(2);
        setPowerPowerFruit(2);
        setSpeedSpeedFruit(2);
        setTorch(0);
        setOriginalHealthPoints(theHealthPoints);
        setMoveSpeed(theMoveSpeed);
    }
    /**
     * This method gets the hero's number of senzu bean.
     * @return the hero's input control.
     */
    protected int getSenzuBean() {
        return mySenzuBean;
    }
    /**
     * This method gets the hero's number of power power fruit.
     * @return the hero's number of power power fruit.
     */
    protected int getPowerPowerFruit() {
        return myPowerPowerFruit;
    }
    /**
     * This method gets the hero's number of speed speed fruit.
     * @return the hero's number of speed speed fruit.
     */
    protected int getSpeedSpeedFruit() {
        return mySpeedSpeedFruit;
    }
    /**
     * This method gets the hero's number of torch.
     * @return the hero's number of torch.
     */
    protected int getTorch() {
        return myTorch;
    }
    /**
     * This method gets the hero's original health points.
     * @return the hero's original health points.
     */
    protected int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }
     /**
      * This method gets the hero's movement speed.
      * @return the hero's movement speed.
      */
    public int getMoveSpeed() {
        return myMoveSpeed;
    }
    /**
     * This method sets the hero's number senzu bean.
     * @param theSenzuBean the hero's number of senzu bean.
     * @return the hero's input control.
     */
    protected void setSenzuBean(final int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }
    /**
     * This method sets the hero's number of power power fruit.
     * @param thePowerPowerFruit the hero's number of power power fruit.
     */
    protected void setPowerPowerFruit(int thePowerPowerFruit) {
        myPowerPowerFruit = thePowerPowerFruit;
    }
    /**
     * This method sets the hero's number of speed speed fruit.
     * @param theSpeedSpeedFruit the hero's number of speed speed fruit.
     */
    protected void setSpeedSpeedFruit(int theSpeedSpeedFruit) {
        mySpeedSpeedFruit = theSpeedSpeedFruit;
    }
    /**
     * This method sets the hero's number of torch.
     * @param theTorch the hero's number of torch.
     */
    protected void setTorch(int theTorch) {
        myTorch = theTorch;
    }
    /**
     * This method sets the hero's original health points.
     * @param theHealthPoints the hero's original health points.
     */
    protected void setOriginalHealthPoints(int theHealthPoints){
        myOriginalHealthPoints = theHealthPoints;
    }
    /**
     * This method sets the hero's movement speed.
     * @param theMoveSpeed the hero's movement speed.
     */
    protected void setMoveSpeed(int theMoveSpeed) {
        myMoveSpeed = theMoveSpeed;
    }
    /**
     * This method increments the number of senzu bean.
     */
    protected void addSenzuBean() {
        mySenzuBean++;
        setSenzuBean(mySenzuBean);
    }
    /**
     * This method increments the number of power power fruit.
     */
    protected void addPowerPowerFruit() {
        myPowerPowerFruit++;
        setPowerPowerFruit(myPowerPowerFruit);
    }
    /**
     * This method increments the number of speed speed fruit.
     */
    protected void addSpeedSpeedFruit() {
        mySpeedSpeedFruit++;
        setSpeedSpeedFruit(mySpeedSpeedFruit);
    }
    /**
     * This method increments the number of torch.
     */
    protected void addTorch() {
        myTorch++;
        setTorch(myTorch);
    }
    /**
     * This method heals the hero's health.
     */
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
    /**
     * This method increases the hero's attack damage.
     */
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
    /**
     * This method increases the hero's attack speed.
     */
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
    /**
     * This method checks if there is a usuable torch.
     */
    public void useTorch() {
    }

    //controls
    /**
     * This method updates the hero's movement.
     */
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
    /**
     * This method draws the hero's image.
     * @param g the graphics object.
     */
    public void draw(final Graphics2D g){
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
        g.drawImage(image , myX, myY, 128, 128, null);

    }

    /**
     * This method returns the hero's x-coordinate.
     * @return the hero's x-coordinate.
     */
    public int getX(){return myX;}
    /**
     * This method returns the hero's y-coordinate.
     * @return the hero's y-coordinate.
     */
    public int getY(){return myY;}

    public void setMyDownIm1(final BufferedImage myDownIm1) {
        this.myDownIm1 = myDownIm1;
    }
    public void setMyDownIm2(final BufferedImage myDownIm2) {
        this.myDownIm2 = myDownIm2;
    }
    public void setMyDownIm3(final BufferedImage myDownIm3) {
        this.myDownIm3 = myDownIm3;
    }

    public void setMyLeftIm1(final BufferedImage myLeftIm1) {
        this.myLeftIm1 = myLeftIm1;
    }
    public void setMyLeftIm2(final BufferedImage myLeftIm2) {
        this.myLeftIm2 = myLeftIm2;
    }
    public void setMyLeftIm3(final BufferedImage myLeftIm3) {
        this.myLeftIm3 = myLeftIm3;
    }

    public void setMyRightIm1(final BufferedImage myRightIm1) {
        this.myRightIm1 = myRightIm1;
    }
    public void setMyRightIm2(final BufferedImage myRightIm2) {
        this.myRightIm2 = myRightIm2;
    }
    public void setMyRightIm3(final BufferedImage myRightIm3) {
        this.myRightIm3 = myRightIm3;
    }

    public void setMyUpIm1(final BufferedImage myUpIm1) {
        this.myUpIm1 = myUpIm1;
    }
    public void setMyUpIm2(final BufferedImage myUpIm2) {
        this.myUpIm2 = myUpIm2;
    }
    public void setMyUpIm3(final BufferedImage myUpIm3) {
        this.myUpIm3 = myUpIm3;
    }
}

