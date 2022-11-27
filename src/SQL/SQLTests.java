package SQL;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * This class is used to test the SQL.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class SQLTests {
    @Test
    void extractBoatKevinData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractBoatKevinData();
        System.out.println(result);
        System.out.println();
    }

    @Test
    void extractEliInfo() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractEliData();
        System.out.println(result);
        System.out.println();
    }

    @Test
    void extractNikolaiData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractNikolaiData();
        System.out.println(result);
        System.out.println();
    }

    @Test
    void extractSadBoySeaData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractSadBoySeaData();
        System.out.println(result);
        System.out.println();
    }
}
