package Model.MazeGenerator;

import Model.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Maze {
    static Room[][][] myMaze;
    private static int myCurrentFloor = 0;
    private static int[] myCurrentRoom = new int[]{0,0};
    private static HashMap<String, Entities> myEntityList = new HashMap<>();




    public Maze(int theNumOfFloors, int theRoomWidth, int theRoomLength) {


        //TEST ENTITY DELETE LATER
        /*Entities entity = new Entities(300,300,400,500);
        addEntity(entity,0,0);
        try {
            entity.setSprite(ImageIO.read(Maze.class.getResourceAsStream("../../View/Sprites/unknown.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ///^^^ DELETE LATER

        myMaze = new Room[theNumOfFloors][theRoomWidth][theRoomLength];
        fillMaze(theNumOfFloors, theRoomWidth, theRoomLength);
        createRoom();
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
        g.setColor(Color.black);
        g.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.5f));
        g.fillRect(mazeX,mazeY,scale*myMaze[0].length, scale*myMaze[0].length);
        g.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1.0f));
        g.setColor(Color.red);
        g.fillRect(mazeX+myCurrentRoom[0]*scale,mazeY+myCurrentRoom[1]*scale,scale,scale);
        g.setColor(Color.lightGray);
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


    public static void drawRoom(Graphics2D g){

        if(myCurrentRoom[0] < 0 || myCurrentRoom[1] < 0 || myCurrentRoom[1] > 9 || myCurrentRoom[0] > 9){
            System.out.println("Something wrong");
        }
        Room theRoom = myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]];
        g.setColor(theRoom.getBackground());
        g.fillRect(-50,-50,2000,2000);
        g.setColor(Color.lightGray);
        if(!theRoom.isMyDoorNorth()){
            theRoom.northDoorEntity().draw(g);
        }
        if(!theRoom.isMyDoorSouth()){
            theRoom.southDoorEntity().draw(g);
        }
        if(!theRoom.isMyDoorEast()){
            theRoom.eastDoorEntity().draw(g);

        }
        if(!theRoom.isMyDoorWest()){
            theRoom.westDoorEntity().draw(g);
        }
    }

    public static void addEntity(String name, Entities entity, int RoomX, int RoomY){
        entity.setRoomLocation(RoomX, RoomY);
        myEntityList.put(name, entity);
    }


    public static void createRoom(){

        Room theRoom = myMaze[myCurrentFloor][myCurrentRoom[0]][myCurrentRoom[1]];
        if(!theRoom.isMyDoorNorth()){
            theRoom.setDoors("North","../../View/Sprites/unknown.png");
            Entities northDoor = theRoom.northDoorEntity();

            addEntity("NorthDoor", northDoor,myCurrentRoom[0],myCurrentRoom[1]);

        } else{
            myEntityList.remove("NorthDoor");
        }
        if(!theRoom.isMyDoorSouth()){
            theRoom.setDoors("South","../../View/Sprites/unknown.png");
            Entities southDoor = theRoom.southDoorEntity();

            addEntity("SouthDoor", southDoor,myCurrentRoom[0],myCurrentRoom[1]);
        } else{
            myEntityList.remove("SouthDoor");
        }
        if(!theRoom.isMyDoorEast()){
            theRoom.setDoors("East","../../View/Sprites/unknown.png");
            Entities eastDoor = theRoom.eastDoorEntity();

            addEntity("EastDoor", eastDoor,myCurrentRoom[0],myCurrentRoom[1]);
        } else{
            myEntityList.remove("EastDoor");
        }
        if(!theRoom.isMyDoorWest()){
            theRoom.setDoors("West","../../View/Sprites/unknown.png");
            Entities westDoor = theRoom.westDoorEntity();

            addEntity("WestDoor", westDoor,myCurrentRoom[0],myCurrentRoom[1]);
        } else{
            myEntityList.remove("WestDoor");
        }



    }

    public static void switchRoom(String direction){

        switch(direction){
            case "North":
                myCurrentRoom[1]--;
                System.out.println("Went North");
                break;

            case "South":
                myCurrentRoom[1]++;
                System.out.println("Went South");
                break;

            case "West":
                myCurrentRoom[0]--;
                System.out.println("Went West");
                break;

            case "East":
                System.out.println("Went East");
                myCurrentRoom[0]++;
                break;

        }
        System.out.println("My Room: "+ myCurrentRoom[0] +" - " + myCurrentRoom[1]);
        createRoom();
    }

    public static HashMap<String, Entities> getEntityList(){
        return myEntityList;
    }




}
