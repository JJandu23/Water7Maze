package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Eli class.
 */
public class EliTest {
    EliTest() {
    }

    /**
     * This method is used to test the Eli stats from SQLite
     */
    @Test
    void testEli() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter testEli = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        Assertions.assertNotNull(testEli);
        Assertions.assertEquals(90, testEli.getHealthPoints());
        Assertions.assertEquals(12, testEli.getAttackSpeed());
        Assertions.assertEquals(15, testEli.getMinDamage());
        Assertions.assertEquals(20, testEli.getMaxDamage());
        Assertions.assertEquals(0.40, testEli.getHitChance());
        Assertions.assertEquals(0.20, testEli.getDodgeChance());
        Assertions.assertEquals(0.20, testEli.getSpecialChance());
    }

    /**
     * This method is used to test the Eli special attack.
     */
    @Test
    void testSpecialAttack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter eli = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        MazeCharacter goodEli = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        Assertions.assertNotNull(eli);
        Assertions.assertNotNull(goodEli);
        Assertions.assertEquals(90, goodEli.getHealthPoints());
        eli.setSpecialChance(1.0);
        eli.specialAttack(goodEli);
        Assertions.assertEquals(true, goodEli.getHealthPoints() < 60 || goodEli.getHealthPoints() > 70);

    }
}
