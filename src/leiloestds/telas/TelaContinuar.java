
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import leiloestds.classes.ConfigFrame;
import leiloestds.layouts.RoundedButtonRadius;

public class TelaContinuar implements ActionListener {
    
    private final ConfigFrame configFrame;
    private final JComponent tela;
    private JLayeredPane layersConfirmar;
    private RoundedButtonRadius btnContinuar;
    private RoundedButtonRadius btnLista; 
    
    public TelaContinuar(ConfigFrame configFrame) {
        this.configFrame = configFrame;
        this.tela = configFrame.getManager().getTelas().getTelaDefault().getLayerDefault();
    }
    
    
    public void configTelaContinuar() {
        
        // Configura as novas layers
        configLayers();
        
        // Configura os elementos da tela
        configImgs();
        configLabels();
        configBtn();
        
        configFrame.getMainFrame().repaint();
        
    }
    
    
    public void configLayers() {
        
        // Configurações da layeredPane
        layersConfirmar = new JLayeredPane();
        layersConfirmar.setBounds(0, 0, 1920, 1080);
        layersConfirmar.setLayout(null);
        
        configFrame.getMainFrame().remove(tela);
        layersConfirmar.add(tela, JLayeredPane.DEFAULT_LAYER);
        configFrame.getMainFrame().add(layersConfirmar);
        
    }
    
    
    public void configImgs() {
        
        // Imagem transparente que deixa a tela mais escura
        ImageIcon imgMask = new ImageIcon(getClass().getResource("/images/Mask.png"));
        JLabel lblMask = new JLabel();
        lblMask.setBounds(0, 0, imgMask.getIconWidth(), imgMask.getIconHeight());
        lblMask.setIcon(imgMask);
        layersConfirmar.add(lblMask, JLayeredPane.PALETTE_LAYER);
        
        // Painel de informações
        ImageIcon imgPanel = new ImageIcon(getClass().getResource("/images/PanelConfirmar.png"));
        JLabel lblPanel = new JLabel();
        lblPanel.setBounds(739, 433, imgPanel.getIconWidth(), imgPanel.getIconHeight()); // 426
        lblPanel.setIcon(imgPanel);
        layersConfirmar.add(lblPanel, JLayeredPane.MODAL_LAYER);
        
        // GIF
        ImageIcon gifPanel = new ImageIcon(getClass().getResource("/images/Check.gif"));
        gifPanel.setImage(gifPanel.getImage().getScaledInstance(143, 143, Image.SCALE_DEFAULT));
        JLabel lblCheck = new JLabel();
        lblCheck.setBounds(888, 355, gifPanel.getIconWidth(), gifPanel.getIconHeight()); // 426
        lblCheck.setIcon(gifPanel);
        layersConfirmar.add(lblCheck, JLayeredPane.MODAL_LAYER);
        
    }
    
    
    public void configLabels() {
        
        // Inicializando o atributo
        SimpleAttributeSet atributo = new SimpleAttributeSet();
        // Alinhando o texto no centro
        StyleConstants.setAlignment(atributo, StyleConstants.ALIGN_CENTER);
        
        // Texto "Consulta Marcada"
        JLabel lblTitle = new JLabel("Produto Adicionado");
        lblTitle.setBounds(759, 484, 400, 27);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Poppins", Font.BOLD, 20));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        layersConfirmar.add(lblTitle, JLayeredPane.POPUP_LAYER);
        
        // Configurações da TextPane
        JTextPane txa = new JTextPane();
        txa.setText("O produto inserido foi adicionado com sucesso! Você deseja adicionar outro produto?");
        txa.setBackground(new Color(0xF5EDED));
        txa.setBounds(759, 521, 400, 51);
        txa.setForeground(new Color(0x777777));
        txa.setFont(new Font("Poppins", Font.PLAIN, 15));
        txa.setParagraphAttributes(atributo, false);
        layersConfirmar.add(txa, JLayeredPane.POPUP_LAYER);
        
    }
    
    
    public void configBtn() {
        
        // Configurações do botão "Adicionar"
        btnContinuar = new RoundedButtonRadius("Adicionar", 10, new Color(0x289B2D));
        btnContinuar.addActionListener(this);
        btnContinuar.setBounds(977, 592, 182, 39);
        btnContinuar.setBackground(new Color(0x289B2D));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFont(new Font("Volkhov", Font.BOLD, 18));
        btnContinuar.setFocusable(false);
        btnContinuar.configBackgroundBtn();
        btnContinuar.getPnlBackground().setBackground(new Color(0x289B2D));
        layersConfirmar.add(btnContinuar.getPnlBackground(), JLayeredPane.POPUP_LAYER);
        
        // Configurações do botão "Voltar"
        btnLista = new RoundedButtonRadius("Consultar Vendas", 10, new Color(0x289B2D));
        btnLista.addActionListener(this);
        btnLista.setBounds(759, 592, 182, 39);
        btnLista.setBackground(new Color(0x289B2D));
        btnLista.setForeground(new Color(0x289B2D));
        btnLista.setFont(new Font("Volkhov", Font.BOLD, 18));
        btnLista.setFocusable(false);
        layersConfirmar.add(btnLista, JLayeredPane.POPUP_LAYER);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Se o botão continuar for pressionado
        if(e.getSource() == btnContinuar) {
            
            // Remove a tela de confirmação
            configFrame.getMainFrame().remove(layersConfirmar);
            configFrame.getMainFrame().add(tela);
            configFrame.getMainFrame().repaint();
            
        } else if(e.getSource() == btnLista) {
            
            // Abre o perfil da clínica
            layersConfirmar.remove(tela);
            configFrame.getMainFrame().remove(layersConfirmar);
            configFrame.getMainFrame().remove(configFrame.getManager().getTelas().getTelaDefault().getLayerDefault());
            configFrame.getManager().getTelas().getTelaDefault().configTelaDefault();
            configFrame.getManager().getTelas().getTelaProdutos().configTelaProdutos();
            configFrame.getMainFrame().repaint();
            
        }
        
    }
    
    
    
}
