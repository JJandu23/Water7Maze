package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NikolaiTest {
    NikolaiTest() {
    }
    @Test
    void testBoatKevin(){
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
    @Test
    void testSpecialAttack(){
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
