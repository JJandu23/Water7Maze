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
    /**
     * The room's north door
     */
    private boolean myDoorNorth;
    /**
     * The door south.
     */
    private boolean myDoorSouth;
    /**
     * The east door
     */
    private boolean myDoorEast;
    /**
     * The west door
     */
    private boolean myDoorWest;
    /**
     * The type of room.
     */
    private String myRoomType;
    /**
     * Boolean to check if the room has a key
     */
    private boolean myRoomKey = false;
    /**
     * Entities of doors in the room
     */
    private Entities northDoorEnt, southDoorEnt, westDoorEnt, eastDoorEnt;
    /**
     * Coordinates of the north door
     */
    private final int[] northDoorCoords = new int[]{0, 0, GameView.getScreenWidth(), 200};
    /**
     * Coordinates of the south door
     */
    private final int[] southDoorCoords = new int[]{0, GameView.getScreenHeight() - 200, GameView.getScreenWidth(), GameView.getScreenHeight()};
    /**
     * Coordinates of the east door
     */
    private final int[] eastDoorCoords = new int[]{GameView.getScreenWidth() - 200, 0, GameView.getScreenWidth(), GameView.getScreenHeight()};
    /**
     * Coordinates of the west door
     */
    private final int[] westDoorCoords = new int[]{0, 0, 200, GameView.getScreenHeight()};
    /**
     * background image of the room
     */
    private BufferedImage background;
    /**
     * The enemu in the room
     */
    private MazeCharacter myEnemy;

    /**
     * Room constructor
     */
    public Room(final boolean theDoorNorth, final boolean theDoorWest, final boolean theDoorSouth, final boolean theDoorEast) {

        try {
            background = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../../View/Sprites/floor.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.myDoorNorth = theDoorNorth;
        this.myDoorSouth = theDoorSouth;
        this.myDoorWest = theDoorWest;
        this.myDoorEast = theDoorEast;
    }

    /**
     * This method sets the room key
     */
    public void setRoomKey() {
        myRoomKey = !myRoomKey;
    }
    /**
     * This method determines if the room has a key
     * @return true if the room has a key
     */
    public boolean hasKey() {
        return myRoomKey;
    }

    /**
     * This method sets the room type
     * @param theRoomType the room type
     */
    public void setRoomType(final String theRoomType){
        myRoomType = theRoomType;
    }

    /**
     * This method sets the enemy in the room
     * @param theEnemy the enemy
     */
    public void setRoomEnemy(final MazeCharacter theEnemy) {
        myEnemy = theEnemy;
    }

    /**
     * This method gets the enemy in the room
     * @return the enemy
     */
    public MazeCharacter getEnemy() {
        return myEnemy;
    }
    /**
     * This method gets the room type
     * @return the room type
     */
    public void openDoor(final Direction theDirection) {
        switch (theDirection) {
            case NORTH -> myDoorNorth = true;
            case SOUTH -> myDoorSouth = true;
            case WEST -> myDoorWest = true;
            case EAST -> myDoorEast = true;
        }
    }
    /**
     * This method returns a string representation of the room
     */
    @Override
    public String toString() {
        String str = "";
        str += "(";
        if (myRoomKey && myRoomType != null && myRoomType.equals("START")) {
            str += "...";
        }
        if (myDoorNorth) str += " north ";
        if (myDoorWest) str += " west ";
        if (myDoorSouth) str += " south ";
        if (myDoorEast) str += " east ";
        if (myRoomKey && myRoomType != null && myRoomType.equals("FINAL")) {
            str += "F";
        }
        str += ")";
        return str;
    }
    /**
     * This method returns the north door
     * @return the north door
     */
    public boolean isMyDoorNorth() {
        return myDoorNorth;
    }
    /**
     * This method returns the south door
     * @return the south door
     */
    public boolean isMyDoorEast() {
        return myDoorEast;
    }
    /**
     * This method returns the west door
     * @return the west door
     */
    public boolean isMyDoorSouth() {
        return myDoorSouth;
    }
    /**
     * This method returns the east door
     * @return the east door
     */
    public boolean isMyDoorWest() {
        return myDoorWest;
    }
    /**
     * This method returns the north door entity
     * @return the north door entity
     */
    public Entities northDoorEntity() {
        if(northDoorEnt == null) {
            northDoorEnt = new Entities(northDoorCoords[0], northDoorCoords[1], northDoorCoords[2], northDoorCoords[3]);
        }
        return northDoorEnt;
    }
    /**
     * This method returns the south door entity
     * @return the south door entity
     */
    public Entities southDoorEntity() {
        if(southDoorEnt == null) {
            southDoorEnt = new Entities(southDoorCoords[0], southDoorCoords[1], southDoorCoords[2], southDoorCoords[3]);
        }
        return southDoorEnt;
    }
    /**
     * This method returns the west door entity
     * @return the west door entity
     */
    public Entities westDoorEntity() {
        if(westDoorEnt == null) {
            westDoorEnt = new Entities(westDoorCoords[0], westDoorCoords[1], westDoorCoords[2], westDoorCoords[3]);
        }
        return westDoorEnt;
    }
    /**
     * This method returns the east door entity
     * @return the east door entity
     */
    public Entities eastDoorEntity() {
        if(eastDoorEnt == null) {
            eastDoorEnt = new Entities(eastDoorCoords[0], eastDoorCoords[1], eastDoorCoords[2], eastDoorCoords[3]);
        }
        return eastDoorEnt;
    }

    /**
     * This method is used to determine the final room
     * @return true if the room is the final room, false otherwise
     */
    public boolean isEnd(){
        if(myRoomType == null){
            return false;
        }
        return myRoomType.equals("FINAL");
    }

    /**
     * This method is used to get the room type.
     * @return the room type
     */
    public String getRoomType(){
        return myRoomType;
    }
    /**
     * This method is used to set the door entities for the room.
     */
    public void setDoors(final String theDoorDirection, final  String thePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Objects.requireNonNull(Maze.class.getResourceAsStream(thePath)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (theDoorDirection) {
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

    /**
     * This method is used to get the background image of the room.
     * @return the background image of the room.
     */
    public BufferedImage getBackground() {
        return background;
    }
}