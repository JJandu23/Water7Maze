package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SadBoySeaTest {
    SadBoySeaTest() {
    }
    @Test
    void testSadBoySea(){
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter testSadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertNotNull(testSadBoySea);
        Assertions.assertEquals(300, testSadBoySea.getHealthPoints());
        Assertions.assertEquals(12, testSadBoySea.getAttackSpeed());
        Assertions.assertEquals(10, testSadBoySea.getMinDamage());
        Assertions.assertEquals(20, testSadBoySea.getMaxDamage());
        Assertions.assertEquals(0.80, testSadBoySea.getHitChance());
        Assertions.assertEquals(0.20, testSadBoySea.getDodgeChance());
        Assertions.assertEquals(0.10, testSadBoySea.getSpecialChance());
    }
    @Test
    void testSpecialAttack(){
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter sadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        MazeCharacter GoodSadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertNotNull(sadBoySea);
        Assertions.assertNotNull(GoodSadBoySea);
        Assertions.assertEquals(300, GoodSadBoySea.getHealthPoints());
        sadBoySea.setSpecialChance(1.0);
        sadBoySea.specialAttack(GoodSadBoySea);
        Assertions.assertEquals(225, GoodSadBoySea.getHealthPoints());
    }
}
