package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Zoro class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class ZoroTest {
    ZoroTest() {
    }

    /**
     * This method is used to test the Zoro special attack.
     */
    @Test
    void specialAttack() {
        Zoro zoro = new Zoro();
        Zoro badZoro = new Zoro();
        zoro.setSpecialChance(1.0);
        badZoro.setDodgeChance(0.0);
        Assertions.assertEquals(110, badZoro.getHealthPoints());
        zoro.specialAttack(badZoro);
        Assertions.assertEquals(true, badZoro.getHealthPoints() >= 40);
        Assertions.assertEquals(true, badZoro.getHealthPoints() <= 60);
    }
}
