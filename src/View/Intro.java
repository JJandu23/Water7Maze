package View;

import Controller.GameManager;
import Controller.InputControls;
import Model.Hero.*;
import Model.MazeCharacter;
import View.GameView;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Intro {
    private static final Hero[] myCharacterChoice = {new Luffy(), new Zoro(), new Nami(), new Chopper()};
    private static int choice = 0;


    private static double sinX =0;

    static double selectedScaleLuffy = 1;
    static double selectedScaleZoro = 1;
    static double selectedScaleNami = 1;
    static double selectedScaleChopper = 1;

    private static int myX = 60;
    private static int myY = 200;
    private static BufferedImage luffyTxt;
    private static BufferedImage namiTxt;
    private static BufferedImage chopperTxt;
    private static BufferedImage boxTxt;
    private static BufferedImage zoroTxt;
    static{
        try{
            luffyTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/luffytext.png"));
            zoroTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/zorotext.png"));
            namiTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/namitext.png"));
            chopperTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/choppertext.png"));
            boxTxt = ImageIO.read(Intro.class.getResourceAsStream("../View/Sprites/textbox.png"));

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }






    public static void update(){

        if(InputControls.getRight()){
            sinX = 0;
            try{
                Thread.sleep(150);
            } catch (Exception e){
                System.out.println(e);
            }

            if(choice == 3){
                choice = 0;
            } else{
                choice++;
            }

        }
        if(InputControls.getLeft()){
            sinX = 0;
            try{
                Thread.sleep(150);
            } catch (Exception e){
                System.out.println(e);
            }
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
        BufferedImage img = null;


        if(choice == 0) img = luffyTxt;
        if(choice == 1) img = zoroTxt;
        if(choice == 2) img = namiTxt;
        if(choice == 3) img = chopperTxt;




        bobCharacter();
        g.setColor(Color.darkGray);
        g.fillRect(0,0,GameView.getScreenWidth(),GameView.getScreenHeight());
        g.drawImage(boxTxt,0,0,null );
        g.drawImage(img, 0,0,null);


        g.drawImage(myCharacterChoice[0].getMyDefaultIm(), myX - ((int)(selectedScaleLuffy*64) - 64 ), myY - ((int)(selectedScaleLuffy*64) - 64 ), (int)(128*selectedScaleLuffy), (int)(128*selectedScaleLuffy), null);
        g.drawImage(myCharacterChoice[1].getMyDefaultIm(), myX+300 - ((int)(selectedScaleZoro*64) - 64 ), myY - ((int)(selectedScaleZoro*64) - 64 ), (int)(128*selectedScaleZoro), (int)(128*selectedScaleZoro), null);
        g.drawImage(myCharacterChoice[2].getMyDefaultIm(), myX+600 - ((int)(selectedScaleNami*64) - 64 ), myY - ((int)(selectedScaleNami*64) - 64 ), (int)(128*selectedScaleNami), (int)(128*selectedScaleNami), null);
        g.drawImage(myCharacterChoice[3].getMyDefaultIm(), myX+900 - ((int)(selectedScaleChopper*64) - 64 ), myY - ((int)(selectedScaleChopper*64) - 64 ), (int)(128*selectedScaleChopper), (int)(128*selectedScaleChopper), null);




    }

    private static void bobCharacter(){
        int size = 6;
        if(choice == 0){
            sinX += 0.2;
            selectedScaleLuffy = 1 + (Math.sin(sinX))/size;
        }else{
            selectedScaleLuffy = 1;
        }if(choice == 1){
            sinX += 0.2;
            selectedScaleZoro = 1 + (Math.sin(sinX))/size;
        }else{
            selectedScaleZoro = 1;
        }if(choice == 2){
            sinX += 0.2;
            selectedScaleNami = 1 + (Math.sin(sinX))/size;
        }else{
            selectedScaleNami = 1;
        }if(choice == 3){
            sinX += 0.2;
            selectedScaleChopper = 1 + (Math.sin(sinX))/size;
        }else{
            selectedScaleChopper = 1;
        }
    }



}
