package Model;

import Model.Enemy.EnemyFactory;
import Model.Hero.Hero;
import Model.Hero.Luffy;

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
        while (theHero.isAlive() && theEnemy.isAlive()) {
            battlePhase(theHero, theEnemy, theConsole);
        }
        winner(theHero, theEnemy);
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
        switch (choice) {
            case 'j':
                return 'j';
            case 'k':
                return 'k';
            case 'p':
                return 'p';
            case 'o':
                return 'o';
            case 'l':
                return 'l';
            default:
                System.out.println("Invalid choice. Please try again.");
                return getChoice(theConsole);
        }
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
        if (theHero.isAlive()) {
            System.out.println("You have defeated " + theEnemy.getName() + "!");
            theHero.randomItem();
        } else {
            System.out.println("You have been defeated by " + theEnemy.getName() + "!");
        }
    }
}
