package Model.MazeGenerator;

import Model.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Maze {
    static Room[][][] myMaze;
    private static int myCurrentFloor = 0;
    private static List<Entities> myEntityList = new ArrayList<>();


    public Maze(int theNumOfFloors, int theRoomWidth, int theRoomLength) {


        //TEST ENTITY DELETE LATER
        Entities entity = new Entities(200,200,300,300);
        addEntity(entity,0,0);
        try {
            entity.setSprite(ImageIO.read(Maze.class.getResourceAsStream("../../View/Sprites/unknown.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        ///^^^ DELETE LATER

        myMaze = new Room[theNumOfFloors][theRoomWidth][theRoomLength];
        fillMaze(theNumOfFloors, theRoomWidth, theRoomLength);
    }

    public void fillMaze(int theNumOfFloors, int theRoomWidth, int theRoomLength) {
        for (int i = 0; i < theNumOfFloors; i++) {
            myMaze[i] = new FloorGenerator(theRoomWidth, theRoomLength).getFloor();
        }
    }

    public Room[][] getFloor(int theFloorNum) {
        return myMaze[theFloorNum - 1];
    }

    public void goDownFloors() {
        myCurrentFloor++;
    }

    public static void drawMiniMap(Graphics2D g) {
        int mazeX = 900;
        int mazeY = 50;
        int scale = 20;
        g.setStroke(new BasicStroke(2));
        for (int i = 0; i < myMaze[myCurrentFloor].length; i++) {
            for (int j = 0; j < myMaze[myCurrentFloor][i].length; j++) {

                if (!myMaze[myCurrentFloor][j][i].isMyDoorNorth()) {
                    g.drawLine(mazeX + j * scale, mazeY + i * scale, mazeX + j * scale + scale, mazeY + i * scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorSouth()) {
                    g.drawLine(mazeX + j * scale, mazeY + i * scale + scale, mazeX + j * scale + scale, mazeY + i * scale + scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorEast()) {
                    g.drawLine(mazeX + j * scale + scale, mazeY + i * scale, mazeX + j * scale + scale, mazeY + i * scale + scale);
                }
                if (!myMaze[myCurrentFloor][j][i].isMyDoorWest()) {
                    g.drawLine(mazeX + j * scale, mazeY + i * scale, mazeX + j * scale, mazeY + i * scale + scale);
                }
            }
        }
    }
    public static void drawMaze(Graphics2D g) {

        myEntityList.get(0).draw(g);



    }

    public static void addEntity(Entities entity, int RoomX, int RoomY){
        entity.setRoomLocation(RoomX, RoomY);
        myEntityList.add(entity);
    }

    public static List<Entities> getEntityList(){
        return myEntityList;
    }




}
