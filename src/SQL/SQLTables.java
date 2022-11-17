package SQL;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTables {
    private SQLiteDataSource myEnemyTable;
    private Connection myConnection;
    private Statement myStatement;
    private String myQuery;
    private int myReturnValue;
    private ResultSet myResultSet;


    public SQLTables() throws SQLException {
        System.out.println("SQLTables constructor called");
        createEnemyTable();
        fillEnemyTable();
    }

    private void createEnemyTable() {
        this.myEnemyTable = new SQLiteDataSource();

        this.myQuery = "CREATE TABLE IF NOT EXISTS enemyDB (" +
                "NAME TEXT NOT NULL," +
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

    private void fillEnemyTable() {

        this.myQuery = "INSERT INTO enemyDB " +
                "('NAME','HP','ATTACKSPEED','MINATTACK','MAXATTACK','HITCHANCE','DODGECHANCE','SPECIALCHANCE') VALUES" +
                "('Boat Kevin', '40', '4', '10', '20', '0.80','0.20', '0.05')," +
                "('Eli', '100', '11', '20', '30', '0.40','0.20', '0.20')," +
                "('Nikolai', '100', '11', '20', '30', '0.40','0.20', '0.20')," +
                "('SadBoySea', '40', '4', '10', '20', '0.8','0.2', '0.05');";

        try {
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error filling values into enemy table");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Values filled into enemy table successfully!");
    }

    public String extractBoatKevinData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 0";
        try {
            this.myResultSet = this.myStatement.executeQuery(this.myQuery);
            while (this.myResultSet.next()) {
                result += this.myResultSet.getString("NAME") + "\n";
                result += this.myResultSet.getString("HP") + "\n";
                result += this.myResultSet.getString("ATTACKSPEED") + "\n";
                result += this.myResultSet.getString("MINATTACK") + "\n";
                result += this.myResultSet.getString("MAXATTACK") + "\n";
                result += this.myResultSet.getString("HITCHANCE") + "\n";
                result += this.myResultSet.getString("DODGECHANCE") + "\n";
                result += this.myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Boat Kevin data");
            System.exit(0);
        }
        return result;
    }

    public String extractEliData(){
        String result = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 1";
        try {
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
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 2";
        try {
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
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 3";
        try {
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
            System.out.println("Error extracting SadBoySea data");
            System.exit(0);
        }
        return result;
    }
}
