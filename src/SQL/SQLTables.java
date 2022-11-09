package SQL;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
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

    }

    private void createHeroTable() {
        this.myHeroTable = new SQLiteDataSource();

        this.myQuery = "CREATE TABLE heroDB (" +
                "NAME NAME TEXT PRIMARY KEY," +
                "HP TEXT NOT NULL," +
                "MAXHP TEXT NOT NULL," +
                "ATTACKSPEED TEXT NOT NULL," +
                "MINATTACK TEXT NOT NULL," +
                "MAXATTACK TEXT NOT NULL," +
                "HITCHANCE TEXT NOT NULL," +
                "DODGECHANCE TEXT NOT NULL," +
                "SPECIALCHANCE TEXT NOT NULL," +
                "SENZUBEAN TEXT NOT NULL);";
        try{
            this.myConnection =  myHeroTable.getConnection();
            this.myStatement = myConnection.createStatement();
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error creating hero table");
            System.exit(0);
        }
    }

    private void fillHeroTable(){

    }
}
