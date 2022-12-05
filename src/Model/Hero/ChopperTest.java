package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChopperTest {
    ChopperTest() {
    }
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
