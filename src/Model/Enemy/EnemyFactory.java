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
            this.myEnemyTable = new SQLTables();
            this.myBoatKevinValues = this.myEnemyTable.extractBoatKevinData();
            this.myEliValues = this.myEnemyTable.extractEliData();
            this.myNikolaiValues = this.myEnemyTable.extractNikolaiData();
            this.mySadBoySeaValues = this.myEnemyTable.extractSadBoySeaData();
        } catch (SQLException e) {
        }
    }
    public static Enemy chosenEnemy(final char theInput){
        switch (theInput) {
            case '1':
                Enemy newBoatKevin = new BoatKevin();
                setEnemyValues(newBoatKevin, "BoatKevin");
            case '2':
                Enemy newEli = new Eli();
                setEnemyValues(newEli, "Eli");
            case '3':
                Enemy newNikolai = new Nikolai();
                setEnemyValues(newNikolai, "Nikolai");
                return newNikolai;
            case '4':
                Enemy newSadBoySea = new SadBoySea();
                setEnemyValues(newSadBoySea, "SadBoySea");
                return newSadBoySea;
            default:
                return null;
        }
    }
    public static Enemy createEnemy(){
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        if(randomNum == 0){
            Enemy newBoatKevin = new BoatKevin();
            return newBoatKevin;
        } else if(randomNum == 1){
            Enemy newEli = new Eli();
            setEnemyValues(newEli, "Eli");
            return newEli;
        } else if(randomNum == 2){
            Enemy newNikolai = new Nikolai();
            setEnemyValues(newNikolai, "Nikolai");
            return newNikolai;
        } else {
            Enemy newSadBoySea = new SadBoySea();
            setEnemyValues(newSadBoySea, "SadBoySea");
            return newSadBoySea;
        }
    }
    public static Enemy setEnemyValues(final Enemy theEnemy, final String theType){
        Enemy newEnemy = theEnemy;
        Scanner stats = null;
        switch (theType) {
            case "BoatKevin":
                stats = new Scanner(myBoatKevinValues);
                //newEnemy.setEnemyStats();
                break;
            case "Eli":
                stats = new Scanner(myEliValues);
                break;
            case "Nikolai":
                stats = new Scanner(myNikolaiValues);
                break;
            case "SadBoySea":
                stats = new Scanner(mySadBoySeaValues);
                break;
            default:
                break;
        }
        return newEnemy;
    }

}
