package Model.MazeGenerator;

import Model.Enemy.EnemyFactory;
import Model.MazeGenerator.Maze.Direction;

import java.util.ArrayList;
import java.util.Stack;

import static Model.MazeGenerator.Maze.Direction.*;


/**
 * This class is used to generate a floor of the maze.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class FloorGenerator {
    /**
     * The width of the floor.
     */
    int myWidth = 10;
    /**
     * The length of the floor.
     */
    int myLength = 10;
    /**
     * The 2D array of rooms that make up the floor.
     */
    Room[][] floor;

    /**
     * This constructor creates a floor of the maze.
     * @param theWidth the width of the floor
     * @param theLength the length of the floor
     */
    public FloorGenerator(final int theWidth, final int theLength) {
        this.myWidth = theWidth;
        this.myLength = theLength;
        floor = new Room[theWidth][theLength];
        createFloor();
    }

    /**
     * This method gets the floor
     * @return The floor.
     */
    public Room[][] getFloor() {
        return floor;
    }

    /**
     * This method creates a floor of the maze.
     */
    private void createFloor() {
        EnemyFactory ef = EnemyFactory.getInstance();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        floor[0][0] = new Room(false, false, false, false);
        floor[0][0].setRoomItems("START");
        for (int i = 0; i < myWidth * myLength; i++) {
            int rand = (int) (Math.random() * 20);

            if (stack.isEmpty()) {
                System.out.println("Something Went Wrong");
            }
            int x = stack.peek()[0];
            int y = stack.peek()[1];
            if (i == (myWidth * myLength - 1)) {
                floor[x][y].setRoomItems("FINAL");
            }
            while (findRandEmptyRoom(stack.peek()[0], stack.peek()[1]) == null) {
                stack.pop();
                if (stack.isEmpty()) return;
            }
            x = stack.peek()[0];
            y = stack.peek()[1];
            switch (findRandEmptyRoom(x, y)) {
                case WEST -> {
                    floor[x][y].openDoor(WEST);
                    floor[--x][y] = new Room(false, false, false, true);
                }
                case EAST -> {
                    floor[x][y].openDoor(EAST);
                    floor[++x][y] = new Room(false, true, false, false);
                }
                case NORTH -> {
                    floor[x][y].openDoor(NORTH);
                    floor[x][--y] = new Room(false, false, true, false);
                }
                case SOUTH -> {
                    floor[x][y].openDoor(SOUTH);
                    floor[x][++y] = new Room(true, false, false, false);
                }
            }
            switch (rand) {
                case 0 -> floor[x][y].setRoomEnemy(EnemyFactory.chosenEnemy(EnemyFactory.Enemy.BOATKEVIN));
                case 1 -> floor[x][y].setRoomEnemy(EnemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA));
                case 2 -> floor[x][y].setRoomEnemy(EnemyFactory.chosenEnemy(EnemyFactory.Enemy.NIKOLAI));
                case 3 -> floor[x][y].setRoomEnemy(EnemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI));
            }
            stack.push(new int[]{x, y});
        }
    }

    /**
     * This method finds a random empty room.
     *
     * @param theX the x coordinate of the room
     * @param theY the y coordinate of the room
     * @return The direction of the empty room.
     */
    private Direction findRandEmptyRoom(final int theX, final int theY) {
        ArrayList<Direction> cardinalRooms = new ArrayList<>();

        if (theX != 0 && floor[theX - 1][theY] == null) {
            cardinalRooms.add(WEST);
        }
        if (theX != floor.length - 1 && floor[theX + 1][theY] == null) {
            cardinalRooms.add(EAST);
        }
        if (theY != 0 && floor[theX][theY - 1] == null) {
            cardinalRooms.add(NORTH);
        }
        if (theY != floor[0].length - 1 && floor[theX][theY + 1] == null) {
            cardinalRooms.add(SOUTH);
        }
        if (cardinalRooms.isEmpty()) {
            return null;
        }
        int rand = (int) ((Math.random() * (cardinalRooms.size())));
        return cardinalRooms.get(rand);
    }
}