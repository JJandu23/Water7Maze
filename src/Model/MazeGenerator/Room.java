package Model.MazeGenerator;

import Model.Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Room {
    private boolean myDoorNorth;
    private boolean myDoorSouth;
    private boolean myDoorEast;
    private boolean myDoorWest;
    private String myRoomItems;
    private Entities northDoorEnt, southDoorEnt, westDoorEnt, eastDoorEnt;
    private final int[] northDoorCoords = new int[]{-50, -50, 1300, 100};
    private final int[] southDoorCoords = new int[]{-50, 750, 1300, 900};
    private final int[] eastDoorCoords = new int[]{1000, -50, 1150, 1050};
    private final int[] westDoorCoords = new int[]{-50, -50, 100, 1050};
    private final Color background;


    public Room(boolean doorNorth, boolean doorWest, boolean doorSouth, boolean doorEast) {
        double hue = Math.random();
        int rgb = Color.HSBtoRGB((float) hue, 0.5F, 0.5F);
        background = new Color(rgb);
        this.myDoorNorth = doorNorth;
        this.myDoorSouth = doorSouth;
        this.myDoorWest = doorWest;
        this.myDoorEast = doorEast;
    }

    public void setRoomItems(String roomItems) {
        myRoomItems = roomItems;
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

    public Entities northDoorEntity() {return northDoorEnt;}
    public Entities southDoorEntity() {return southDoorEnt;}
    public Entities westDoorEntity() {return westDoorEnt;}
    public Entities eastDoorEntity() {return eastDoorEnt;}


    public void setDoors(String doorDirection, String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Maze.class.getResourceAsStream("../../View/Sprites/unknown.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (doorDirection) {
            case "North":
                northDoorEnt = new Entities(northDoorCoords[0], northDoorCoords[1], northDoorCoords[2], northDoorCoords[3]);
                northDoorEnt.setSprite(img);
            case "South":
                southDoorEnt = new Entities(southDoorCoords[0], southDoorCoords[1], southDoorCoords[2], southDoorCoords[3]);
                southDoorEnt.setSprite(img);
            case "West":
                westDoorEnt = new Entities(westDoorCoords[0], westDoorCoords[1], westDoorCoords[2], westDoorCoords[3]);
                westDoorEnt.setSprite(img);
            case "East":
                eastDoorEnt = new Entities(eastDoorCoords[0], eastDoorCoords[1], eastDoorCoords[2], eastDoorCoords[3]);
                eastDoorEnt.setSprite(img);
        }

    }
    public Color getBackground(){
        return background;
    }

}