package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Hero class.
 *
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class HeroTest {
    HeroTest() {
    }

    /**
     * This method is used to test for adding senzu beans.
     */
    @Test
    void addSenzuBean() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
    }

    /**
     * This method is used to test for adding the power power fruit.
     */
    @Test
    void addPowerPowerFruit() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addPowerPowerFruit();
        }
        Assertions.assertEquals(5, luffy.getPowerPowerFruit());
    }

    /**
     * This method is used to test for adding the speed power fruit.
     */
    @Test
    void addSpeedSpeedFruit() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSpeedSpeedFruit();
        }
        Assertions.assertEquals(5, luffy.getSpeedSpeedFruit());
    }

    /**
     * This method is used to test for adding torches.
     */
    @Test
    void addTorch() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addTorch();
        }
        Assertions.assertEquals(5, luffy.getTorch());
    }

    /**
     * This method is used to test for adding the health points.
     */
    @Test
    void useSenzuBean1() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.subtractHealth(20);
        luffy.useSenzuBean();
        Assertions.assertEquals(4, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }

    /**
     * This method is used to test for adding the health over max.
     */
    @Test
    void useSenzuBean2() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.useSenzuBean();
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }

    /**
     * This method is used to test for increasing damage.
     */
    @Test
    void usePowerPowerFruit1() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addPowerPowerFruit();
        }
        Assertions.assertEquals(5, luffy.getPowerPowerFruit());
        Assertions.assertEquals(15, luffy.getMinDamage());
        Assertions.assertEquals(25, luffy.getMaxDamage());
        luffy.usePowerPowerFruit();
        Assertions.assertEquals(4, luffy.getPowerPowerFruit());
        Assertions.assertEquals(25, luffy.getMinDamage());
        Assertions.assertEquals(35, luffy.getMaxDamage());
    }

    /**
     * This method is used to test for increasing damage multiple times.
     */
    @Test
    void usePowerPowerFruit2() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addPowerPowerFruit();
        }
        Assertions.assertEquals(5, luffy.getPowerPowerFruit());
        Assertions.assertEquals(15, luffy.getMinDamage());
        Assertions.assertEquals(25, luffy.getMaxDamage());
        luffy.usePowerPowerFruit();
        luffy.usePowerPowerFruit();
        luffy.usePowerPowerFruit();
        luffy.usePowerPowerFruit();
        Assertions.assertEquals(1, luffy.getPowerPowerFruit());
        Assertions.assertEquals(55, luffy.getMinDamage());
        Assertions.assertEquals(65, luffy.getMaxDamage());
    }

    /**
     * This method is used to test for increasing attack speed.
     */
    @Test
    void useSpeedSpeedFruit1() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSpeedSpeedFruit();
        }
        Assertions.assertEquals(5, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(10, luffy.getAttackSpeed());
        luffy.useSpeedSpeedFruit();
        Assertions.assertEquals(4, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(11, luffy.getAttackSpeed());
    }

    /**
     * This method is used to test for increasing attack speed multiple times.
     */
    @Test
    void useSpeedSpeedFruit2() {
        Luffy luffy = new Luffy();
        for (int i = 0; i < 5; ++i) {
            luffy.addSpeedSpeedFruit();
        }
        Assertions.assertEquals(5, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(10, luffy.getAttackSpeed());
        luffy.useSpeedSpeedFruit();
        luffy.useSpeedSpeedFruit();
        luffy.useSpeedSpeedFruit();
        luffy.useSpeedSpeedFruit();
        Assertions.assertEquals(1, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(14, luffy.getAttackSpeed());
    }

}
