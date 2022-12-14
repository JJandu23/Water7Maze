package Model.MazeGenerator;

import Model.Entities;
import Model.MazeCharacter;
import Model.MazeGenerator.Maze.Direction;
import View.GameView;

import javax.imageio.ImageIO;
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
    private String myRoomType;
    private boolean myRoomKey = false;
    private Entities northDoorEnt, southDoorEnt, westDoorEnt, eastDoorEnt;
    private final int[] northDoorCoords = new int[]{0, 0, GameView.getScreenWidth(), 200};
    private final int[] southDoorCoords = new int[]{0, GameView.getScreenHeight() - 200, GameView.getScreenWidth(), GameView.getScreenHeight()};
    private final int[] eastDoorCoords = new int[]{GameView.getScreenWidth() - 200, 0, GameView.getScreenWidth(), GameView.getScreenHeight()};
    private final int[] westDoorCoords = new int[]{0, 0, 200, GameView.getScreenHeight()};
    private BufferedImage background;
    private MazeCharacter myEnemy;


    public Room(boolean doorNorth, boolean doorWest, boolean doorSouth, boolean doorEast) {

        try {
            background = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../../View/Sprites/floor.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.myDoorNorth = doorNorth;
        this.myDoorSouth = doorSouth;
        this.myDoorWest = doorWest;
        this.myDoorEast = doorEast;
    }

    public void setRoomKey() {
        myRoomKey = !myRoomKey;
    }

    public boolean hasKey() {
        return myRoomKey;
    }

    public void setRoomType(String theRoomType){
        myRoomType = theRoomType;
    }

    public void setRoomEnemy(MazeCharacter theEnemy) {
        myEnemy = theEnemy;
    }

    public MazeCharacter getEnemy() {
        return myEnemy;
    }

    public void openDoor(Direction direction) {
        switch (direction) {
            case NORTH -> myDoorNorth = true;
            case SOUTH -> myDoorSouth = true;
            case WEST -> myDoorWest = true;
            case EAST -> myDoorEast = true;
        }
    }

    @Override
    public String toString() {
        String str = "";
        str += "(";
        if (myRoomKey && myRoomType.equals("START")) {
            str += "...";
        }
        if (myDoorNorth) str += " north ";
        if (myDoorWest) str += " west ";
        if (myDoorSouth) str += " south ";
        if (myDoorEast) str += " east ";
        if (myRoomKey  && myRoomType.equals("FINAL")) {
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
            img = ImageIO.read(Objects.requireNonNull(Maze.class.getResourceAsStream(path)));

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

    public BufferedImage getBackground() {
        return background;
    }
}