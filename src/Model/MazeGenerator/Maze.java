package Model.MazeGenerator;

import Model.Entities;
import Model.Hero.Hero;
import View.Ending;
import View.GameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;


/**
 * This class is used to generate a maze for the game.
 * It uses a recursive backtracking algorithm to generate a maze.
 * The maze is stored as a 2D array of Rooms.
 * Each Room has 4 doors, one for each cardinal direction.
 * The doors are either open or closed.
 * The maze is generated by starting at a random room and randomly opening doors until
 * all rooms have been visited.
 * The maze is then solved by starting at the start room and recursively opening doors
 * until the end room is reached.
 * The maze is then printed to the console.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Maze {
    /**
     * The maze's 2D array of rooms.
     */
    static Room[][][] myMaze;
    /**
     * The current floor.
     */
    private static int myCurrentFloor = 0;
    /**
     * The current room.
     */
    private static int[] myCurrentRoom = new int[]{0, 0};
    /**
     * HashMap of entities in a room
     */
    private static HashMap<String, Entities> myEntityList = new HashMap<>();
    /**
     * The ending room of the maze.
     */
    private static int[] myCurrentEndRoom = new int[2];
    /**
     * The coordinates of the enemy in the maze.
     */
    private static int[] enemyCoords = {300, 300, 500, 500};
    /**
     * Text for the key in the maze.
     */
    private static BufferedImage keytext;

    static {

        try {
            keytext = ImageIO.read(Ending.class.getResourceAsStream("../View/Sprites/gotkey.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This constructor creates a maze.
     *
     * @param theNumOfFloors the number of floors in the maze
     * @param theRoomWidth   the width of each room
     * @param theRoomLength  the length of each room
     */
    public Maze(final int theNumOfFloors, final int theRoomWidth, final int theRoomLength) {

        myMaze = new Room[theNumOfFloors][theRoomWidth][theRoomLength];
        fillMaze(theNumOfFloors, theRoomWidth, theRoomLength);
        createRoom();
        findEndRoom();
    }

    /**
     * This method creates the mini map.
     */
    public static void drawMiniMap(final Graphics2D theG) {
        int mazeX = 900;
        int mazeY = 50;
        int scale = 20;
        theG.setColor(Color.black);
        theG.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.5f));
        theG.fillRect(mazeX, mazeY, scale * myMaze[0].length, scale * myMaze[0].length);
        theG.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1.0f));
        theG.setColor(Color.green);
        theG.fillRect(mazeX , mazeY , scale, scale);



        theG.setColor(Color.CYAN);
        theG.fillRect(mazeX + myCurrentRoom[0] * scale, mazeY + myCurrentRoom[1] * scale, scale, scale);




        theG.setStroke(new BasicStroke(2));
        for (int i = 0; i < myMaze[myCurrentFloor].length; i++) {
            for (int j = 0; j < myMaze[myCurrentFloor][i].length; j++) {



                if(Hero.isNoClip() && myMaze[myCurrentFloor][j][i].getEnemy() != null){
                    theG.setColor(Color.red);
                    theG.fillRect(mazeX + j * scale, mazeY + i * scale, scale, scale);
                }

                if(myMaze[myCurrentFloor][j][i].hasKey()){
                    theG.setColor(Color.yellow);
                    theG.fillRect(mazeX + 3 + j * scale, mazeY +3 + i * scale, scale-6, scale-6);
                }

                theG.setColor(Color.lightGray);
                if (!myMaze[myCurrentFloor][j][i].isMyDoorNorth()) {
                    theG.drawLine(mazeX + j * scale, mazeY + i * scale, mazeX + j * scale + scale, mazeY + i * scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorSouth()) {
                    theG.drawLine(mazeX + j * scale, mazeY + i * scale + scale, mazeX + j * scale + scale, mazeY + i * scale + scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorEast()) {
                    theG.drawLine(mazeX + j * scale + scale, mazeY + i * scale, mazeX + j * scale + scale, mazeY + i * scale + scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorWest()) {
                    theG.drawLine(mazeX + j * scale, mazeY + i * scale, mazeX + j * scale, mazeY + i * scale + scale);
                }
            }
        }

        theG.setColor(Color.ORANGE);
        theG.fillRect(mazeX + myCurrentEndRoom[0] * scale, mazeY + myCurrentEndRoom[1] * scale, scale, scale);
    }

    /**
     * This method draws the room
     *
     * @param graphics2D the graphics object
     */
    public static void drawRoom(final Graphics2D graphics2D) {
        if (myCurrentRoom[0] < 0 || myCurrentRoom[1] < 0 || myCurrentRoom[1] > 9 || myCurrentRoom[0] > 9) {
            if (myCurrentRoom[0] < 0) {
                myCurrentRoom[0]++;
            } else if (myCurrentRoom[0] > 9) {
                myCurrentRoom[0]--;
            } else if (myCurrentRoom[1] < 0) {
                myCurrentRoom[1]++;
            } else if (myCurrentRoom[1] > 9) {
                myCurrentRoom[1]--;
            }
        }
        Room theRoom = myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]];
        int tilesize = 400;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                graphics2D.drawImage(theRoom.getBackground(), j * tilesize, i * tilesize, tilesize, tilesize, null);

            }
        }

        if (!theRoom.isMyDoorNorth()) {
            theRoom.northDoorEntity().draw(graphics2D);
        }
        if (!theRoom.isMyDoorSouth()) {
            theRoom.southDoorEntity().draw(graphics2D);
        }
        if (!theRoom.isMyDoorEast()) {
            theRoom.eastDoorEntity().draw(graphics2D);
        }
        if (!theRoom.isMyDoorWest()) {
            theRoom.westDoorEntity().draw(graphics2D);
        }
        if (myEntityList.get("enemy") != null) {
            myEntityList.get("enemy").draw(graphics2D);
        }

        if(myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]].hasKey()){
            graphics2D.setColor(Color.yellow);
            graphics2D.fillRect(400, 300, 100, 100);
        }
        if(theRoom.hasKey()){
            System.out.println("draw key text");
            graphics2D.drawImage(keytext, 0,600, GameView.getScreenWidth(), 200, null);
        }

    }

    /**
     * This method adds an entity to the maze.
     */
    public static void addEntity(final String theName, final Entities theEntity, final int theRoomX, final int theRoomY) {
        theEntity.setRoomLocation(theRoomX, theRoomY);
        myEntityList.put(theName, theEntity);
    }

    /**
     * This method creates the room.
     */
    public static void createRoom() {
        Room theRoom = myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]];

        if (theRoom.getEnemy() != null) {
            String name = theRoom.getEnemy().getName();
            Entities theEnemy = new Entities(enemyCoords[0], enemyCoords[1], enemyCoords[2], enemyCoords[3]);
            String path = "../../View/Sprites/EnemySprites/" + name + ".png";

            BufferedImage img = null;
            System.out.println(name);
            try {
                img = ImageIO.read(Maze.class.getResourceAsStream(path));

            } catch (IOException e) {
                e.printStackTrace();
            }

            theEnemy.setSprite(img);
            addEntity("enemy", theEnemy, myCurrentRoom[0], myCurrentRoom[1]);

        } else {
            myEntityList.remove("enemy");
        }

        if (!theRoom.isMyDoorNorth()) {
            theRoom.setDoors("North", "../../View/Sprites/northwall.png");
            Entities northDoor = theRoom.northDoorEntity();

            addEntity("NorthDoor", northDoor, myCurrentRoom[0], myCurrentRoom[1]);

        } else {
            myEntityList.remove("NorthDoor");
        }
        if (!theRoom.isMyDoorSouth()) {
            theRoom.setDoors("South", "../../View/Sprites/southwall.png");
            Entities southDoor = theRoom.southDoorEntity();

            addEntity("SouthDoor", southDoor, myCurrentRoom[0], myCurrentRoom[1]);
        } else {
            myEntityList.remove("SouthDoor");
        }
        if (!theRoom.isMyDoorEast()) {
            theRoom.setDoors("East", "../../View/Sprites/eastwall.png");
            Entities eastDoor = theRoom.eastDoorEntity();

            addEntity("EastDoor", eastDoor, myCurrentRoom[0], myCurrentRoom[1]);
        } else {
            myEntityList.remove("EastDoor");
        }
        if (!theRoom.isMyDoorWest()) {
            theRoom.setDoors("West", "../../View/Sprites/westwall.png");
            Entities westDoor = theRoom.westDoorEntity();

            addEntity("WestDoor", westDoor, myCurrentRoom[0], myCurrentRoom[1]);
        } else {
            myEntityList.remove("WestDoor");
        }
    }

    /**
     * This method changes the room.
     */
    public static void switchRoom(final Direction theDirection) {

        switch (theDirection) {
            case NORTH -> {
                myCurrentRoom[1]--;
                if (myCurrentRoom[1] < 0) {
                    myCurrentRoom[1]++;
                    System.out.println("You can't go that way");
                } else {
                    System.out.println("Went North");
                }
            }
            case SOUTH -> {
                myCurrentRoom[1]++;
                if (myCurrentRoom[1] > 9) {
                    myCurrentRoom[1]--;
                    System.out.println("You can't go that way");
                } else {
                    System.out.println("Went South");
                }
            }
            case WEST -> {
                myCurrentRoom[0]--;
                if (myCurrentRoom[0] < 0) {
                    myCurrentRoom[0]++;
                    System.out.println("You can't go that way");
                } else {
                    System.out.println("Went West");
                }
            }
            case EAST -> {
                System.out.println("Went East");
                myCurrentRoom[0]++;
                if (myCurrentRoom[0] > 9) {
                    myCurrentRoom[0]--;
                    System.out.println("You can't go that way");
                } else {
                    System.out.println("Went East");
                }
            }
        }
        System.out.println("My Room: " + myCurrentRoom[0] + " - " + myCurrentRoom[1]);
        createRoom();
    }

    /**
     * This method gets the entity list.
     *
     * @return the entity list.
     */
    public static HashMap<String, Entities> getEntityList() {
        return myEntityList;
    }

    /**
     * This method gets the maze.
     *
     * @param theNumOfFloors the number of floors in the maze
     * @param theRoomWidth   the width of each room
     * @param theRoomLength  the length of each room
     */
    public void fillMaze(final int theNumOfFloors, final int theRoomWidth, final int theRoomLength) {
        for (int i = 0; i < theNumOfFloors; i++) {

            myMaze[i] = new FloorGenerator(theRoomWidth, theRoomLength).getFloor();
        }

    }

    /**
     * This method gets the current floor.
     *
     * @param theFloorNum the floor number
     * @return the current floor
     */
    public Room[][] getFloor(final int theFloorNum) {
        return myMaze[theFloorNum - 1];
    }

    /**
     * This method gets the current room.
     *
     * @return the current room
     */
    public static Room getCurrentRoom() {
        return myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]];
    }

    /**
     * This method removes an enemy entity from the maze.
     */
    public static void killEnemy() {
        myEntityList.remove("enemy");
    }

    /**
     * This method finds the end room
     */
    public static void findEndRoom() {
        for (int i = 0; i < myMaze[myCurrentFloor].length; i++) {
            for (int j = 0; j < myMaze[myCurrentFloor][i].length; j++) {
                if (myMaze[myCurrentFloor][i][j].isEnd()) {
                    myCurrentEndRoom[0] = i;
                    myCurrentEndRoom[1] = j;
                }
            }
        }
    }

    /**
     * Checks if the has ended
     *
     * @return true if the game has ended
     */
    public static boolean isFinished() {

        for (int i = 0; i < myMaze[myCurrentFloor].length; i++) {
            for (int j = 0; j < myMaze[myCurrentFloor][i].length; j++) {
                if (myMaze[myCurrentFloor][i][j].hasKey()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * The enum for the direction.
     *
     * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
     * @version 1.0
     */
    public enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
}
