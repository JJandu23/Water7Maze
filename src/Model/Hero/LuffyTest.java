package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Luffy class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class LuffyTest {
    LuffyTest() {
    }

    /**
     * This method is used to test the Luffy special attack.
     */
    @Test
    void specialAttack() {
        Luffy luffy = new Luffy();
        Luffy badLuffy = new Luffy();
        Luffy.setSpecialChance(1.0);
        badLuffy.setDodgeChance(0.0);
        Assertions.assertEquals(120, badLuffy.getHealthPoints());
        luffy.specialAttack(badLuffy);
        Assertions.assertEquals(true, badLuffy.getHealthPoints() >= 65);
        Assertions.assertEquals(true, badLuffy.getHealthPoints() <= 75);
    }

}
