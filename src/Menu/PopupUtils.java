package Menu;

import javax.swing.*;
import java.awt.*;

public class PopupUtils {

    public static void mostrarMensagem(Component parent, String mensagem) {
        JDialog dialog = new JDialog((Dialog) SwingUtilities.getWindowAncestor(parent), "Mensagem", true);
        dialog.setSize(400, 220);
        dialog.setLocationRelativeTo(parent);

        // Fundo correto para o popup
        PainelComImagem painel = new PainelComImagem(Recursos.FUNDO_POPUP);
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("<html><div style='text-align:center;'>" + mensagem.replace("\n", "<br>") + "</div></html>");
        label.setFont(Estilo.FONTE_PADRAO);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton ok = new JButton("OK");
        ok.setFont(Estilo.FONTE_PADRAO);
        ok.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            dialog.dispose();
        });

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        botoes.add(ok);

        painel.add(label, BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        dialog.setContentPane(painel);
        dialog.setVisible(true);
    }

    public static void mostrarConfirmacao(Component parent, String mensagem, Runnable onConfirmar) {
        JDialog dialog = new JDialog((Dialog) SwingUtilities.getWindowAncestor(parent), "Confirmação", true);
        dialog.setSize(400, 220);
        dialog.setLocationRelativeTo(parent);

        // Fundo correto para o popup
        PainelComImagem painel = new PainelComImagem(Recursos.FUNDO_POPUP);
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("<html><div style='text-align:center;'>" + mensagem.replace("\n", "<br>") + "</div></html>");
        label.setFont(Estilo.FONTE_PADRAO);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnSim = new JButton("Sim");
        btnSim.setFont(Estilo.FONTE_PADRAO);
        btnSim.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            dialog.dispose();
            if (onConfirmar != null) onConfirmar.run();
        });

        JButton btnNao = new JButton("Não");
        btnNao.setFont(Estilo.FONTE_PADRAO);
        btnNao.addActionListener(e -> {
            SomUtils.tocarSom(Recursos.SOM_CLIQUE);
            dialog.dispose();
        });

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        botoes.add(btnSim);
        botoes.add(btnNao);

        painel.add(label, BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        dialog.setContentPane(painel);
        dialog.setVisible(true);
    }
}