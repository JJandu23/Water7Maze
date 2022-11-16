package Model.MazeGenerator;

import javax.swing.*;

public class FloorGenerator extends JPanel {
    int width = 10;
    int height = 10;
    int[][] floor;

    public FloorGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        floor = new int[width][height];
    }

    public void printFloor() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(floor[i][j]);
            }
            System.out.println();
        }
    }
}
