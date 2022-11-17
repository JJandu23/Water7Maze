package Model.Enemy;

import SQL.SQLTables;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class EnemyFactory{
    private static EnemyFactory myInstance;
    private static SQLTables myEnemyTable;
    private static String myBoatKevinValues;
    private static String myEliValues;
    private static String myNikolaiValues;
    private static String mySadBoySeaValues;

    private EnemyFactory() {
        try {
            System.out.println("EnemyFactory: EnemyFactory()");
            this.myEnemyTable = new SQLTables();
            this.myBoatKevinValues = this.myEnemyTable.extractBoatKevinData();
        } catch (SQLException e) {
        }
    }
    public static EnemyFactory getInstance() {
        if (myInstance == null) return new EnemyFactory();
        return myInstance;
    }
    public static Enemy chosenEnemy(final char theInput){
        switch (theInput) {
            case '1':
                Enemy newBoatKevin = new BoatKevin();
                setEnemyValues(newBoatKevin, "BK");
                return newBoatKevin;
            default:
                return null;
        }
    }
    public static Enemy setEnemyValues( final Enemy theEnemy, final String theType){
        Enemy temp = theEnemy;
        Scanner valueScan = null;
        switch (theType) {
            case "BK":
                if (myBoatKevinValues != null) {
                    valueScan = new Scanner(myBoatKevinValues);
                    temp.setEnemyValues(valueScan.nextLine(), valueScan.nextInt(), valueScan.nextInt(),
                            valueScan.nextInt(), valueScan.nextInt(), valueScan.nextDouble(),
                            valueScan.nextDouble(), valueScan.nextDouble());
                }else{
                    System.out.println("ur stupid");
                }
            default:
                break;
        }
        return temp;
    }


}
