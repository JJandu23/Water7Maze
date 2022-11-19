package Model.MazeGenerator;

import java.util.Objects;

public class Room {
    private boolean myDoorNorth;
    private boolean myDoorSouth;
    private boolean myDoorEast;
    private boolean myDoorWest;
    private String myRoomItems;

    public Room(boolean doorNorth, boolean doorWest, boolean doorSouth, boolean doorEast) {
        this.myDoorNorth = doorNorth;
        this.myDoorSouth = doorSouth;
        this.myDoorWest = doorWest;
        this.myDoorEast = doorEast;
    }

    public void setRoomItems(String roomItems) {
        myRoomItems = roomItems;
    }

    public void openDoor(String direction) {
        switch (direction) {
            case "North" -> myDoorNorth = true;
            case "South" -> myDoorSouth = true;
            case "West" -> myDoorWest = true;
            case "East" -> myDoorEast = true;
        }
    }

    @Override
    public String toString() {

        String str = "";
        str += "(";
        if (myRoomItems != null && myRoomItems.equals("START")) {
            str += "...";
        }

        if (myDoorNorth) str += " north ";
        if (myDoorWest) str += " west ";
        if (myDoorSouth) str += " south ";
        if (myDoorEast) str += " east ";

        if (myRoomItems != null && myRoomItems.equals("FINAL")) {
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
}