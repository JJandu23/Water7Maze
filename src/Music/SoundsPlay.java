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

    private SoundsPlay() {
        // Exists only to defeat instantiation.
    }

    public enum Song {
        OPENING, IN_GAME, DEATH, THE_ONE_PIECE
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
        AudioInputStream audioInputStream = switch (theSong) {
            case OPENING -> AudioSystem.getAudioInputStream(new File("src/Music/Opening.wav").getAbsoluteFile());
            case IN_GAME -> AudioSystem.getAudioInputStream(new File("src/Music/In_Game.wav").getAbsoluteFile());
            case DEATH -> AudioSystem.getAudioInputStream(new File("src/Music/Death.wav").getAbsoluteFile());
            case THE_ONE_PIECE -> AudioSystem.getAudioInputStream(new File("src/Music/TheOnePiece.wav").getAbsoluteFile());
        };
        if (audioInputStream != null) {
            myClip = AudioSystem.getClip();
            myClip.open(audioInputStream);
            myClip.start();
            myClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
