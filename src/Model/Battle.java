package Model;
import Controller.GameManager;
import Controller.InputControls;
import Model.Enemy.EnemyFactory;
import Model.Hero.Hero;
import Model.Hero.Luffy;
import Model.MazeGenerator.Maze;
import View.BattleView;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static Controller.InputControls.*;

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
    private Hero myHero;

    /**
     * The enemy object.
     */
    private MazeCharacter myEnemy;

    private BattleView myViewer;

    private static Graphics2D myGraphics;
    /**
     * This method is used to control the battle.
     *
     * @param theHero  the hero object.
     * @param theEnemy the enemy object.
     */

    public Battle(Hero theHero, MazeCharacter theEnemy, BattleView theViewer) {
        myViewer = theViewer;
        myHero = theHero;
        myEnemy = theEnemy;

        gamePlay(myHero, myEnemy);
    }


    /**
     * This method controls the gameplay of the battle .
     *
     */
    public void gamePlay(final Hero theHero, final MazeCharacter theEnemy) {
        while (theHero.isAlive() && theEnemy.isAlive()) {
            myViewer.draw(myGraphics);
            battlePhase(theHero, theEnemy);
        }
        winner(theHero, theEnemy);
    }

    /**
     * This method represents the battle phase.
     *
     * @param theHero    the hero in the battle.
     * @param theEnemy   the enemy in the battle.
     */
    public void battlePhase(final Hero theHero, final MazeCharacter theEnemy) {
        char choice = '\0';
        while(choice == '\0'){
            choice = getChoice();
        }
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
     *
     * @return the choice of the user.
     */
    public char getChoice() {
        System.out.println("What would you like to do?");
        System.out.println("j. Attack");
        System.out.println("k. Special Attack");
        System.out.println("p. Use Senzu Bean");
        System.out.println("o. Use power power fruit");
        System.out.println("l. Use speed speed fruit");
        if(getJ()){return 'j';}
        if(getK()){return 'k';}
        if(getP()){return 'p';}
        if(getO()){return 'o';}
        if(getL()){return 'l';}
        return '\0';
    }

    /**
     * This method represents the hero's turn.
     *
     * @param theChoice the choice of the user.
     * @param theHero   the hero in the battle.
     * @param theEnemy  the enemy in the battle.
     */
    public void heroTurn(final char theChoice, final Hero theHero, final MazeCharacter theEnemy) {
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
    public void enemyTurn(final Hero theHero, final MazeCharacter theEnemy) {
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
    public void winner(final Hero theHero, final MazeCharacter theEnemy) {
        if (theHero.isAlive()) {
            System.out.println("You have defeated " + theEnemy.getName() + "!");
            theHero.randomItem();
            Maze.killEnemy();
            Maze.getCurrentRoom().setRoomEnemy(null);
        } else {
            System.out.println("You have been defeated by " + theEnemy.getName() + "!");
        }
    }


    public static void giveGraphics(Graphics2D theG){
        myGraphics = theG;
    }
    public void update(){

    }


}
