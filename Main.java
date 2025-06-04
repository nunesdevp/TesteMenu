import javax.swing.SwingUtilities;
import Menu.MenuInicial;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuInicial menu = new MenuInicial();
            menu.setVisible(true);
        });
    }
}