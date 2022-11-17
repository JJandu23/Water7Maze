package Model;

import Model.Enemy.*;
import Model.Hero.*;

import java.util.Random;
import java.util.Scanner;

import static Model.Enemy.EnemyFactory.chosenEnemy;

public class Battle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        gamePlay(console);
    }

    public static void gamePlay(Scanner theConsole) {
        Hero hero = chooseHero(theConsole);
        System.out.println("You have chosen " + hero.getName() + "!");
        Enemy enemy = chooseEnemy(theConsole);
        System.out.println("You have chosen to fight " + enemy.getName() + "!");
        System.out.println();
        while(hero.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            battlePhase(hero, enemy, theConsole);
        }
        if (hero.getHealthPoints() <= 0) {
            System.out.println(hero.getName() + " has died!");
        } else {
            System.out.println(enemy.getName() + " has died!");
        }
        System.out.println();
        winner(hero, enemy);
    }

    public static Hero chooseHero(Scanner theConsole) {
        System.out.println("1. Luffy");
        System.out.println("2. Zoro");
        System.out.println("3: Chopper");
        System.out.println("4: Nami");
        char choice = theConsole.next().charAt(0);
        if (choice == '1') {
            return new Luffy();
        } else if (choice == '2') {
            return new Zoro();
        } else if (choice == '3') {
            return new Chopper();
        } else if (choice == '4') {
            return new Nami();
        } else {
            System.out.println("Invalid choice!");
            System.out.println();
            return chooseHero(theConsole);
        }
    }
    public static Enemy chooseEnemy(Scanner theConsole){
        System.out.println("Choose your enemy!");
        char choice = theConsole.next().charAt(0);
        EnemyFactory.getInstance();
        return  chosenEnemy(choice);
    }

    public static void battlePhase(Hero theHero, Enemy theEnemy, Scanner theConsole) {
        char choice = getChoice(theConsole);
        if (theHero.getAttackSpeed() >= theEnemy.getAttackSpeed()) {
            heroTurn(choice, theHero, theEnemy);
            System.out.println();
            theEnemy.attack(theHero);
            System.out.println();
        } else {
            theEnemy.attack(theHero);
            System.out.println();
            heroTurn(choice, theHero, theEnemy);
            System.out.println();
        }
        System.out.println(theHero.getName() + " : " + theHero.getHealthPoints());
        System.out.println(theEnemy.getName() + " : " + theEnemy.getHealthPoints());
        System.out.println();
    }

    public static char getChoice(Scanner theConsole) {
        System.out.println("What would you like to do?");
        System.out.println("j. Attack");
        System.out.println("k. Special Attack");
        System.out.println("p. Use Senzu Bean");
        System.out.println("o. Use power power fruit");
        System.out.println("l. Use speed speed fruit");
        char choice = theConsole.next().charAt(0);
        if (choice != 'j' && choice != 'k' && choice != 'p' && choice != 'o' && choice != 'l') {
            System.out.println("Invalid choice!");
            System.out.println();
            getChoice(theConsole);
        }
        return choice;
    }

    public static void heroTurn(char theChoice, Hero theHero, Enemy theEnemy) {
        switch (theChoice) {
            case 'j':
                theHero.attack(theEnemy);
                break;
            case 'k':
                theHero.specialAttack(theEnemy);
                break;
            case 'p':
                theHero.useSenzuBean();
                break;
            case 'o':
                theHero.usePowerPowerFruit();
                break;
            case 'l':
                theHero.useSpeedSpeedFruit();
                break;
        }
    }

    public static void enemyTurn(Hero hero, Enemy enemy){
        Random chance = new Random();
        if (chance.nextFloat() <= enemy.getSpecialChance()) {
            enemy.specialAttack(hero);
        } else {
            enemy.attack(hero);
        }
    }

    public static void winner(Hero theHero, Enemy theEnemy) {
        if (theEnemy.getHealthPoints() <= 0) {
            System.out.println("Victory");
        }
        if (theHero.getHealthPoints() <= 0) {
            System.out.println("Game Over");
        }
    }
}
