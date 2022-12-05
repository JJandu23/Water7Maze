package Model;

import Model.Enemy.EnemyFactory;
import Model.Hero.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazeCharaterTest {
    MazeCharaterTest() {
    }
    @Test
    void attack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter hero = new Luffy();
        MazeCharacter enemy = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        hero.setHitChance(1.0);
        enemy.setDodgeChance(0.0);
        int enemyHP = enemy.getHealthPoints();
        hero.attack(enemy);
        Assertions.assertEquals(true, enemy.getHealthPoints() < enemyHP);
    }
    @Test
    void specialAttack() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter hero = new Luffy();
        MazeCharacter enemy = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        hero.setSpecialChance(1.0);
        enemy.setDodgeChance(0.0);
        int enemyHP = enemy.getHealthPoints();
        hero.specialAttack(enemy);
        Assertions.assertEquals(true, enemy.getHealthPoints() < enemyHP);
    }
    @Test
    void isAlive1(){
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter hero = new Luffy();
        MazeCharacter enemy = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        hero.attack(enemy);
        Assertions.assertEquals(true, enemy.isAlive());
    }
    @Test
    void isAlive2(){
        MazeCharacter hero = new Luffy();
        hero.setHealthPoints(0);
        Assertions.assertEquals(false, hero.isAlive());
    }

}
