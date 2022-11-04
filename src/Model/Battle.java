package Model;

import Model.Enemy.BoatKevin;
import Model.Enemy.Enemy;
import Model.Enemy.SadBoySea;
import Model.Hero.Chopper;
import Model.Hero.Hero;
import Model.Hero.Luffy;
import Model.Hero.Zoro;

import java.util.*;

public class Battle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Battle Simulator!");
        System.out.println();
        gamePlay(console);
    }

    public static void gamePlay(Scanner console) {
        Hero hero = chooseHero(console);
        Enemy enemy = chooseEnemy(console);
        while(hero.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            battlePhase(hero, enemy, console);
        }
        if (hero.getHealthPoints() <= 0){
            System.out.println(hero.getName() + " has died!");
        }else{
            System.out.println(enemy.getName() + " has died!");
        }
        System.out.println();
        winner(console, hero, enemy);
    }
    public static Hero chooseHero(Scanner console){
        System.out.println("Choose your hero!");
        System.out.println("1. Luffy");
        System.out.println("2. Zoro");
        System.out.println("3: Chopper");
        int choice = console.nextInt();
        if (choice == 1){
            return new Luffy();
        }else if (choice == 2){
            return new Zoro();
        } else if (choice == 3){
            return new Chopper();
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            return chooseHero(console);
        }
    }
    public static Enemy chooseEnemy(Scanner console){
        System.out.println("Choose your enemy!");
        System.out.println("1. BoatKevin");
        System.out.println("2. SadBoySea");
        int choice = console.nextInt();
        if (choice == 1){
            return new BoatKevin();
        }else if (choice == 2){
            return new SadBoySea();
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            return chooseEnemy(console);
        }
    }
    public static void battlePhase(Hero hero, Enemy enemy, Scanner console){
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Special Attack");
        System.out.println("3. Use Senzu Bean");
        int choice = console.nextInt();
        if (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Invalid choice!");
            System.out.println();
            battlePhase(hero, enemy, console);
        }
        if (hero.getAttackSpeed() > enemy.getAttackSpeed()) {
            heroTurn(choice, hero, enemy);
            System.out.println();
            enemyTurn(hero, enemy);
            System.out.println();
        }else{
            enemyTurn(hero,enemy);
            System.out.println();
            heroTurn(choice, hero, enemy);
            System.out.println();
        }
        System.out.println(hero.getName() + " : " + hero.getHealthPoints());
        System.out.println(enemy.getName() + " : " + enemy.getHealthPoints());
        System.out.println();
    }
    public static void heroTurn(int choice, Hero hero, Enemy enemy) {
        if (choice == 1) {
            hero.attack(enemy);
        } else if (choice == 2) {
            hero.specialAttack(enemy);
        } else if (choice == 3) {
            hero.useSenzuBean();
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

    public static void winner(Scanner console, Hero hero, Enemy enemy) {
        if (enemy.getHealthPoints() <= 0) {
            System.out.println("Victory");
        }
        if (hero.getHealthPoints() <= 0) {
            System.out.println("Game Over");
        }
        System.out.println();
        restart(console);
    }
    public static void restart(Scanner console){
        System.out.println("Play again? 0. no or 1. yes");
        int choice = console.nextInt(); // Initializes the game to start over.
        if (choice == 1) {
            gamePlay(console);
        } else if(choice == 0){
            System.out.println("Thanks for playing.");
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            restart(console);
        }
    }
}
