import javax.swing.SwingUtilities;
import Menu.MenuInicial;
import Pause.PauseScreen;


public class Main {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            //MenuInicial menu = new MenuInicial();
            //menu.setVisible(true);

           PauseScreen pause = new PauseScreen();
           pause.setVisible(true);
        });
    }
}