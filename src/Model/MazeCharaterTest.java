package Model;

import Model.Enemy.EnemyFactory;
import Model.Hero.Hero;
import Model.Hero.Luffy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the MazeCharacter class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class MazeCharaterTest {
    MazeCharaterTest() {
    }

    /**
     * This method is used to test if the maze character can attack.
     */
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

    /**
     * This method is used to test if the maze character can block.
     */
    @Test
    void Block() {
        Hero luffy = new Luffy();
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        MazeCharacter sadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.setHitChance(1.0);
        sadBoySea.setDodgeChance(1.0);
        sadBoySea.attack(luffy);
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }

    /**
     * This method is used to test if the maze character can miss their attack.
     */
    @Test
    void missed() {
        Hero luffy = new Luffy();
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        MazeCharacter sadBoySea = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        Assertions.assertEquals(120, luffy.getHealthPoints());
        sadBoySea.setHitChance(0.0);
        sadBoySea.attack(luffy);
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }

    /**
     * This method is used to test if the maze character can use their special attack.
     */
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

    /**
     * This method is used to test if the maze character is alive.
     */
    @Test
    void isAlive1() {
        EnemyFactory enemyFactory = EnemyFactory.getInstance();
        Assertions.assertNotNull(enemyFactory);
        MazeCharacter hero = new Luffy();
        MazeCharacter enemy = enemyFactory.chosenEnemy(EnemyFactory.Enemy.SADBOYSEA);
        hero.attack(enemy);
        Assertions.assertEquals(true, enemy.isAlive());
    }

    /**
     * This method is used to test if the maze character is dead.
     */
    @Test
    void isAlive2() {
        MazeCharacter hero = new Luffy();
        hero.setHealthPoints(0);
        Assertions.assertEquals(false, hero.isAlive());
    }

    /**
     * This method is used to test if the maze character loses health.
     */
    @Test
    void subtractHealth1() {
        Hero luffy = new Luffy();
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.subtractHealth(10);
        Assertions.assertEquals(110, luffy.getHealthPoints());
    }

    /**
     * This method is used to test if the maze character loses health more than their health.
     */
    @Test
    void subtractHealth2() {
        Hero luffy = new Luffy();
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.subtractHealth(999999999);
        Assertions.assertEquals(0, luffy.getHealthPoints());
    }

}
