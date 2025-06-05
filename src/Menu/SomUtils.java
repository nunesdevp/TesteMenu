package Menu;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

// Utilitário para tocar sons do projeto
public class SomUtils {
    public static void tocarSom(String caminhoSom) {
        try {
            URL url = SomUtils.class.getResource(caminhoSom);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}