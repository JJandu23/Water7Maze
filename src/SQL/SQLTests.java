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
    /**
     * This method is used to test if the sql can extract Boat Kevin data.
     *
     * @throws SQLException if the Boat Kevin data is not found.
     */
    @Test
    void extractBoatKevinData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractBoatKevinData();
        System.out.println(result);
        System.out.println();
    }

    /**
     * This method is used to test if the sql can extract Eli data.
     *
     * @throws SQLException if the Eli data is not found.
     */
    @Test
    void extractEliData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractEliData();
        System.out.println(result);
        System.out.println();
    }

    /**
     * This method is used to test if the sql can extract Nikolai data.
     *
     * @throws SQLException if the Nikolai data is not found.
     */
    @Test
    void extractNikolaiData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractNikolaiData();
        System.out.println(result);
        System.out.println();
    }

    /**
     * This method is used to test if the sql can extract SadBoySea data.
     *
     * @throws SQLException if the SadBoySea data is not found.
     */
    @Test
    void extractSadBoySeaData() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractSadBoySeaData();
        System.out.println(result);
        System.out.println();
    }
}
