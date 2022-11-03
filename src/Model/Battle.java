package Model;

import Model.Enemy.BoatKevin;
import Model.Enemy.Enemy;
import Model.Hero.Hero;
import Model.Hero.Luffy;

import java.util.*;

public class Battle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Battle Simulator!");
        battle(console);
    }

    public static void battle(Scanner console) {
        Hero hero = new Luffy();
        Enemy enemy = new BoatKevin();
        while (hero.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            if (hero.getAttackSpeed() > enemy.getAttackSpeed()) {
                heroTurn(console, hero, enemy);
            }else{
                enemyTurn(hero,enemy);
            }
            System.out.println();
        }
        if (hero.getHealthPoints() <= 0){
            System.out.println(hero.getName() + " has died!");
        }else{
            System.out.println(enemy.getName() + " has died!");
        }
        winner(console, hero, enemy);
    }

    public static void heroTurn(Scanner console, Hero hero, Enemy enemy) {
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Special Attack");
        System.out.println("3. Use Senzu Bean");
        int choice = console.nextInt();
        if (choice == 1) {
            hero.attack(enemy);
        } else if (choice == 2) {
            hero.specialAttack(enemy);
        } else if (choice == 3) {
            hero.useSenzuBean(hero.getSenzuBean());
        } else {
            System.out.println("Invalid choice!");
            heroTurn(console, hero, enemy);
        }
        enemyTurn(hero, enemy);
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
        System.out.println("Play again? 0. no or 1. yes");
        int restart = console.nextInt(); // Initializes the game to start over.
        if (restart == 1) {
            battle(console);
        } else {
            System.out.println("Thanks for playing.");
        }
    }
}
