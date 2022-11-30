package Model.Hero;

import Controller.InputControls;
import Model.Entities;
import Model.MazeCharacter;
import Model.MazeGenerator.Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class represents a hero in the game.
 *
 * @author Kevin Nguyen, Nicholas Zhuk and Jashanpreet Jandu
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
    private static final InputControls inputCon = new InputControls();

    /**
     * The hero's x-coordinate.
     */
    private static int myX = 100;

    /**
     * The hero's y-coordinate.
     */
    private static int myY = 100;

    /**
     * The hero's images.
     */
    private BufferedImage myUpIm1, myUpIm2, myUpIm3, myDownIm1, myDownIm2, myDownIm3, myLeftIm1, myLeftIm2, myLeftIm3, myRightIm1, myRightIm2, myRightIm3;

    /**
     * The hero's current image.
     */
    private static String myDirection = "down";

    /**
     * The hero's current image.
     */
    private static int spriteNum = 1;

    /**
     * The hero's current image.
     */
    private static int spriteCounter = 0;
    private static int myRoomX = 0;
    private static int myRoomY = 0;
    private static int myCenterX;
    private static int myCenterY;

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
     *
     * @return the hero's input control.
     */
    protected int getSenzuBean() {
        return mySenzuBean;
    }

    /**
     * This method gets the hero's number of power power fruit.
     *
     * @return the hero's number of power power fruit.
     */
    protected int getPowerPowerFruit() {
        return myPowerPowerFruit;
    }

    /**
     * This method gets the hero's number of speed speed fruit.
     *
     * @return the hero's number of speed speed fruit.
     */
    protected int getSpeedSpeedFruit() {
        return mySpeedSpeedFruit;
    }

    /**
     * This method gets the hero's number of torch.
     *
     * @return the hero's number of torch.
     */
    protected int getTorch() {
        return myTorch;
    }

    /**
     * This method gets the hero's original health points.
     *
     * @return the hero's original health points.
     */
    protected int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }

    /**
     * This method gets the hero's movement speed.
     *
     * @return the hero's movement speed.
     */
    public int getMoveSpeed() {
        return myMoveSpeed;
    }

    /**
     * This method sets the hero's number senzu bean.
     *
     * @param theSenzuBean the hero's number of senzu bean.
     * @return the hero's input control.
     */
    protected void setSenzuBean(final int theSenzuBean) {
        mySenzuBean = theSenzuBean;
    }

    /**
     * This method sets the hero's number of power power fruit.
     *
     * @param thePowerPowerFruit the hero's number of power power fruit.
     */
    protected void setPowerPowerFruit(final int thePowerPowerFruit) {
        myPowerPowerFruit = thePowerPowerFruit;
    }

    /**
     * This method sets the hero's number of speed speed fruit.
     *
     * @param theSpeedSpeedFruit the hero's number of speed speed fruit.
     */
    protected void setSpeedSpeedFruit(final int theSpeedSpeedFruit) {
        mySpeedSpeedFruit = theSpeedSpeedFruit;
    }

    /**
     * This method sets the hero's number of torch.
     *
     * @param theTorch the hero's number of torch.
     */
    protected void setTorch(final int theTorch) {
        myTorch = theTorch;
    }

    /**
     * This method sets the hero's original health points.
     *
     * @param theHealthPoints the hero's original health points.
     */
    protected void setOriginalHealthPoints(final int theHealthPoints) {
        myOriginalHealthPoints = theHealthPoints;
    }

    /**
     * This method sets the hero's movement speed.
     *
     * @param theMoveSpeed the hero's movement speed.
     */
    protected void setMoveSpeed(final int theMoveSpeed) {
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
     * This method checks if there is a usable torch.
     */
    public void useTorch() {
    }

    //controls

    /**
     * This method updates the hero's movement.
     */
    public void update() {
        List<Entities> potentialCollisionList = isTouchingAny(Maze.getEntityList());
        List<String> sides = new ArrayList<>();
        for (Entities potentialCollision : potentialCollisionList) {
            sides.add(sideTouching(potentialCollision));
        }
        if (myY > 900) {
            Maze.switchRoom("South");
            myX = 300;
            myY = 50;
        }
        if (myY < -50) {
            Maze.switchRoom("North");
            myX = 300;
            myY = 900;
        }
        if (myX > 1150) {
            Maze.switchRoom("East");
            myX = 0;
            myY = 400;
        }
        if (myX < -50) {
            Maze.switchRoom("West");
            myX = 1150;
            myY = 400;
        }
        if (inputCon.getDown() || InputControls.getLeft() || inputCon.getUp() || InputControls.getRight()) {
            if (inputCon.getUp()) {
                myDirection = "up";
                if (!sides.contains("South")) {
                    moveY(-myMoveSpeed);
                }
            } else if (inputCon.getDown()) {
                myDirection = "down";
                if (!sides.contains("North")) {
                    moveY(myMoveSpeed);
                }
            }
            if (InputControls.getLeft()) {
                myDirection = "left";
                if (!sides.contains("East")) {
                    moveX(-myMoveSpeed);
                }
            } else if (InputControls.getRight()) {
                myDirection = "right";
                if (!sides.contains("West")) {
                    moveX(myMoveSpeed);
                }

            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 2;
        }
    }

    /**
     * This method sets the change of the hero's x coordinate.
     * @param theDistance is the distance moved in the x coordinate.
     */
    private static void moveX(final int theDistance) {
        myX += theDistance;
        myCenterX = myX + 64;
    }

    /**
     * This method sets the change of the hero's y coordinate.
     * @param theDistance is the distance moved in the y coordinate.
     */
    private static void moveY(final int theDistance) {
        myY += theDistance;
        myCenterY = myY + 64;
    }

    /**
     * This method draws the hero's image.
     *
     * @param theGraphics the graphics object.
     */
    public void draw(final Graphics2D theGraphics) {
        BufferedImage image = null;
        switch (myDirection) {
            case "up":

                if (spriteNum == 1) {
                    image = myUpIm1;

                } else if (spriteNum == 2) {
                    image = myUpIm2;
                } else if (spriteNum == 3) {
                    image = myUpIm3;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = myDownIm1;
                } else if (spriteNum == 2) {
                    image = myDownIm2;
                } else if (spriteNum == 3) {
                    image = myDownIm3;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = myLeftIm1;
                } else if (spriteNum == 2) {
                    image = myLeftIm2;
                } else if (spriteNum == 3) {
                    image = myLeftIm3;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = myRightIm1;
                } else if (spriteNum == 2) {
                    image = myRightIm2;
                } else if (spriteNum == 3) {
                    image = myRightIm3;
                }
                break;
            default:
                image = null;
        }
        /*System.out.println("My X "+myCenterX+ " My Y: " + myCenterY);*/

        theGraphics.drawPolygon(new int[]{myX, myX + 128, myX + 128, myX}, new int[]{myY, myY, myY + 128, myY + 128}, 4);
        theGraphics.drawImage(image, myX, myY, 128, 128, null);
    }

    /**
     * This method returns the hero's x-coordinate.
     *
     * @return the hero's x-coordinate.
     */
    public int getX() {
        return myX;
    }

    /**
     * This method returns the hero's y-coordinate.
     *
     * @return the hero's y-coordinate.
     */
    public int getY() {
        return myY;
    }

    /**
     * This method sets the hero's down image 1.
     * @param theDownIm1
     */
    public void setMyDownIm1(final BufferedImage theDownIm1) {
        myDownIm1 = theDownIm1;
    }

    /**
     * This method sets the hero's down image 2.
     * @param theDownIm2 is the down image 2.
     */
    public void setMyDownIm2(final BufferedImage theDownIm2) {
        myDownIm2 = theDownIm2;
    }

    /**
     * This method sets the hero's down image 3.
     * @param theDownIm3 is the down image 3.
     */
    public void setMyDownIm3(final BufferedImage theDownIm3) {
        myDownIm3 = theDownIm3;
    }

    /**
     * This method sets the hero's left image 1.
     * @param theLeftIm1 is the left image 1.
     */
    public void setMyLeftIm1(final BufferedImage theLeftIm1) {
        myLeftIm1 = theLeftIm1;
    }

    /**
     * This method sets the hero's left image 2.
     * @param theLeftIm2 is the left image 2.
     */
    public void setMyLeftIm2(final BufferedImage theLeftIm2) {
        myLeftIm2 = theLeftIm2;
    }

    /**
     * This method sets the hero's left image 3.
     * @param theLeftIm3 is the left image 3.
     */
    public void setMyLeftIm3(final BufferedImage theLeftIm3) {
        myLeftIm3 = theLeftIm3;
    }

    /**
     * This method sets the hero's right image 1.
     * @param theRightIm1 is the right image 1.
     */
    public void setMyRightIm1(final BufferedImage theRightIm1) {
        myRightIm1 = theRightIm1;
    }

    /**
     * This method sets the hero's right image 2.
     * @param theRightIm2 is the right image 2.
     */
    public void setMyRightIm2(final BufferedImage theRightIm2) {
        myRightIm2 = theRightIm2;
    }

    /**
     * This method sets the hero's right image 3.
     * @param theRightIm3 is the right image 3.
     */
    public void setMyRightIm3(final BufferedImage theRightIm3) {
        myRightIm3 = theRightIm3;
    }

    /**
     * This method sets the hero's up image 1.
     * @param theUpIm1 is the up image 1.
     */
    public void setMyUpIm1(final BufferedImage theUpIm1) {
        myUpIm1 = theUpIm1;
    }

    /**
     * This method sets the hero's up image 2.
     * @param theUpIm2 is the up image 2.
     */
    public void setMyUpIm2(final BufferedImage theUpIm2) {
        myUpIm2 = theUpIm2;
    }

    /**
     * This method sets the hero's up image 3.
     * @param theUpIm3 is the up image 3.
     */
    public void setMyUpIm3(final BufferedImage theUpIm3) {
        myUpIm3 = theUpIm3;
    }


    public BufferedImage getMyDefaultIm(){
        return myDownIm1;
    }




    /**
     * This method checks if the hero is touching an object.
     * @param theEntity is the object the hero is touching.
     * @return true if the hero is touching the object.
     */
    public static boolean isTouching(final Entities theEntity) {
        int[] theCoords = theEntity.getCoords();
        boolean touching = false;
        int theX1 = theCoords[0];
        int theY1 = theCoords[1];
        int theX2 = theCoords[2];
        int theY2 = theCoords[3];

        if (myCenterX > theX1 && myCenterX < theX2 && myCenterY > theY1 && myCenterY < theY2) {
            touching = true;
        }
        return touching;
    }
    /**
     * This method creates a list of objects the hero is touching.
     * @param theEntitiesList is the object the hero is touching.
     * @return the list of objects the hero is touching.
     */
    private static List<Entities> isTouchingAny(final HashMap<String, Entities> theEntitiesList) {
        List<Entities> theTouchingList = new ArrayList<>();
        for (String name : theEntitiesList.keySet()) {
            if (isTouching(theEntitiesList.get(name))) {
                theTouchingList.add(theEntitiesList.get(name));
            }
        }
        return theTouchingList;
    }

    /**
     * This method determines which side the hero is touching.
     * @param theEntity is the object the hero is touching.
     * @return the side the hero is touching.
     */
    public static String sideTouching(final Entities theEntity) {
        int[] theCoords = theEntity.getCoords();
        String side = "";

        int theX1 = theCoords[0];
        int theY1 = theCoords[1];
        int theX2 = theCoords[2];
        int theY2 = theCoords[3];

        //touching south side of object
        if ((myCenterY > (theY2 - 15) && myCenterY < theY2) && myCenterX > theX1 && myCenterX < theX2) {
            side = "South";
        }

        //touching north side of object
        if ((myCenterY < (theY1 + 15) && myCenterY > theY1) && myCenterX > theX1 && myCenterX < theX2) {
            side = "North";
        }

        //touching west side of object
        if ((myCenterX < (theX1 + 15) && myCenterX > theX1) && myCenterY > theY1 && myCenterY < theY2) {
            side = "West";
        }

        //touching east side of object
        if ((myCenterX > (theX2 - 15) && myCenterX < theX2) && myCenterY > theY1 && myCenterY < theY2) {
            side = "East";
        }
        return side;
    }
}

