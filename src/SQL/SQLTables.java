package SQL;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTables {
    private SQLiteDataSource myEnemyTable;
    private SQLiteDataSource myHeroTable;
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;
    private String myQuery;
    private int myReturnValue;

    /**
     * Constructor for objects of class SQLTables
     * @throws SQLException if there is an error with the SQL construction
     */
    public SQLTables() throws SQLException {
        createEnemyTable();
        fillEnemyTable();
        createHeroTable();
        fillHeroTable();
        createMazeTable();
    }

    private void createEnemyTable(){
        this.myEnemyTable = new SQLiteDataSource();

        this.myQuery = "CREATE TABLE enemyDB (" +
                "NAME NAME TEXT PRIMARY KEY," +
                "HP TEXT NOT NULL," +
                "ATTACKSPEED TEXT NOT NULL," +
                "MINATTACK TEXT NOT NULL," +
                "MAXATTACK TEXT NOT NULL," +
                "HITCHANCE TEXT NOT NULL," +
                "DODGECHANCE TEXT NOT NULL," +
                "SPECIALCHANCE TEXT NOT NULL);";

        try {
            this.myConnection =  myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error creating enemy table");
            System.exit(0);
        }
        System.out.println("Enemy table created successfully!");

    }

    private void createMazeTable(){
        this.myQuery = "CREATE TABLE mazeDB (" +
                "Maze TEXT PRIMARY KEY," +
                ");";
        try{
            this.myConnection =  myHeroTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error creating Maze table");
            System.exit(0);
        }
    }

    private void fillMazeTable(){

    }

    private void fillEnemyTable(){
        this.myQuery = "INSERT INTO enemyDB (NAME, HP, ATTACKSPEED, MINATTACK, MAXATTACK, HITCHANCE, DODGECHANCE, SPECIALCHANCE)VALUES" +
                " ('BoatKevin', '40', '4', '10', '20', '0.80','0.20', '0.05'); +" +
                "('Eli', '100', '11', '20', '30', '0.40','0.20', '0.20'); +" +
                "('Nikolai', '100', '11', '20', '30', '0.40','0.20', '0.20'); +" +
                "('SadBoySea', '40', '4', '10', '20', '0.8','0.2', '0.05');";
        try {
            this.myConnection = myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error filling enemy table");
            System.exit(0);
        }
        System.out.println("Enemy table filled successfully!");
    }
    public String extractBoatKevinData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB 1 OFFSET 0";
        try {
            this.myConnection = myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                result += myResultSet.getString("NAME") + "\n";
                result += myResultSet.getString("HP") + "\n";
                result += myResultSet.getString("ATTACKSPEED") + "\n";
                result += myResultSet.getString("MINATTACK") + "\n";
                result += myResultSet.getString("MAXATTACK") + "\n";
                result += myResultSet.getString("HITCHANCE") + "\n";
                result += myResultSet.getString("DODGECHANCE") + "\n";
                result += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Boat Kevin data");
            System.exit(0);
        }
        return result;
    }
    public String extractEliData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB 1 OFFSET 1";
        try {
            this.myConnection = myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                result += myResultSet.getString("NAME") + "\n";
                result += myResultSet.getString("HP") + "\n";
                result += myResultSet.getString("ATTACKSPEED") + "\n";
                result += myResultSet.getString("MINATTACK") + "\n";
                result += myResultSet.getString("MAXATTACK") + "\n";
                result += myResultSet.getString("HITCHANCE") + "\n";
                result += myResultSet.getString("DODGECHANCE") + "\n";
                result += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Eli data");
            System.exit(0);
        }
        return result;
    }
    public String extractNikolaiData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB 1 OFFSET 2";
        try {
            this.myConnection = myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                result += myResultSet.getString("NAME") + "\n";
                result += myResultSet.getString("HP") + "\n";
                result += myResultSet.getString("ATTACKSPEED") + "\n";
                result += myResultSet.getString("MINATTACK") + "\n";
                result += myResultSet.getString("MAXATTACK") + "\n";
                result += myResultSet.getString("HITCHANCE") + "\n";
                result += myResultSet.getString("DODGECHANCE") + "\n";
                result += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Nikolai data");
            System.exit(0);
        }
        return result;
    }
    public String extractSadBoySeaData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB 1 OFFSET 3";
        try {
            this.myConnection = myEnemyTable.getConnection();
            this.myStatement = myConnection.createStatement();
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                result += myResultSet.getString("NAME") + "\n";
                result += myResultSet.getString("HP") + "\n";
                result += myResultSet.getString("ATTACKSPEED") + "\n";
                result += myResultSet.getString("MINATTACK") + "\n";
                result += myResultSet.getString("MAXATTACK") + "\n";
                result += myResultSet.getString("HITCHANCE") + "\n";
                result += myResultSet.getString("DODGECHANCE") + "\n";
                result += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Sadboysea data");
            System.exit(0);
        }
        return result;
    }

    private void createHeroTable() {
        this.myHeroTable = new SQLiteDataSource();

        this.myQuery = "CREATE TABLE heroDB (" +
                "NAME NAME TEXT PRIMARY KEY," +
                "HP TEXT NOT NULL," +
                "ATTACKSPEED TEXT NOT NULL," +
                "MINATTACK TEXT NOT NULL," +
                "MAXATTACK TEXT NOT NULL," +
                "HITCHANCE TEXT NOT NULL," +
                "DODGECHANCE TEXT NOT NULL," +
                "SPECIALCHANCE TEXT NOT NULL," +
                "MOVESPEED TEXT NOT NULL);";
        try{
            this.myConnection = myHeroTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error creating hero table");
            System.exit(0);
        }
    }

    private void fillHeroTable() {
        this.myQuery = "INSERT INTO heroDB (NAME, HP, ATTACKSPEED, MINATTACK, MAXATTACK, HITCHANCE, DODGECHANCE, SPECIALCHANCE, MOVESPEED)VALUES" +
                " ('Luffy', '120', '10', '15', '25', '0.80','0.20', '0.20', '4'); +" +
                "('Nami', '90', '10', '10', '20', '0.50','0.40', '0.20', '3'); +" +
                "('Chopper', '100', '10', '10', '20', '0.50','0.30', '0.20', '3'); +" +
                "('Zoro', '110', '8', '15', '25', '0.60','0.20', '0.40', '4');";
        try {
            this.myConnection = myHeroTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error filling hero table");
            System.exit(0);
        }
        System.out.println("Hero table filled successfully!");
    }
}
