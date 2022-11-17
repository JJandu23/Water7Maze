package Model.MazeGenerator;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class Maze {

    Room[][][] myMaze;
    private int myCurrentFloor = 0;

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
    public void goDownFloors(){
        myCurrentFloor++;
    }

    public void draw(Graphics2D g){
        int mazeX = 150;
        int mazeY = 150;
        int scale = 40;
        g.setStroke(new BasicStroke(10));
        for (int i = 0; i < myMaze[myCurrentFloor].length; i++) {
            for (int j = 0; j < myMaze[myCurrentFloor][i].length; j++) {

                if(!myMaze[myCurrentFloor][j][i].isMyDoorNorth()){
                    g.drawLine(mazeX+j*scale, mazeY+i*scale, mazeX+j*scale+scale, mazeY+i*scale);
                }
                if(!myMaze[myCurrentFloor][j][i].isMyDoorSouth()){
                    g.drawLine(mazeX+j*scale, mazeY+i*scale+scale, mazeX+j*scale+scale, mazeY+i*scale+scale);
                }
                if(!myMaze[myCurrentFloor][j][i].isMyDoorEast()){
                    g.drawLine(mazeX+j*scale+scale, mazeY+i*scale, mazeX+j*scale+scale,  mazeY+i*scale+scale);
                }
                if(!myMaze[myCurrentFloor][j][i].isMyDoorWest()){
                    g.drawLine(mazeX+j*scale, mazeY+i*scale, mazeX+j*scale, mazeY+i*scale+scale);
                }


            }

        }
    }


}
