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

    private int[] myCoords = new int[4];
    private BufferedImage mySprite;
    private int myX;
    private int myY;
    private final int myWidth;
    private final int myHeight;
    private int myRoomX;
    private int myRoomY;
    private int[] xPoints;
    private int[] yPoints;
    private boolean isCollidable;


    public String toString() {
        return "Room: " + myRoomX + " " + myRoomY;
    }


    public Entities(int theX1, int theY1, int theX2, int theY2, boolean collidable) {
        isCollidable = collidable;
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

    public void setSprite(BufferedImage theSprite) {
        mySprite = theSprite;
    }

    public void draw(Graphics2D g) {
        g.drawPolygon(xPoints, yPoints, 4);
        g.drawImage(mySprite, myCoords[0], myCoords[1], myWidth, myHeight, null);
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    public void changeCoords(int theX, int theY) {
        myCoords[0] = theX - (myWidth / 2);
        myCoords[1] = theY - (myHeight / 2);
        myCoords[2] = theX + (myWidth / 2);
        myCoords[3] = theY + (myHeight / 2);
        myX = (myCoords[0] + myCoords[2]) / 2;
        myY = (myCoords[1] + myCoords[3]) / 2;
    }

    public int[] getCoords() {
        return myCoords;
    }

    public void setRoomLocation(int theRoomX, int theRoomY) {
        myRoomX = theRoomX;
        myRoomY = theRoomY;
    }

    public int getRoomX() {
        return myRoomX;
    }

    public int getRoomY() {
        return myRoomY;
    }
}
