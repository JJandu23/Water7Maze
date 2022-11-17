package Model.MazeGenerator;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class Maze {

    Room[][][] myMaze;

    public Maze(int theNumOfFloors, int theRoomWidth, int theRoomLength){
        myMaze = new Room[theNumOfFloors][theRoomWidth][theRoomLength];
        fillMaze(theNumOfFloors, theRoomWidth, theRoomLength);


    }
    public void fillMaze(int theNumOfFloors, int theRoomWidth, int theRoomLength){
        for (int i = 0; i < theNumOfFloors; i++) {
            myMaze[i] = new FloorGenerator(theRoomWidth, theRoomLength).getFloor();
        }
    }

    public Room[][] getFloor(int theFloorNum){
        return myMaze[theFloorNum-1];
    }


}
