package View;

import Controller.InputControls;
import Model.Hero.Luffy;
import Model.Hero.Zoro;
import Model.MazeGenerator.Maze;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements Runnable {

    // Settings
    final int originalTileSize = 32;
    final int scale = 3;
    final int maxScreenCol = 12;
    final int maxScreenRow = 10;
    final int tileSize = originalTileSize * scale;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    Maze maze = new Maze(5, 10, 10);

    int FPS = 60;

    InputControls inputCon = new InputControls();
    Thread gameThread;


    //player
    Luffy player = new Luffy();



    public GameView() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputCon);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;

            while(gameThread != null){
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;

                lastTime = currentTime;

                if(delta >= 1) {
                    update();
                    repaint();
                    delta--;
                }
            }



        }
    }

    public void update() {
        player.update();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);

        maze.draw(g2);
        g2.dispose();
    }
}