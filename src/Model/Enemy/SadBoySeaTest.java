package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the SadBoySea class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class SadBoySeaTest {
    SadBoySeaTest() {
    }

    /**
     * This method is used to tests the SadBoySea stats from SQLite.
     */
    @Test
    void testSadBoySea() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter testSadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertNotNull(testSadBoySea);
        Assertions.assertEquals(150, testSadBoySea.getHealthPoints());
        Assertions.assertEquals(12, testSadBoySea.getAttackSpeed());
        Assertions.assertEquals(10, testSadBoySea.getMinDamage());
        Assertions.assertEquals(20, testSadBoySea.getMaxDamage());
        Assertions.assertEquals(0.80, testSadBoySea.getHitChance());
        Assertions.assertEquals(0.20, testSadBoySea.getDodgeChance());
        Assertions.assertEquals(0.05, testSadBoySea.getSpecialChance());
    }

    /**
     * This method is used to test the SadBoySea special attack.
     */
    @Test
    void testSpecialAttack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter sadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        MazeCharacter GoodSadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertNotNull(sadBoySea);
        Assertions.assertNotNull(GoodSadBoySea);
        Assertions.assertEquals(150, GoodSadBoySea.getHealthPoints());
        sadBoySea.setSpecialChance(1.0);
        GoodSadBoySea.setDodgeChance(0.0);
        sadBoySea.specialAttack(GoodSadBoySea);
        Assertions.assertEquals(132, GoodSadBoySea.getHealthPoints());
    }
}