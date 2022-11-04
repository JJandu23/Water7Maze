package View;

import Controller.InputControls;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements Runnable {

    // Settings
    final int originalTileSize = 32;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 10;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    InputControls keyInput = new InputControls();

    //Player
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    Thread gameThread;

    public GameView() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        InputControls keyInput = this.keyInput;
        keyInput.setInputs();
    }

    public void startGameThread(){
        System.out.println("Thread started");
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while(gameThread != null){

            update();

            repaint();

        }

    }

    public void update() {
        /*if(InputControls.isInput(0)){
            playerY -= playerSpeed;
            System.out.println("Goin Up");
        }*/


    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize, tileSize);

        g2.dispose();
     }
}
