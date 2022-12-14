package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * This class is used to create entities.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Entities {
    /**
     * The integer array that represents the hero
     */
    private int[] myCoords = new int[4];
    /**
     * The image that represents the hero
     */
    private BufferedImage mySprite;
    /**
     * The width of the hero
     */
    private final int myWidth;
    /**
     * The height of the hero
     */
    private final int myHeight;
    /**
     * The x coordinate of the room
     */
    private int myRoomX;
    /**
     * The y coordinate of the room
     */
    private int myRoomY;

    /**
     * Prints out the room of the hero
     * @return the room of the hero
     */
    public String toString() {
        return "Room: " + myRoomX + " " + myRoomY;
    }

    /**
     * Constructor for Entities
     * @param theX1 the top left x coordinate
     * @param theY1 the top left y coordinate
     * @param theX2 the bottom right x coordinate
     * @param theY2 the bottom right y coordinate
     */
    public Entities(final int theX1, final int theY1, final int theX2, final int theY2) {
        myCoords[0] = theX1;
        myCoords[1] = theY1;
        myCoords[2] = theX2;
        myCoords[3] = theY2;
        myWidth = myCoords[2] - myCoords[0];
        myHeight = myCoords[3] - myCoords[1];
    }

    /**
     * This method sets the sprite of the hero
     * @param theSprite the sprite of the hero
     */
    public void setSprite(final BufferedImage theSprite) {
        mySprite = theSprite;
    }

    /**
     * This method draws
     * @param theGraphics the graphics
     */
    public void draw(final Graphics2D theGraphics) {

        theGraphics.drawImage(mySprite, myCoords[0], myCoords[1], myWidth, myHeight, null);
    }

    /**
     * Gets the coordinates of the hero
     * @return the hero coordinates
     */
    public int[] getCoords() {
        return myCoords;
    }
    /**
     * Sets the room location of the hero
     * @param theRoomX the x coordinate of the room
     * @param theRoomY the y coordinate of the room
     */
    public void setRoomLocation(final int theRoomX,final int theRoomY) {
        myRoomX = theRoomX;
        myRoomY = theRoomY;
    }

}
