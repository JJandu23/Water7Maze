package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the EnemyFactory class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class EnemyFactoryTest {
    EnemyFactoryTest() {
    }

    /**
     * This method is used to test the EnemyFactory instance
     */
    @Test
    void testEnemyFactory() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
    }

    /**
     * This method is used to test the creation of the BoatKevin enemy.
     */
    @Test
    void createBoatKevin() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        assert enemyFactory != null;
        MazeCharacter BoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.BOATKEVIN);
        Assertions.assertNotNull(BoatKevin);
        Assertions.assertEquals(40, BoatKevin.getHealthPoints());
        Assertions.assertEquals(13, BoatKevin.getAttackSpeed());
        Assertions.assertEquals(10, BoatKevin.getMinDamage());
        Assertions.assertEquals(20, BoatKevin.getMaxDamage());
        Assertions.assertEquals(0.80, BoatKevin.getHitChance());
        Assertions.assertEquals(0.20, BoatKevin.getDodgeChance());
        Assertions.assertEquals(0.05, BoatKevin.getSpecialChance());
    }

    /**
     * This method is used to test the creation of the Eli enemy.
     */
    @Test
    void createEli() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        assert enemyFactory != null;
        MazeCharacter Eli = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        Assertions.assertNotNull(Eli);
        Assertions.assertEquals(90, Eli.getHealthPoints());
        Assertions.assertEquals(12, Eli.getAttackSpeed());
        Assertions.assertEquals(15, Eli.getMinDamage());
        Assertions.assertEquals(20, Eli.getMaxDamage());
        Assertions.assertEquals(0.40, Eli.getHitChance());
        Assertions.assertEquals(0.20, Eli.getDodgeChance());
        Assertions.assertEquals(0.20, Eli.getSpecialChance());
    }

    /**
     * This method is used to test the creation of the Nikolai enemy.
     */
    @Test
    void createNikolai() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        assert enemyFactory != null;
        MazeCharacter Nikolai = enemyFactory.chosenEnemy(EnemyFactory.Enemy.NIKOLAI);
        Assertions.assertNotNull(Nikolai);
        Assertions.assertEquals(110, Nikolai.getHealthPoints());
        Assertions.assertEquals(11, Nikolai.getAttackSpeed());
        Assertions.assertEquals(20, Nikolai.getMinDamage());
        Assertions.assertEquals(30, Nikolai.getMaxDamage());
        Assertions.assertEquals(0.40, Nikolai.getHitChance());
        Assertions.assertEquals(0.20, Nikolai.getDodgeChance());
        Assertions.assertEquals(0.25, Nikolai.getSpecialChance());
    }

    /**
     * This method is used to test the creation of the SadBoySea enemy.
     */
    @Test
    void createSadBoySea() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        assert enemyFactory != null;
        MazeCharacter SadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertNotNull(SadBoySea);
        Assertions.assertEquals(250, SadBoySea.getHealthPoints());
        Assertions.assertEquals(12, SadBoySea.getAttackSpeed());
        Assertions.assertEquals(10, SadBoySea.getMinDamage());
        Assertions.assertEquals(20, SadBoySea.getMaxDamage());
        Assertions.assertEquals(0.80, SadBoySea.getHitChance());
        Assertions.assertEquals(0.20, SadBoySea.getDodgeChance());
        Assertions.assertEquals(0.10, SadBoySea.getSpecialChance());
    }

}
