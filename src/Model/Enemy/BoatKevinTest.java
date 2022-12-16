package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the BoatKevin class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class BoatKevinTest {
    BoatKevinTest() {
    }

    /**
     * This method is used to test the BoatKevin stats from SQLite
     */
    @Test
    void testBoatKevin() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter testBoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.BOATKEVIN);
        Assertions.assertNotNull(testBoatKevin);
        Assertions.assertEquals(40, testBoatKevin.getHealthPoints());
        Assertions.assertEquals(8, testBoatKevin.getAttackSpeed());
        Assertions.assertEquals(10, testBoatKevin.getMinDamage());
        Assertions.assertEquals(20, testBoatKevin.getMaxDamage());
        Assertions.assertEquals(0.80, testBoatKevin.getHitChance());
        Assertions.assertEquals(0.20, testBoatKevin.getDodgeChance());
        Assertions.assertEquals(0.00001, testBoatKevin.getSpecialChance());
    }

    /**
     * This method is used to test the BoatKevin special attack.
     */
    @Test
    void testSpecialAttack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter BoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.BOATKEVIN);
        MazeCharacter GoodBoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.BOATKEVIN);
        Assertions.assertNotNull(BoatKevin);
        Assertions.assertNotNull(GoodBoatKevin);
        Assertions.assertEquals(40, GoodBoatKevin.getHealthPoints());
        BoatKevin.setSpecialChance(1.0);
        BoatKevin.specialAttack(GoodBoatKevin);
        Assertions.assertEquals(0, GoodBoatKevin.getHealthPoints());
    }
}