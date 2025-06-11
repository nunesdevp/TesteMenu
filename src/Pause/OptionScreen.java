package Pause;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionScreen extends JFrame {
    private int volume = 50; // volume inicial de 0 a 100
    private JLabel volumeLabel;

    public OptionScreen() {
        setTitle("Opções de Volume");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel com background
        JPanel panel = new JPanel() {
            private Image background = new ImageIcon(getClass().getResource("/imagens/fundo_popup.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
        setContentPane(panel);

        // Label para mostrar volume
        volumeLabel = new JLabel("Volume: " + volume + "%");
        volumeLabel.setBounds(120, 50, 200, 30);
        volumeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        volumeLabel.setForeground(Color.WHITE);
        panel.add(volumeLabel);

        // Ícone para aumentar volume
        JLabel increaseIcon = new JLabel(new ImageIcon(getClass().getResource("/imagens/btn_aumentar.png")));
        increaseIcon.setBounds(250, 100, 64, 64);
        increaseIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(increaseIcon);

        // Ícone para diminuir volume
        JLabel decreaseIcon = new JLabel(new ImageIcon(getClass().getResource("/imagens/btn_diminuir.png")));
        decreaseIcon.setBounds(100, 100, 64, 64);
        decreaseIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(decreaseIcon);

        // Listeners para os ícones
        increaseIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (volume < 100) {
                    volume += 10;
                    updateVolume();
                }
            }
        });

        decreaseIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (volume > 0) {
                    volume -= 10;
                    updateVolume();
                }
            }
        });
    }

    private void updateVolume() {
        volumeLabel.setText("Volume: " + volume + "%");
        // Aqui você pode adicionar código para realmente alterar o volume do áudio do jogo
    }
}

