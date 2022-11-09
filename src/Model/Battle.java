package Model;

import Model.Enemy.*;
import Model.Hero.*;

import java.util.*;

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
        if (hero.getHealthPoints() <= 0){
            System.out.println(hero.getName() + " has died!");
        }else{
            System.out.println(enemy.getName() + " has died!");
        }
        System.out.println();
        winner(theConsole, hero, enemy);
    }
    public static Hero chooseHero(Scanner theConsole){
        System.out.println("Choose your hero!");
        System.out.println("1. Luffy");
        System.out.println("2. Zoro");
        System.out.println("3: Chopper");
        System.out.println("4: Nami");
        int choice = theConsole.nextInt();
        if (choice == 1){
            return new Luffy();
        }else if (choice == 2){
            return new Zoro();
        } else if (choice == 3){
            return new Chopper();
        } else if (choice == 4){
            return new Nami();
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            return chooseHero(theConsole);
        }
    }
    public static Enemy chooseEnemy(Scanner theConsole){
        System.out.println("Choose your enemy!");
        System.out.println("1. BoatKevin");
        System.out.println("2. SadBoySea");
        System.out.println("3: Nikolai");
        System.out.println("4: Eli");
        System.out.println("5: Random");
        char choice = theConsole.next().charAt(0);
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
            return chooseEnemy(theConsole);
        }
    }
    public static void battlePhase(Hero theHero, Enemy theEnemy, Scanner theConsole){
        System.out.println("What would you like to do?");
        System.out.println("j. Attack");
        System.out.println("k. Special Attack");
        System.out.println("p. Use Senzu Bean");
        char choice = theConsole.next().charAt(0);
        if (choice != 'j' && choice != 'k' && choice != 'p') {
            System.out.println("Invalid choice!");
            System.out.println();
            battlePhase(theHero, theEnemy, theConsole);
        }
        if (theHero.getAttackSpeed() > theEnemy.getAttackSpeed()) {
            heroTurn(choice, theHero, theEnemy);
            System.out.println();
            if (theEnemy.getHealthPoints() > 0) {
                enemyTurn(theHero, theEnemy);
                System.out.println();
            }
        }else{
            enemyTurn(theHero,theEnemy);
            System.out.println();
            if (theHero.getHealthPoints() > 0) {
                heroTurn(choice, theHero, theEnemy);
                System.out.println();
            }
        }
        System.out.println(theHero.getName() + " : " + theHero.getHealthPoints());
        System.out.println(theEnemy.getName() + " : " + theEnemy.getHealthPoints());
        System.out.println();
    }
    public static void heroTurn(char theChoice, Hero theHero, Enemy theEnemy) {
        switch (theChoice){
            case 'j':
                theHero.attack(theEnemy);
                break;
            case 'k':
                theHero.specialAttack(theEnemy);
                break;
            case 'p':
                theHero.useSenzuBean();
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

    public static void winner(Scanner theConsole, Hero theHero, Enemy theEnemy) {
        if (theEnemy.getHealthPoints() <= 0) {
            System.out.println("Victory");
        }
        if (theHero.getHealthPoints() <= 0) {
            System.out.println("Game Over");
        }
        System.out.println();
        restart(theConsole);
    }
    public static void restart(Scanner theConsole){
        System.out.println("Play again? 0. no or 1. yes");
        char choice = theConsole.next().charAt(0); // Initializes the game to start over.
        if (choice == '1') {
            gamePlay(theConsole);
        } else if(choice == '0'){
            System.out.println("Thanks for playing.");
        } else{
            System.out.println("Invalid choice!");
            System.out.println();
            restart(theConsole);
        }
    }
}
