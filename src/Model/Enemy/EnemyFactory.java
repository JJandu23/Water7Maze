package Model.Enemy;

import Model.MazeCharacter;
import SQL.SQLTables;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class is used to create the enemy.
 * @author Kevin Nguyen, Jashanpreet Jandu, Nicholas Zhuk
 * @version 1.0
 */
public class EnemyFactory {

    /**
     * The instance of the enemy factory.
     */
    private static EnemyFactory myInstance;

    /**
     * the SQL table for the enemies.
     */
    private static SQLTables myEnemyTable;

    /**
     * String of Boat Kevin data
     */
    private static String myBoatKevinData;

    /**
     * String of Eli data
     */
    private static String myEliData;

    /**
     * String of Nikolai data
     */
    private static String myNikolaiData;

    /**
     * String of the boss data
     */
    private static String mySadBoySeaData;
    /**
     * Constructor for the EnemyFactory class.
     *
     * @throws SQLException if the SQL table is not found.
     */
    protected EnemyFactory() {
        try {
            myEnemyTable = new SQLTables();
            myBoatKevinData = myEnemyTable.extractBoatKevinData();
            myEliData = myEnemyTable.extractEliData();
            myNikolaiData = myEnemyTable.extractNikolaiData();
            mySadBoySeaData = myEnemyTable.extractSadBoySeaData();
        } catch (SQLException e) {
        }
    }

    /**
     * Returns the instance of the EnemyFactory class.
     *
     * @return the instance of the EnemyFactory class.
     */
    public static EnemyFactory getInstance() {
        if (myInstance == null){
            myInstance = new EnemyFactory();
        }
        return myInstance;
    }

    /**
     * Selects the chosen enemy from the database.
     *
     * @return the selected enemy.
     */
    public static MazeCharacter chosenEnemy(final Enemy theEnemy) {
        MazeCharacter enemy = null;
        Scanner scan = null;
        switch (theEnemy) {
            case BOATKEVIN:
                scan = new Scanner(myBoatKevinData);
                enemy = new BoatKevin(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case ELI:
                scan = new Scanner(myEliData);
                enemy = new Eli(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case NIKOLAI:
                scan = new Scanner(myNikolaiData);
                enemy = new Nikolai(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case SADBOYSEA:
                scan = new Scanner(mySadBoySeaData);
                enemy = new SadBoySea(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            default:
                return null;
        }
    }

    public enum Enemy {
        // Enum for the enemies
        BOATKEVIN, ELI, NIKOLAI, SADBOYSEA
    }
}