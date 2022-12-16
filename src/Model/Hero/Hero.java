package Model.Hero;

import Controller.InputControls;
import Model.Entities;
import Model.MazeCharacter;
import Model.MazeGenerator.Maze;
import Model.MazeGenerator.Maze.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Model.MazeGenerator.Maze.Direction.*;

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
     * The hero's number of power fruit.
     */
    private int myPowerFruit;

    /**
     * The hero's number of speed fruit.
     */
    private int mySpeedFruit;

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
    private static int myX = 400;

    /**
     * The hero's y-coordinate.
     */
    private static int myY = 400;

    /**
     * The hero's images.
     */
    private BufferedImage myUpIm1, myUpIm2, myUpIm3, myDownIm1, myDownIm2,
            myDownIm3, myLeftIm1, myLeftIm2, myLeftIm3, myRightIm1, myRightIm2, myRightIm3;

    /**
     * The hero's facing direction.
     */
    private static String myDirection = "down";
    /**
     * The hero's image number
     */
    private static int spriteNum = 1;
    /**
     * How fast the hero image updates
     */
    private static int spriteCounter = 0;
    /**
     * The hero's center y coordinate.
     */
    private static int myCenterX;
    /**
     * The hero's center x coordinate.
     */
    private static int myCenterY;
    /**
     * Determines if the hero can clip through walls
     */
    private static boolean noClip = false;

    /**
     * Constructor for the Hero class.
     */
    public Hero(final String theName, final int theHealthPoints, final int theAttackSpeed, final int theMinDamage,
                final int theMaxDamage, final double theHitChance, final double theDodgeChance, final double theSpecialChance, final int theMoveSpeed) {
        /*
         * Calls the constructor of the parent class.
         */
        super(theName, theHealthPoints, theAttackSpeed, theMinDamage, theMaxDamage,
                theHitChance, theDodgeChance, theSpecialChance);
        setSenzuBean(0);
        setPowerFruit(0);
        setSpeedFruit(0);
        setOriginalHealthPoints(theHealthPoints);
        setMoveSpeed(theMoveSpeed);
    }

    /**
     * This method turns the hero into god mode
     */
    public void godMode() {
        setNoClip();
        setHealthPoints(999999999);
        setOriginalHealthPoints(999999999);
        setAttackSpeed(999999999);
        setMinDamage(999999999);
        setMaxDamage(999999999);
        setHitChance(999999999);
        setMoveSpeed(999999999);
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
    protected int getPowerFruit() {
        return myPowerFruit;
    }

    /**
     * This method gets the hero's number of speed fruit.
     *
     * @return the hero's number of speed fruit.
     */
    protected int getSpeedFruit() {
        return mySpeedFruit;
    }

    /**
     * This method gets the hero's original health points.
     *
     * @return the hero's original health points.
     */
    protected int getOriginalHealthPoints() {
        return myOriginalHealthPoints;
    }

    public void setNoClip() {
        noClip = true;
    }

    public static boolean isNoClip() {
        return noClip;
    }


    /**
     * This method sets the hero's number senzu bean.
     *
     * @param theSenzuBean the hero's number of senzu bean.
     * @return the hero's input control.
     */
    protected void setSenzuBean(final int theSenzuBean) {
        if (theSenzuBean >= 0) {
            mySenzuBean = theSenzuBean;
        }
    }

    /**
     * This method sets the hero's number of power fruit.
     *
     * @param thePowerFruit the hero's number of power fruit.
     */
    protected void setPowerFruit(final int thePowerFruit) {
        if (thePowerFruit >= 0) {
            myPowerFruit = thePowerFruit;
        }
    }

    /**
     * This method sets the hero's number of speed fruit.
     *
     * @param theSpeedFruit the hero's number of speed fruit.
     */
    protected void setSpeedFruit(final int theSpeedFruit) {
        if (theSpeedFruit >= 0) {
            mySpeedFruit = theSpeedFruit;
        }
    }


    /**
     * This method sets the hero's original health points.
     *
     * @param theHealthPoints the hero's original health points.
     */
    protected void setOriginalHealthPoints(final int theHealthPoints) {
        if (theHealthPoints >= 0) {
            myOriginalHealthPoints = theHealthPoints;
        }
        myOriginalHealthPoints = theHealthPoints;
    }

    /**
     * This method sets the hero's movement speed.
     *
     * @param theMoveSpeed the hero's movement speed.
     */
    protected void setMoveSpeed(final int theMoveSpeed) {
        if (theMoveSpeed >= 0) {
            myMoveSpeed = theMoveSpeed;
        }
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
     * This method increments the number of power fruit.
     */
    protected void addPowerFruit() {
        myPowerFruit++;
        setPowerFruit(myPowerFruit);
    }

    /**
     * This method increments the number of speed fruit.
     */
    protected void addSpeedFruit() {
        mySpeedFruit++;
        setSpeedFruit(mySpeedFruit);
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
    public void usePowerFruit() {
        if (getPowerFruit() > 0) {
            myPowerFruit--;
            setPowerFruit(myPowerFruit);
            setMinDamage(getMinDamage() + 10);
            setMaxDamage(getMaxDamage() + 10);
            System.out.println(getName() + " used a power fruit and gained 10 attack!");
            System.out.println(getName() + " now has " + getMinDamage() + " min damage and " + getMaxDamage() +
                    " max damage attack!");
        } else {
            System.out.println(getName() + " has no power fruits left!");
        }
    }

    /**
     * This method increases the hero's attack speed.
     */
    public void useSpeedFruit() {
        if (getSpeedFruit() > 0) {
            mySpeedFruit--;
            setSpeedFruit(mySpeedFruit);
            setAttackSpeed(getAttackSpeed() + 1);
            System.out.println(getName() + " used a speed fruit and gained 1 speed!");
            System.out.println(getName() + " now has " + getAttackSpeed() + " speed!");
        } else {
            System.out.println(getName() + " has no speed fruits left!");
        }
    }

    public void randomItem() {
        int random = (int) (Math.random() * 4);
        if (random == 0) {
            addSenzuBean();
            System.out.println(getName() + " found a senzu bean!");
        } else if (random == 1) {
            addPowerFruit();
            System.out.println(getName() + " found a power fruit!");
        } else if (random == 2) {
            addSpeedFruit();
            System.out.println(getName() + " found a speed fruit!");
        } else {
            System.out.println(getName() + " found nothing!");
        }
    }

    //controls

    /**
     * This method updates the hero's movement.
     */
    public void update() {
        List<Entities> potentialCollisionList = isTouchingAny(Maze.getEntityList());
        List<Direction> sides = new ArrayList<>();
        for (Entities potentialCollision : potentialCollisionList) {
            sides.add(sideTouching(potentialCollision));
        }
        if (myY > 900) {
            Maze.switchRoom(SOUTH);
            myX = 300;
            myY = 50;

        }
        if (myY < -50) {
            Maze.switchRoom(NORTH);
            myX = 300;
            myY = 900;
        }
        if (myX > 1150) {
            Maze.switchRoom(EAST);
            myX = 0;
            myY = 400;
        }
        if (myX < -50) {
            Maze.switchRoom(WEST);
            myX = 1150;
            myY = 400;
        }
        if (inputCon.getDown() || InputControls.getLeft() || inputCon.getUp() || InputControls.getRight()) {
            if (inputCon.getUp()) {
                myDirection = "up";
                if (!sides.contains(SOUTH) || noClip) {
                    moveY(-myMoveSpeed);
                }
            } else if (inputCon.getDown()) {
                myDirection = "down";
                if (!sides.contains(NORTH) || noClip) {
                    moveY(myMoveSpeed);
                }
            }
            if (InputControls.getLeft()) {
                myDirection = "left";
                if (!sides.contains(EAST) || noClip) {
                    moveX(-myMoveSpeed);
                }
            } else if (InputControls.getRight()) {
                myDirection = "right";
                if (!sides.contains(WEST) || noClip) {
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
     *
     * @param theDistance is the distance moved in the x coordinate.
     */
    private static void moveX(final int theDistance) {
        myX += theDistance;
        myCenterX = myX + 64;
    }

    /**
     * This method sets the change of the hero's y coordinate.
     *
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

        theGraphics.drawImage(image, myX, myY, 128, 128, null);
    }

    /**
     * This method sets the hero's down image 1.
     *
     * @param theDownIm1
     */
    public void setImages(final BufferedImage theDownIm1, final BufferedImage theDownIm2, final BufferedImage theDownIm3,
                          final BufferedImage theLeftIm1, final BufferedImage theLeftIm2, final BufferedImage theLeftIm3,
                          final BufferedImage theRightIm1, final BufferedImage theRightIm2, final BufferedImage theRightIm3,
                          final BufferedImage theUpIm1, final BufferedImage theUpIm2, final BufferedImage theUpIm3) {

        myDownIm1 = theDownIm1;
        myDownIm2 = theDownIm2;
        myDownIm3 = theDownIm3;
        myLeftIm1 = theLeftIm1;
        myLeftIm2 = theLeftIm2;
        myLeftIm3 = theLeftIm3;
        myUpIm1 = theUpIm1;
        myUpIm2 = theUpIm2;
        myUpIm3 = theUpIm3;
        myRightIm1 = theRightIm1;
        myRightIm2 = theRightIm2;
        myRightIm3 = theRightIm3;
    }

    public BufferedImage getMyDefaultIm() {
        return myDownIm2;
    }

    /**
     * This method checks if the hero is touching an object.
     *
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
     *
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
     *
     * @param theEntity is the object the hero is touching.
     * @return the side the hero is touching.
     */
    public static Direction sideTouching(final Entities theEntity) {
        int[] theCoords = theEntity.getCoords();
        Direction side = null;

        int theX1 = theCoords[0];
        int theY1 = theCoords[1];
        int theX2 = theCoords[2];
        int theY2 = theCoords[3];

        //touching south side of object
        if ((myCenterY > (theY2 - 15) && myCenterY < theY2) && myCenterX > theX1 && myCenterX < theX2) {
            side = SOUTH;
        }

        //touching north side of object
        if ((myCenterY < (theY1 + 15) && myCenterY > theY1) && myCenterX > theX1 && myCenterX < theX2) {
            side = NORTH;
        }

        //touching west side of object
        if ((myCenterX < (theX1 + 15) && myCenterX > theX1) && myCenterY > theY1 && myCenterY < theY2) {
            side = WEST;
        }

        //touching east side of object
        if ((myCenterX > (theX2 - 15) && myCenterX < theX2) && myCenterY > theY1 && myCenterY < theY2) {
            side = EAST;
        }
        return side;
    }
}