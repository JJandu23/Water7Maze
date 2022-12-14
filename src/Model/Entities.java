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

    private final int myWidth;
    private final int myHeight;
    private int myRoomX;
    private int myRoomY;



    public String toString() {
        return "Room: " + myRoomX + " " + myRoomY;
    }


    public Entities(int theX1, int theY1, int theX2, int theY2) {

        myCoords[0] = theX1;
        myCoords[1] = theY1;
        myCoords[2] = theX2;
        myCoords[3] = theY2;
        myWidth = myCoords[2] - myCoords[0];
        myHeight = myCoords[3] - myCoords[1];


    }

    public void setSprite(BufferedImage theSprite) {
        mySprite = theSprite;
    }

    public void draw(Graphics2D g) {

        g.drawImage(mySprite, myCoords[0], myCoords[1], myWidth, myHeight, null);
    }




    public int[] getCoords() {
        return myCoords;
    }

    public void setRoomLocation(int theRoomX, int theRoomY) {
        myRoomX = theRoomX;
        myRoomY = theRoomY;
    }

}
