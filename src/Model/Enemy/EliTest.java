package Model.Enemy;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EliTest {
    EliTest() {
    }
    @Test
    void testEli(){
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
    @Test
    void testSpecialAttack(){
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter BoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        MazeCharacter GoodBoatKevin = enemyFactory.chosenEnemy(EnemyFactory.Enemy.ELI);
        Assertions.assertNotNull(BoatKevin);
        Assertions.assertNotNull(GoodBoatKevin);
        Assertions.assertEquals(40, GoodBoatKevin.getHealthPoints());
        BoatKevin.specialAttack(GoodBoatKevin);
        Assertions.assertEquals(0, GoodBoatKevin.getHealthPoints());
    }
}
