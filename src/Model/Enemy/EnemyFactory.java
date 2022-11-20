package Model.Enemy;

import SQL.SQLTables;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
/**
 * This class is the factory for the enemies.
 * @author Kevin Nguyen
 */
public class EnemyFactory{
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
     * @throws SQLException if the SQL table is not found.
     */
    private EnemyFactory() {
        try {
            this.myEnemyTable = new SQLTables();
            this.myBoatKevinData = this.myEnemyTable.extractBoatKevinData();
            this.myEliData = this.myEnemyTable.extractEliData();
            this.myNikolaiData = this.myEnemyTable.extractNikolaiData();
            this.mySadBoySeaData = this.myEnemyTable.extractSadBoySeaData();
        } catch (SQLException e) {
        }
    }

    /**
     * Returns the instance of the EnemyFactory class.
     * @return the instance of the EnemyFactory class.
     */
    public static EnemyFactory getInstance() {
        if (myInstance == null) return new EnemyFactory();
        return myInstance;
    }
    /**
     * Selects the chosen enemy.
     * @return the selected enemy.
     */
    public static Enemy chosenEnemy(final char theInput){
        Enemy enemy = null;
        Scanner scan = null;
        switch (theInput) {
            case '1':
                scan = new Scanner(myBoatKevinData);
                enemy = new BoatKevin(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case '2':
                scan = new Scanner(myEliData);
                enemy = new Eli(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case '3':
                scan = new Scanner(myNikolaiData);
                enemy = new Nikolai(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            case '4':
                scan = new Scanner(mySadBoySeaData);
                enemy = new SadBoySea(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return enemy;
            default:
                return null;
        }
    }
    /**
     * Selects a random enemy.
     * @return the selected enemy.
     */
    public static Enemy chooseEnemy(){
        Random rand = new Random();
        int randomNum = rand.nextInt(4) + 1;
        Scanner scan = null;
        switch (randomNum) {
            case 1:
                scan = new Scanner(myBoatKevinData);
                Enemy newBoatKevin = new BoatKevin(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return newBoatKevin;
            case 2:
                scan = new Scanner(myEliData);
                Enemy newEli = new Eli(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return newEli;
            case 3:
                scan = new Scanner(myNikolaiData);
                Enemy newNikolai = new Nikolai(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return newNikolai;
            case 4:
                scan = new Scanner(mySadBoySeaData);
                Enemy newSadBoySea = new SadBoySea(scan.nextLine(), scan.nextInt(), scan.nextInt(),
                        scan.nextInt(), scan.nextInt(), scan.nextDouble(),
                        scan.nextDouble(), scan.nextDouble());
                return newSadBoySea;
            default:
                return null;
        }
    }
}
