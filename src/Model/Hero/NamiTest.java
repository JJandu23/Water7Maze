package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Nami class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class NamiTest {
    NamiTest() {
    }

    /**
     * This method is used to test the Nami special attack.
     */
    @Test
    void specialAttack1() {
        Nami nami = new Nami();
        nami.setSpecialChance(1.0);
        Assertions.assertEquals(0.4, nami.getDodgeChance());
        nami.specialAttack(nami);
        Assertions.assertEquals(0.5, nami.getDodgeChance());
    }

    /**
     * This method is used to test the Nami special attack max.
     */
    @Test
    void specialAttack2() {
        Nami nami = new Nami();
        nami.setSpecialChance(1.0);
        nami.setDodgeChance(0.9);
        Assertions.assertEquals(0.9, nami.getDodgeChance());
        nami.specialAttack(nami);
        Assertions.assertEquals(1.0, nami.getDodgeChance());
        nami.specialAttack(nami);
        Assertions.assertEquals(1.0, nami.getDodgeChance());
    }


}
