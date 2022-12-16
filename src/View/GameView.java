package View;

import Controller.GameManager;
import Controller.InputControls;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class is used to create the game view.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class GameView extends JPanel implements Runnable {

    // Settings
    /**
     * The title size of the game.
     */
    static final int originalTileSize = 32;

    /**
     * The scaling of the game.
     */
    static final int scale = 3;

    /**
     * The max col for the screen
     */
    static final int maxScreenCol = 12;

    /**
     * The max row for the screen
     */
    static final int maxScreenRow = 10;

    /**
     * The title size of the game.
     */
    static final int tileSize = originalTileSize * scale;

    /**
     * The width of the screen.
     */
    static final int screenWidth = tileSize * maxScreenCol; //1152

    /**
     * The height of the screen.
     */
    static final int screenHeight = tileSize * maxScreenRow; //960

    /**
     * The frame per second.
     */
    int FPS = 60;

    /**
     * The input controls.
     */
    InputControls inputCon = new InputControls();

    /**
     * The game thread.
     */
    Thread gameThread;

    /**
     * Constructor for game view.
     */
    public GameView() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputCon);
        this.setFocusable(true);
    }

    /**
     * This method gets the screen width.
     *
     * @return The screen width.
     */
    public static int getScreenWidth() {
        return screenWidth;
    }

    /**
     * This method gets the screen height.
     *
     * @return The screen height.
     */
    public static int getScreenHeight() {
        return screenHeight;
    }

    /**
     * This method is used to start the game thread.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * This method is used to run the game.
     * It is used to update the game and render the game.
     * It also sets the frame per second.
     */
    @Override
    public void run() {
        while (gameThread != null) {
            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            while (gameThread != null) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;
                if (delta >= 1) {
                    try {
                        update();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                             ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    repaint();
                    delta--;
                }
            }
        }
    }

    /**
     * This method is used to update the game.
     *
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException
     */
    public void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException, ClassNotFoundException {
        GameManager.update();
    }

    /**
     * This method is used to paint the game.
     *
     * @param theG The graphics.
     */
    public void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        Graphics2D g2 = (Graphics2D) theG;
        GameManager.draw(g2);
        g2.dispose();
    }
}