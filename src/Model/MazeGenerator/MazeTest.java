package Model.MazeGenerator;

/**
 * This class is used to test the maze.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class MazeTest {
    /**
     * This method is used to test the maze.
     *
     * @param theArgs The arguments.
     */
    public static void main(final String[] theArgs) {
        Maze maze = new Maze(1, 3, 3);
        Room[][] currFloor = maze.getFloor(1);
        for (int i = 0; i < currFloor.length; i++) {
            for (int j = 0; j < currFloor[i].length; j++) {
                System.out.print(currFloor[j][i]);
            }
            System.out.println("");
        }
    }
}
