package Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

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
