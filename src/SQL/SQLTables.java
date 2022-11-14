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
