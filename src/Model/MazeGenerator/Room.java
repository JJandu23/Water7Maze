package Model.MazeGenerator;

import Controller.InputControls;
import Model.Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * This class is used to represent a room in the maze.
 * Each room has 4 doors, one for each cardinal direction.
 * The doors are either open or closed.
 * The room also has a floor and a ceiling.
 * The room is represented by a 2D array of characters.
 * The room is printed to the console by printing each row of the 2D array.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Room {
    private boolean myDoorNorth;
    private boolean myDoorSouth;
    private boolean myDoorEast;
    private boolean myDoorWest;
    private String myRoomItems;
    private Entities northDoorEnt, southDoorEnt, westDoorEnt, eastDoorEnt;
    private final int[] northDoorCoords = new int[]{0, 0, 1232, 148};
    private final int[] southDoorCoords = new int[]{0, 812, 1232, 960};
    private final int[] eastDoorCoords = new int[]{1000, -50, 1150, 1050};
    private final int[] westDoorCoords = new int[]{-50, -50, 100, 1050};
    private final Color background;
    private Entities[][] myRoomHazard = new Entities[10][10];
    private BufferedImage mySpikeImage;

    public Room(boolean doorNorth, boolean doorWest, boolean doorSouth, boolean doorEast) {
        double hue = Math.random();
        int rgb = Color.HSBtoRGB((float) hue, 0.5F, 0.5F);
        background = new Color(rgb);
        this.myDoorNorth = doorNorth;
        this.myDoorSouth = doorSouth;
        this.myDoorWest = doorWest;
        this.myDoorEast = doorEast;
        try {
            mySpikeImage = ImageIO.read(Maze.class.getResourceAsStream("../../View/Sprites/WallText.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRoomItems(String roomItems) {
        myRoomItems = roomItems;
    }

    public void setRoomType(String theRoomType) {
        String[][] StringRoomHazard = new String[myRoomHazard.length][myRoomHazard[0].length];
        if (theRoomType.equals("L")) {
            for (int i = 0; i < myRoomHazard[0].length; i++) {
                StringRoomHazard[0][i] = "X";
            }
            for (int i = 1; i < myRoomHazard.length; i++) {
                StringRoomHazard[i][myRoomHazard[0].length - 1] = "X";
            }
        }
        System.out.println("Created hazard room");
        setRoomHazard(StringRoomHazard);
    }

    private void setRoomHazard(String[][] theRoomHazard) {
        int startX = 250;
        int startY = 50;
        int spriteSize = 64;

        for (int i = 0; i < myRoomHazard.length; i++) {
            for (int j = 0; j < myRoomHazard[i].length; j++) {
                int x1 = startX + (i * spriteSize);
                int y1 = startY + (j * spriteSize);
                int x2 = x1 + spriteSize;
                int y2 = y1 + spriteSize;
                if (theRoomHazard[i][j] != null) {
                    myRoomHazard[i][j] = new Entities(x1, y1, x2, y2, false);
                    myRoomHazard[i][j].setSprite(mySpikeImage);
                }

            }
        }
    }

    public void openDoor(String direction) {
        switch (direction) {
            case "North" -> myDoorNorth = true;
            case "South" -> myDoorSouth = true;
            case "West" -> myDoorWest = true;
            case "East" -> myDoorEast = true;
        }
    }

    @Override
    public String toString() {
        String str = "";
        str += "(";
        if (myRoomItems != null && myRoomItems.equals("START")) {
            str += "...";
        }
        if (myDoorNorth) str += " north ";
        if (myDoorWest) str += " west ";
        if (myDoorSouth) str += " south ";
        if (myDoorEast) str += " east ";
        if (myRoomItems != null && myRoomItems.equals("FINAL")) {
            str += "F";
        }
        str += ")";
        return str;
    }

    public boolean isMyDoorNorth() {
        return myDoorNorth;
    }

    public boolean isMyDoorEast() {
        return myDoorEast;
    }

    public boolean isMyDoorSouth() {
        return myDoorSouth;
    }

    public boolean isMyDoorWest() {
        return myDoorWest;
    }

    public Entities northDoorEntity() {
        return northDoorEnt;
    }

    public Entities southDoorEntity() {
        return southDoorEnt;
    }

    public Entities westDoorEntity() {
        return westDoorEnt;
    }

    public Entities eastDoorEntity() {
        return eastDoorEnt;
    }

    public void setDoors(String doorDirection, String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Maze.class.getResourceAsStream(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (doorDirection) {
            case "North":
                northDoorEnt = new Entities(northDoorCoords[0], northDoorCoords[1], northDoorCoords[2], northDoorCoords[3], true);
                northDoorEnt.setSprite(img);
            case "South":
                southDoorEnt = new Entities(southDoorCoords[0], southDoorCoords[1], southDoorCoords[2], southDoorCoords[3], true);
                southDoorEnt.setSprite(img);
            case "West":
                westDoorEnt = new Entities(westDoorCoords[0], westDoorCoords[1], westDoorCoords[2], westDoorCoords[3], true);
                westDoorEnt.setSprite(img);
            case "East":
                eastDoorEnt = new Entities(eastDoorCoords[0], eastDoorCoords[1], eastDoorCoords[2], eastDoorCoords[3], true);
                eastDoorEnt.setSprite(img);
        }
    }

    public void drawHazards(Graphics2D g) {
        for (int i = 0; i < myRoomHazard.length; i++) {
            for (int j = 0; j < myRoomHazard[i].length; j++) {
                if (myRoomHazard[i][j] != null) {
                    myRoomHazard[i][j].draw(g);
                }
            }
        }
    }

    public void update() {
    }

    public Color getBackground() {
        return background;
    }
}