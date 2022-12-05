package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZoroTest {
    ZoroTest() {
    }
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
