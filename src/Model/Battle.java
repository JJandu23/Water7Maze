package Model;

import Model.Enemy.*;
import Model.Hero.Chopper;
import Model.Hero.Hero;
import Model.Hero.Luffy;
import Model.Hero.Zoro;

import java.util.*;

public class Battle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        gamePlay(console);
    }

    public static void gamePlay(Scanner console) {
        Hero hero = chooseHero(console);
        System.out.println("You have chosen " + hero.getName() + "!");
        Enemy enemy = chooseEnemy(console);
        System.out.println("You have chosen to fight " + enemy.getName() + "!");
        System.out.println();
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
        System.out.println("3: Nikolai");
        System.out.println("4: Eli");
        System.out.println("5: Random");
        char choice = console.next().charAt(0);
        if (choice == '1'){
            return new BoatKevin();
        }else if (choice == '2') {
            return new SadBoySea();
        }else if (choice == '3'){
            return new Nikolai();
        }else if (choice == '4'){
            return new Eli();
        }else if (choice == '5'){
            Random random = new Random();
            int randomChoice = random.nextInt(4);
            if (randomChoice == 0){
                return new BoatKevin();
            }else if (randomChoice == 1){
                return new SadBoySea();
            }else if (randomChoice == 2){
                return new Nikolai();
            }else{
                return new Eli();
            }
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            return chooseEnemy(console);
        }
    }
    public static void battlePhase(Hero hero, Enemy enemy, Scanner console){
        System.out.println("What would you like to do?");
        System.out.println("j. Attack");
        System.out.println("k. Special Attack");
        System.out.println("p. Use Senzu Bean");
        char choice = console.next().charAt(0);
        if (choice != 'j' && choice != 'k' && choice != 'p') {
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
    public static void heroTurn(char choice, Hero hero, Enemy enemy) {
        switch (choice){
            case 'j':
                hero.attack(enemy);
                break;
            case 'k':
                hero.specialAttack(enemy);
                break;
            case 'p':
                hero.useSenzuBean();
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
        char choice = console.next().charAt(0); // Initializes the game to start over.
        if (choice == '1') {
            gamePlay(console);
        } else if(choice == '0'){
            System.out.println("Thanks for playing.");
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            restart(console);
        }
    }
}
