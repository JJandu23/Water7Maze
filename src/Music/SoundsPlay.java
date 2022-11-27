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

    private static Clip myClip;

    private SoundsPlay() {
        // Exists only to defeat instantiation.
    }

    public enum Song {
        Opening, In_Game, Death
    }

    /**
     * This method is used to play the music.
     *
     * @param theSong
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public static void playSongs(final Song theSong) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = switch (theSong) {
            case Opening -> AudioSystem.getAudioInputStream(new File("src/Music/Opening.wav").getAbsoluteFile());
            case In_Game -> AudioSystem.getAudioInputStream(new File("src/Music/In_Game.wav").getAbsoluteFile());
            case Death -> AudioSystem.getAudioInputStream(new File("src/Music/Death.wav").getAbsoluteFile());
        };
        if (audioInputStream != null) {
            myClip = AudioSystem.getClip();
            myClip.open(audioInputStream);
            myClip.start();
            myClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
