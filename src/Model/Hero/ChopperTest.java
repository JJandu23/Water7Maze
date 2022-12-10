package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Chopper class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class ChopperTest {
    ChopperTest() {
    }

    /**
     * This method is used to test the Chopper special attack.
     */
    @Test
    void specialAttack1() {
        Chopper chopper = new Chopper();
        chopper.setSpecialChance(1.0);
        Assertions.assertEquals(100, chopper.getHealthPoints());
        chopper.subtractHealth(50);
        chopper.specialAttack(chopper);
        Assertions.assertEquals(true, chopper.getHealthPoints() <= 80);
        Assertions.assertEquals(true, chopper.getHealthPoints() >= 70);
    }

    /**
     * This method is used to test the Chopper special attack max.
     */
    @Test
    void specialAttack2() {
        Chopper chopper = new Chopper();
        chopper.setSpecialChance(1.0);
        Assertions.assertEquals(100, chopper.getHealthPoints());
        chopper.subtractHealth(10);
        chopper.specialAttack(chopper);
        Assertions.assertEquals(true, chopper.getHealthPoints() == chopper.getOriginalHealthPoints());
    }
}
