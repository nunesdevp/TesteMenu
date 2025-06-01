import input.Input;
import state.State;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Input Test");
        JPanel panel = new JPanel();

        Input input = new Input();
        State state = new State(input);

        panel.addMouseListener(input);
        panel.addMouseMotionListener(input);

        Timer timer = new Timer(100, e -> state.handleMouseInput());
        timer.start();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
