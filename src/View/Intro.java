package View;

import Controller.GameManager;
import Controller.InputControls;
import Model.Hero.*;
import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Intro {
    private static final Hero[] myCharacterChoice = {new Luffy(), new Zoro(), new Nami(), new Chopper()};
    private static int choice = 0;

    static double selectedScaleLuffy = 1;
    static double selectedScaleZoro = 1;
    static double selectedScaleNami = 1;
    static double selectedScaleChopper = 1;

    private static int myX = 70;
    private static int myY = 200;






    public static void update(){

        if(InputControls.getRight()){
            if(choice == 3){
                choice = 0;
            } else{
                choice++;
            }

        }
        if(InputControls.getLeft()){
            if(choice == 0){
                choice = 3;
            } else{
                choice--;
            }

        }

        if(InputControls.getEnter()){
            GameManager.setHero(myCharacterChoice[choice]);
            Menus.setGameState("Maze");
        }



    }


    public static void draw(Graphics2D g){


        bobCharacter();
        g.setColor(Color.green);
        g.fillRect(0,0,1000,1000);

        g.drawImage(myCharacterChoice[0].getMyDefaultIm(), myX, myY, (int)(128*selectedScaleLuffy), (int)(128*selectedScaleLuffy), null);
        g.drawImage(myCharacterChoice[1].getMyDefaultIm(), myX+300, myY, (int)(128*selectedScaleZoro), (int)(128*selectedScaleZoro), null);
        g.drawImage(myCharacterChoice[2].getMyDefaultIm(), myX+600, myY, (int)(128*selectedScaleNami), (int)(128*selectedScaleNami), null);
        g.drawImage(myCharacterChoice[3].getMyDefaultIm(), myX+900, myY, (int)(128*selectedScaleChopper), (int)(128*selectedScaleChopper), null);


    }

    private static void bobCharacter(){
        if(choice == 0){
            if(selectedScaleLuffy < 1.5)selectedScaleLuffy += 0.05;
            if(selectedScaleLuffy > 1.5)selectedScaleLuffy = 1;

        }else{
            selectedScaleLuffy = 1;
        }if(choice == 1){
            if(selectedScaleZoro < 1.5)selectedScaleZoro += 0.05;
            if(selectedScaleZoro > 1.5)selectedScaleZoro = 1;
        }else{
            selectedScaleZoro = 1;
        }if(choice == 2){
            if(selectedScaleNami < 1.5)selectedScaleNami += 0.05;
            if(selectedScaleNami > 1.5)selectedScaleNami = 1;
        }else{
            selectedScaleNami = 1;
        }if(choice == 3){
            if(selectedScaleChopper < 1.5)selectedScaleChopper += 0.05;
            if(selectedScaleChopper > 1.5)selectedScaleChopper = 1;
        }else{
            selectedScaleChopper = 1;
        }
    }



}
