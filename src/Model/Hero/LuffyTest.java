package Model.Hero;

import Model.MazeCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class LuffyTest{
    LuffyTest() {
    }
    @Test
    void specialAttack() {
        Luffy luffy = new Luffy();
        Luffy badLuffy = new Luffy();
        Luffy.setSpecialChance(1.0);
        badLuffy.setDodgeChance(0.0);
        Assertions.assertEquals(120, badLuffy.getHealthPoints());
        luffy.specialAttack(badLuffy);
        Assertions.assertEquals(true, badLuffy.getHealthPoints() >= 75);
        Assertions.assertEquals(true, badLuffy.getHealthPoints() <= 85);
    }

}
