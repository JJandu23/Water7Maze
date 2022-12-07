package Model.MazeGenerator;

import Model.Enemy.EnemyFactory;
import Model.MazeCharacter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;
import Model.MazeGenerator.Maze.Direction;

import static Model.MazeGenerator.Maze.Direction.*;


/**
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class FloorGenerator {
    int myWidth = 10;
    int myLength = 10;
    Room[][] floor;

    public FloorGenerator(int theWidth, int theLength) {
        this.myWidth = theWidth;
        this.myLength = theLength;
        floor = new Room[theWidth][theLength];
        createFloor();
    }

    public Room[][] getFloor() {
        return floor;
    }

    private void createFloor() {
        EnemyFactory ef = EnemyFactory.getInstance();






        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        floor[0][0] = new Room(false, false, false, false);
        floor[0][0].setRoomItems("START");
        for (int i = 0; i < myWidth * myLength; i++) {
            int rand  = (int) (Math.random()*20);

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

    private Direction findRandEmptyRoom(int x, int y) {
        ArrayList<Direction> cardinalRooms = new ArrayList<>();

        if (x != 0 && floor[x - 1][y] == null) {
            cardinalRooms.add(WEST);
        }
        if (x != floor.length - 1 && floor[x + 1][y] == null) {
            cardinalRooms.add(EAST);
        }
        if (y != 0 && floor[x][y - 1] == null) {
            cardinalRooms.add(NORTH);
        }
        if (y != floor[0].length - 1 && floor[x][y + 1] == null) {
            cardinalRooms.add(SOUTH);
        }
        if (cardinalRooms.isEmpty()) {
            return null;
        }
        int rand = (int) ((Math.random() * (cardinalRooms.size())));
        return cardinalRooms.get(rand);
    }
}

