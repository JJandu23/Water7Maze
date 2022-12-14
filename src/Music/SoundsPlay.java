package Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to play sounds in the game.
 * It uses the javax.sound.sampled package to play sounds.
 * The sounds are stored as .wav files.
 * The class has a method to play a sound and a method to stop a sound.
 *
 * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
 * @version 1.0
 */
public class SoundsPlay {
    /**
     * The audio file to be played.
     */
    private static Clip myClip;

    /**
     * the instantiated class.
     */
    private SoundsPlay() {
        // Exists only to defeat instantiation.
    }

    /**
     * This method is used to play the music.
     *
     * @param theSong the song to be played
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public static void playSongs(final Song theSong) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = null;
         switch (theSong) {
            case OPENING:
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/Music/Opening.wav").getAbsoluteFile());
                break;
             case IN_GAME:
                 audioInputStream = AudioSystem.getAudioInputStream(new File("src/Music/In_Game.wav").getAbsoluteFile());
                 break;
             case DEATH:
                 audioInputStream = AudioSystem.getAudioInputStream(new File("src/Music/Death.wav").getAbsoluteFile());
                 break;
             case THE_ONE_PIECE:
                 audioInputStream = AudioSystem.getAudioInputStream(new File("src/Music/TheOnePieceIsReal.wav").getAbsoluteFile());
                 break;
             case SANS_NOISE:
                 audioInputStream = AudioSystem.getAudioInputStream(new File("src/Music/SansNoise.wav").getAbsoluteFile());
                 break;
         };
        if (audioInputStream != null) {
            if (myClip != null) {
                myClip.stop();
            }
            myClip = AudioSystem.getClip();
            myClip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) myClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-40.0f);
            myClip.start();
            myClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * The enum for the different sounds.
     *
     * @author Jashanpreet Jandu, Kevin Nguyen, Nicholas Zhuk
     * @version 1.0
     */
    public enum Song {
        OPENING, IN_GAME, DEATH, THE_ONE_PIECE, SANS_NOISE
    }
}
