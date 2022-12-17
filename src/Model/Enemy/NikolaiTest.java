package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Nikolai class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class NikolaiTest {
    NikolaiTest() {
    }

    /**
     * This method is used to tests the Nikolai stats from SQLite.
     */
    @Test
    void testNikolai() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter testNikolai = enemyFactory.chosenEnemy(EnemyFactory.Enemy.NIKOLAI);
        Assertions.assertNotNull(testNikolai);
        Assertions.assertEquals(110, testNikolai.getHealthPoints());
        Assertions.assertEquals(11, testNikolai.getAttackSpeed());
        Assertions.assertEquals(20, testNikolai.getMinDamage());
        Assertions.assertEquals(30, testNikolai.getMaxDamage());
        Assertions.assertEquals(0.40, testNikolai.getHitChance());
        Assertions.assertEquals(0.20, testNikolai.getDodgeChance());
        Assertions.assertEquals(0.25, testNikolai.getSpecialChance());
    }

    /**
     * This method is used to test the Nikolai special attack.
     */
    @Test
    void testSpecialAttack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter nikolai = enemyFactory.chosenEnemy(EnemyFactory.Enemy.NIKOLAI);
        MazeCharacter goodNikolai = enemyFactory.chosenEnemy(EnemyFactory.Enemy.NIKOLAI);
        Assertions.assertNotNull(nikolai);
        Assertions.assertNotNull(goodNikolai);
        Assertions.assertEquals(110, goodNikolai.getHealthPoints());
        nikolai.setSpecialChance(1.0);
        nikolai.specialAttack(goodNikolai);
        Assertions.assertEquals(50, goodNikolai.getHealthPoints());
    }
}
