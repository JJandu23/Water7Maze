package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamiTest {
    NamiTest() {
    }
    @Test
    void specialAttack1() {
        Nami nami = new Nami();
        nami.setSpecialChance(1.0);
        Assertions.assertEquals(0.4, nami.getDodgeChance());
        nami.specialAttack(nami);
        Assertions.assertEquals(0.5, nami.getDodgeChance());
    }
    @Test
    void specialAttack2() {
        Nami nami = new Nami();
        nami.setSpecialChance(1.0);
        nami.setDodgeChance(0.9);
        Assertions.assertEquals(0.9, nami.getDodgeChance());
        nami.specialAttack(nami);
        Assertions.assertEquals(1.0, nami.getDodgeChance());
    }


}
