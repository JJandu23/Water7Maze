package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class is used to create the entities.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Entities {
    /**
     * The Hero's coordinates.
     */
    private int[] myCoords = new int[4];
    /**
     * The Hero's image.
     */
    private BufferedImage mySprite;
    /**
     * The Hero's x-coordinate.
     */
    private int myX;
    /**
     * The Hero's y-coordinate.
     */
    private int myY;
    /**
     * The Hero's width.
     */
    private final int myWidth;
    /**
     * The Hero's height.
     */
    private final int myHeight;
    /**
     * The maze room x-coordinate.
     */
    private int myRoomX;
    /**
     * The maze room y-coordinate.
     */
    private int myRoomY;

    int[] xPoints;
    int[] yPoints;
    /**
     * This method prints out the room location of the hero in the console.
     */
    public String toString() {
        return "Room: " + myRoomX + " " + myRoomY;
    }


    public Entities(final int theX1, final int theY1, final int theX2, final int theY2) {

        myCoords[0] = theX1;
        myCoords[1] = theY1;
        myCoords[2] = theX2;
        myCoords[3] = theY2;
        myWidth = myCoords[2] - myCoords[0];
        myHeight = myCoords[3] - myCoords[1];
        myX = (theX1 + theX2) / 2;
        myY = (theY1 + theY2) / 2;
        xPoints = new int[]{myCoords[0], myCoords[2], myCoords[2], myCoords[0]};
        yPoints = new int[]{myCoords[1], myCoords[1], myCoords[3], myCoords[3]};
    }
    /**
     * This method is used to se the hero's sprite.
     */
    public void setSprite(final BufferedImage theSprite) {
        mySprite = theSprite;
    }

    public void draw(final Graphics2D theGraphics) {
        theGraphics.drawPolygon(xPoints, yPoints, 4);
        theGraphics.drawImage(mySprite, myCoords[0], myCoords[1], myWidth, myHeight, null);
    }

    public void changeCoords(final int theX, final int theY) {
        myCoords[0] = theX - (myWidth / 2);
        myCoords[1] = theY - (myHeight / 2);
        myCoords[2] = theX + (myWidth / 2);
        myCoords[3] = theY + (myHeight / 2);
        myX = (myCoords[0] + myCoords[2]) / 2;
        myY = (myCoords[1] + myCoords[3]) / 2;
    }
    /**
     * This method is used to get the Hero's coordinate.
     *
     * @return the Hero's coordinate.
     */
    public int[] getCoords() {
        return myCoords;
    }
    /**
     * This method is used to set the hero's room location.
     *
     * @return the Hero's room location.
     */
    public void setRoomLocation(final int theRoomX, final int theRoomY) {
        myRoomX = theRoomX;
        myRoomY = theRoomY;
    }
    /**
     * This method is used to get the maze room x-coordinate.
     *
     * @return the maze room x-coordinate.
     */
    public int getRoomX() {
        return myRoomX;
    }
    /**
     * This method is used to get the maze room y-coordinate.
     *
     * @return the maze room y-coordinate.
     */
    public int getRoomY() {
        return myRoomY;
    }
}
