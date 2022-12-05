package Model.Hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the Hero class.
 * @author Kevin Nguyen Jashanpreet Jandu Nicholas Zhuk
 * @version 1.0
 */
public class HeroTest {
    HeroTest() {
    }

    @Test
    void addSenzuBean() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
    }
    @Test
    void addPowerPowerFruit() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
            luffy.addPowerPowerFruit();
        }
        Assertions.assertEquals(5, luffy.getPowerPowerFruit());
    }
    @Test
    void addSpeedSpeedFruit() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
            luffy.addSpeedSpeedFruit();
        }
        Assertions.assertEquals(5, luffy.getSpeedSpeedFruit());
    }
    @Test
    void addTorch() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
            luffy.addTorch();
        }
        Assertions.assertEquals(5, luffy.getTorch());
    }

    @Test
    void useSenzuBean() {
        Luffy luffy = new Luffy();
        Zoro zoro = new Zoro();
        for(int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.subtractHealth(20);
        luffy.useSenzuBean();
        Assertions.assertEquals(4, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }
    @Test
    void useSenzuBean1() {
        Luffy luffy = new Luffy();
        Zoro zoro = new Zoro();
        for(int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.subtractHealth(10);
        luffy.useSenzuBean();
        Assertions.assertEquals(4, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }
    @Test
    void useSenzuBean2() {
        Luffy luffy = new Luffy();
        Zoro zoro = new Zoro();
        for(int i = 0; i < 5; ++i) {
            luffy.addSenzuBean();
        }
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
        luffy.useSenzuBean();
        Assertions.assertEquals(5, luffy.getSenzuBean());
        Assertions.assertEquals(120, luffy.getHealthPoints());
    }
    @Test
    void usePowerPowerFruit1() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
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
    @Test
    void usePowerPowerFruit2() {
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
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
    @Test
    void useSpeedSpeedFruit1(){
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
            luffy.addSpeedSpeedFruit();
        }
        Assertions.assertEquals(5, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(10, luffy.getAttackSpeed());
        luffy.useSpeedSpeedFruit();
        Assertions.assertEquals(4, luffy.getSpeedSpeedFruit());
        Assertions.assertEquals(11, luffy.getAttackSpeed());
    }
    @Test
    void useSpeedSpeedFruit2(){
        Luffy luffy = new Luffy();
        for(int i = 0; i < 5; ++i) {
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
