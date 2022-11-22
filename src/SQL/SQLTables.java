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
            this.myConnection = myEnemyTable.getConnection();
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
                "('Boat Kevin', '40', '13', '10', '20', '0.80','0.20', '0.05')," +
                "('Eli', '90', '12', '15', '20', '0.40','0.20', '0.20')," +
                "('Nikolai', '110', '11', '20', '30', '0.40','0.20', '0.25')," +
                "('SadBoySea', '300', '12', '10', '20', '0.8','0.2', '0.10');";

        try {
            myReturnValue = myStatement.executeUpdate(myQuery);
            System.out.println("executeUpdate() returned " + myReturnValue);
        } catch (SQLException e) {
            System.out.println("Error filling values into enemy table");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Values filled into enemy table successfully!" + "\n");
    }

    public String extractBoatKevinData() {
        String Data = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 0";
        try {
            this.myResultSet = this.myStatement.executeQuery(this.myQuery);
            while (this.myResultSet.next()) {
                Data += this.myResultSet.getString("NAME") + "\n";
                Data += this.myResultSet.getString("HP") + "\n";
                Data += this.myResultSet.getString("ATTACKSPEED") + "\n";
                Data += this.myResultSet.getString("MINATTACK") + "\n";
                Data += this.myResultSet.getString("MAXATTACK") + "\n";
                Data += this.myResultSet.getString("HITCHANCE") + "\n";
                Data += this.myResultSet.getString("DODGECHANCE") + "\n";
                Data += this.myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Boat Kevin data");
            System.exit(0);
        }
        return Data;
    }

    public String extractEliData() {
        String data = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 1";
        try {
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                data += myResultSet.getString("NAME") + "\n";
                data += myResultSet.getString("HP") + "\n";
                data += myResultSet.getString("ATTACKSPEED") + "\n";
                data += myResultSet.getString("MINATTACK") + "\n";
                data += myResultSet.getString("MAXATTACK") + "\n";
                data += myResultSet.getString("HITCHANCE") + "\n";
                data += myResultSet.getString("DODGECHANCE") + "\n";
                data += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Eli data");
            System.exit(0);
        }
        return data;
    }

    public String extractNikolaiData() {
        String data = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 2";
        try {
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                data += myResultSet.getString("NAME") + "\n";
                data += myResultSet.getString("HP") + "\n";
                data += myResultSet.getString("ATTACKSPEED") + "\n";
                data += myResultSet.getString("MINATTACK") + "\n";
                data += myResultSet.getString("MAXATTACK") + "\n";
                data += myResultSet.getString("HITCHANCE") + "\n";
                data += myResultSet.getString("DODGECHANCE") + "\n";
                data += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting Nikolai data");
            System.exit(0);
        }
        return data;
    }

    public String extractSadBoySeaData() {
        String data = "";
        this.myQuery = "SELECT * FROM enemyDB LIMIT 1 OFFSET 3";
        try {
            this.myResultSet = myStatement.executeQuery(myQuery);
            while (myResultSet.next()) {
                data += myResultSet.getString("NAME") + "\n";
                data += myResultSet.getString("HP") + "\n";
                data += myResultSet.getString("ATTACKSPEED") + "\n";
                data += myResultSet.getString("MINATTACK") + "\n";
                data += myResultSet.getString("MAXATTACK") + "\n";
                data += myResultSet.getString("HITCHANCE") + "\n";
                data += myResultSet.getString("DODGECHANCE") + "\n";
                data += myResultSet.getString("SPECIALCHANCE") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Error extracting SadBoySea data");
            System.exit(0);
        }
        return data;
    }
}
