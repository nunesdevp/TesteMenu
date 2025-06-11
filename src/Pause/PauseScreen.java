package Pause;

import javax.swing.*;
import java.awt.*;

import Menu.MenuInicial;
import javax.swing.SwingUtilities;



public class PauseScreen extends JFrame {

    public PauseScreen() {
        setTitle("Pause");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        PausePanel panel = new PausePanel();
        add(panel);
        setVisible(true);
    }

    static class PausePanel extends JPanel {
        private Image background;
        private JButton restartButton,playButton, optionsButton, exitButton;

        public PausePanel() {
            setLayout(null);
            // Carregar imagem de fundo
            background = new ImageIcon(getClass().getResource("/imagens/fundo_madeira.png")).getImage();

            ImageIcon tituloIcon = new ImageIcon(getClass().getResource("/imagens/menuPause.png"));
            JLabel tituloLabel = new JLabel(tituloIcon);
            tituloLabel.setBounds(325, 20, tituloIcon.getIconWidth(), tituloIcon.getIconHeight());

            add(tituloLabel);

            int largura = 290;
            int altura = 70;

            // Criar botões com imagens
            restartButton = createButton("/imagens/atualizar.png",380, 150,80,50);
            playButton = createButton("/imagens/btn_iniciar.png", largura, 240,300,80);
            optionsButton = createButton("/imagens/btn_como_jogar.png", 300, 350,250,80);
            exitButton = createButton("/imagens/btn_sair.png", 300, 450,250,80);

            // Adicionar listeners
            restartButton.addActionListener(e -> {
                // Criar e exibir a janela do jogo
                //GameScreen game = new GameScreen();
                //game.setVisible(true);

                // Fechar a janela de pausa atual
                //SwingUtilities.getWindowAncestor(this).dispose();
                JOptionPane.showMessageDialog(this, "RESTART");
            });
            playButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Voltar ao jogo"));
            optionsButton.addActionListener(e -> {
                OptionScreen optionScreen = new OptionScreen();
                optionScreen.setVisible(true);
            });

            exitButton.addActionListener(e -> {
                // Criar e exibir a janela do MenuInicial
                MenuInicial menu = new MenuInicial();
                menu.setVisible(true);

                // Fechar a janela atual de pausa
                SwingUtilities.getWindowAncestor(this).dispose();
            });


            add(restartButton);
            add(playButton);
            add(optionsButton);
            add(exitButton);
        }

        private JButton createButton(String imagePath, int x, int y,int width, int height) {
            int largura = width;
            int altura = height;
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image img = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
            JButton button = new JButton(new ImageIcon(img));
            button.setBounds(x, y, largura, altura);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            return button;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

