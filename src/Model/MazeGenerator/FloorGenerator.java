package Model.MazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

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
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        floor[0][0] = new Room(false, false, false, false);
        floor[0][0].setRoomItems("START");
        for (int i = 0; i < myWidth * myLength; i++) {
            if (stack.isEmpty()) {
                System.out.println("Something Went Wrong");
            }
            int x = stack.peek()[0];
            int y = stack.peek()[1];
            if (i == (myWidth * myLength - 1)) {
                floor[x][y].setRoomItems("FINAL");
            }
            while (findRandEmptyRoom(stack.peek()[0], stack.peek()[1]).equals("None")) {
                stack.pop();
                if (stack.isEmpty()) return;
            }
            x = stack.peek()[0];
            y = stack.peek()[1];
            switch (findRandEmptyRoom(x, y)) {
                case "West" -> {
                    floor[x][y].openDoor("West");
                    floor[--x][y] = new Room(false, false, false, true);
                }
                case "East" -> {
                    floor[x][y].openDoor("East");
                    floor[++x][y] = new Room(false, true, false, false);
                }
                case "North" -> {
                    floor[x][y].openDoor("North");
                    floor[x][--y] = new Room(false, false, true, false);
                }
                case "South" -> {
                    floor[x][y].openDoor("South");
                    floor[x][++y] = new Room(true, false, false, false);
                }
            }
            stack.push(new int[]{x, y});
        }
    }

    private String findRandEmptyRoom(int x, int y) {
        ArrayList<String> cardinalRooms = new ArrayList<>();

        if (x != 0 && floor[x - 1][y] == null) {
            cardinalRooms.add("West");
        }
        if (x != floor.length - 1 && floor[x + 1][y] == null) {
            cardinalRooms.add("East");
        }
        if (y != 0 && floor[x][y - 1] == null) {
            cardinalRooms.add("North");
        }
        if (y != floor[0].length - 1 && floor[x][y + 1] == null) {
            cardinalRooms.add("South");
        }
        if (cardinalRooms.isEmpty()) {
            return "None";
        }
        int rand = (int) ((Math.random() * (cardinalRooms.size())));
        return cardinalRooms.get(rand);
    }
}

