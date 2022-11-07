package Controller;

import Model.Hero.Hero;

import java.io.Serializable;

public class SaveCurrentState implements Serializable {
    public Hero hero;


    public SaveCurrentState(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
