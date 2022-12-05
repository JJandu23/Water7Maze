package Model;

import Model.Enemy.*;
import Model.Hero.*;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is used to control the battle between the hero and the enemy.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class Battle {

    /**
     * The hero object.
     */
    private static Hero myHero;

    /**
     * The enemy object.
     */
    private static MazeCharacter myEnemy;

    /**
     * This method is used to control the battle.
     *
     * @param theHero  the hero object.
     * @param theEnemy the enemy object.
     */
    public Battle(Hero theHero, MazeCharacter theEnemy) {
        myHero = theHero;
        myEnemy = theEnemy;
        Scanner console = new Scanner(System.in);
        gamePlay(myHero, myEnemy, console);
    }

    /**
     * This method controls the gameplay of the battle .
     *
     * @param theConsole the console to read from.
     */
    public static void gamePlay(final Hero theHero, final MazeCharacter theEnemy, final Scanner theConsole) {
        while (theHero.getHealthPoints() > 0 && theEnemy.getHealthPoints() > 0) {
            battlePhase(theHero, theEnemy, theConsole);
        }
        if (theHero.getHealthPoints() <= 0) {
            System.out.println(theHero.getName() + " has died!");
        } else {
            System.out.println(theEnemy.getName() + " has died!");
        }
        System.out.println();
        winner(theHero, theEnemy);
    }

    public static void gamePlay(final Scanner theConsole) {
        myHero = chooseHero(theConsole);
        System.out.println("You have chosen " + myHero.getName() + "!" + "\n");
        myEnemy = chooseEnemy();
        System.out.println("You have chosen to fight " + myEnemy.getName() + "!" + "\n");
        while (myHero.getHealthPoints() > 0 && myEnemy.getHealthPoints() > 0) {
            battlePhase(myHero, myEnemy, theConsole);
        }
        if (myHero.getHealthPoints() <= 0) {
            System.out.println(myHero.getName() + " has died!");
        } else {
            System.out.println(myEnemy.getName() + " has died!");
        }
        System.out.println();
        winner(myHero, myEnemy);
    }

    /**
     * This method selects the chosen hero.
     *
     * @param theConsole the console to read from.
     * @return the hero chosen by the user.
     */
    public static Hero chooseHero(final Scanner theConsole) {
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

    /**
     * This method selects the chosen enemy.
     *
     * @return the enemy chosen by the user.
     */
    public static MazeCharacter chooseEnemy() {
        Random rand = new Random();
        int choice = rand.nextInt(4);
        EnemyFactory.Enemy enemyType = EnemyFactory.Enemy.values()[choice];
        return EnemyFactory.chosenEnemy(enemyType);
    }

    /**
     * This method represents the battle phase.
     *
     * @param theHero    the hero in the battle.
     * @param theEnemy   the enemy in the battle.
     * @param theConsole the console to read from.
     */
    public static void battlePhase(final Hero theHero, final MazeCharacter theEnemy, final Scanner theConsole) {
        char choice = getChoice(theConsole);
        if (theHero.getAttackSpeed() >= theEnemy.getAttackSpeed()) {
            heroTurn(choice, theHero, theEnemy);
            System.out.println();
            enemyTurn(theHero, theEnemy);
            System.out.println();
        } else {
            enemyTurn(theHero, theEnemy);
            System.out.println();
            heroTurn(choice, theHero, theEnemy);
            System.out.println();
        }
        System.out.println(theHero.getName() + " : " + theHero.getHealthPoints());
        System.out.println(theEnemy.getName() + " : " + theEnemy.getHealthPoints() + "\n");
    }

    /**
     * This method takes in the user's turn choice.
     *
     * @param theConsole the console to read from.
     * @return the choice of the user.
     */
    public static char getChoice(final Scanner theConsole) {
        System.out.println("What would you like to do?");
        System.out.println("j. Attack");
        System.out.println("k. Special Attack");
        System.out.println("p. Use Senzu Bean");
        System.out.println("o. Use power power fruit");
        System.out.println("l. Use speed speed fruit");
        char choice = theConsole.next().charAt(0);
        if (choice != 'j' && choice != 'k' && choice != 'p' && choice != 'o' && choice != 'l') {
            System.out.println("Invalid choice!" + "\n");
            getChoice(theConsole);
        }
        return choice;
    }

    /**
     * This method represents the hero's turn.
     *
     * @param theChoice the choice of the user.
     * @param theHero   the hero in the battle.
     * @param theEnemy  the enemy in the battle.
     */
    public static void heroTurn(final char theChoice, final Hero theHero, final MazeCharacter theEnemy) {
        switch (theChoice) {
            case 'j' -> theHero.attack(theEnemy);
            case 'k' -> theHero.specialAttack(theEnemy);
            case 'p' -> theHero.useSenzuBean();
            case 'o' -> theHero.usePowerPowerFruit();
            case 'l' -> theHero.useSpeedSpeedFruit();
        }
    }

    /**
     * This method represents the enemy's turn.
     *
     * @param theHero  the hero in the battle.
     * @param theEnemy the enemy in the battle.
     */
    public static void enemyTurn(final Hero theHero, final MazeCharacter theEnemy) {
        Random chance = new Random();
        if (chance.nextFloat() <= theEnemy.getSpecialChance()) {
            theEnemy.specialAttack(theHero);
        } else {
            theEnemy.attack(theHero);
        }
    }

    /**
     * This method determines the winner of the battle.
     *
     * @param theHero  the hero.
     * @param theEnemy the enemy.
     */
    public static void winner(final Hero theHero, final MazeCharacter theEnemy) {
        if (theEnemy.getHealthPoints() <= 0) {
            System.out.println("Victory");
        }
        if (theHero.getHealthPoints() <= 0) {
            System.out.println("Game Over");
        }
    }
}
