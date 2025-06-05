package Menu;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import input.Input;
import state.State;

public class MenuInicial extends JFrame {

    private BotaoImagem btnIniciar;
    private BotaoImagem btnComoJogar;
    private BotaoImagem btnSair;

    public MenuInicial() {
        setTitle("Menu Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Painel com fundo
        PainelComImagem fundo = new PainelComImagem(Recursos.FUNDO_MADEIRA);
        fundo.setLayout(new BorderLayout());

        // LayeredPane para sobrepor imagem de fundo e botões
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));
        fundo.setBounds(0, 0, 800, 600);

        // Painel para os botões
        JPanel botoesPanel = new JPanel(new GridBagLayout());
        botoesPanel.setOpaque(false);
        botoesPanel.setBounds(0, 0, 800, 600);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Logo "menu.png"
        URL imageUrl = getClass().getResource(Recursos.MENU);
        if (imageUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imageUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(180, 80, Image.SCALE_SMOOTH);
            JLabel menuLabel = new JLabel(new ImageIcon(scaledImage));
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 60, 0);
            botoesPanel.add(menuLabel, gbc);
        } else {
            System.err.println("Imagem 'menu' não encontrada!");
        }

        int largura = 240;
        int altura = 70;

        btnIniciar = new BotaoImagem("/imagens/btn_iniciar.png",280, altura);
        btnComoJogar = new BotaoImagem("/imagens/btn_como_jogar.png", largura, altura);
        btnSair = new BotaoImagem("/imagens/btn_sair.png", largura, altura);

        btnIniciar.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            PopupUtils.mostrarMensagem(this, "Sua jornada começa aqui!");
        });

        btnComoJogar.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            PopupUtils.mostrarMensagem(this, "➡ Pressione <u>ESPAÇO</u> para ultrapassar os obstáculos.<br><br>❌ Se colidir, você perde!");
        });

        btnSair.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            PopupUtils.mostrarConfirmacao(this, "Deseja mesmo sair?", () -> System.exit(0));
        });

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 35, 0);
        botoesPanel.add(btnIniciar, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 35, 0);
        botoesPanel.add(btnComoJogar, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 35, 0);
        botoesPanel.add(btnSair, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1;
        botoesPanel.add(Box.createVerticalGlue(), gbc);

        layeredPane.add(fundo, Integer.valueOf(0));
        layeredPane.add(botoesPanel, Integer.valueOf(1));
        add(layeredPane);

        // Input e timer
        Input input = new Input();
        State state = new State(input);
        botoesPanel.addMouseListener(input);
        botoesPanel.addMouseMotionListener(input);
        new Timer(100, e -> state.handleMouseInput()).start();
    }
}