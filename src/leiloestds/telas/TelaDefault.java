
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import leiloestds.layouts.RoundedButtonRadius;
import leiloestds.classes.ConfigFrame;

public class TelaDefault implements ActionListener {

    private final ConfigFrame configFrame;
    private JLayeredPane layerDefault;
    private JPanel pnlBlue;
    private JPanel pnlImages;
    private JPanel pnlBot;
    private RoundedButtonRadius btnHome;
    private RoundedButtonRadius btnCadastro;
    private RoundedButtonRadius btnProdutos;
    private RoundedButtonRadius btnVendas;
    
    public TelaDefault(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }

    
    public JLayeredPane getLayerDefault() {
        return layerDefault;
    }

    public JPanel getPnlBlue() {
        return pnlBlue;
    }

    public void setPnlBlue(JPanel pnlBlue) {
        this.pnlBlue = pnlBlue;
    }

    public JPanel getPnlImages() {
        return pnlImages;
    }

    public void setPnlImages(JPanel pnlImages) {
        this.pnlImages = pnlImages;
    }

    public JPanel getPnlBot() {
        return pnlBot;
    }

    public void setPnlBot(JPanel pnlBot) {
        this.pnlBot = pnlBot;
    }
    
    
    public void configTelaDefault() {
        
        // Configura as layers
        configLayers();
        
        // Configura os painéis
        configPanels();
        
        // Configura os botões
        configBtns();
    }
    
    
    public void configLayers() {
        
        layerDefault = new JLayeredPane();
        layerDefault.setBounds(0, 0, 1920, 1080);
        layerDefault.setLayout(null);
        
        configFrame.getMainFrame().add(layerDefault);
        
    }
    
    
    public void configPanels() {
        
        pnlBlue = new JPanel();
        pnlBlue.setBounds(0, 0, 1374, 751);
        pnlBlue.setBackground(new Color(0xB3C8CF));
        pnlBlue.setLayout(null);
        layerDefault.add(pnlBlue, JLayeredPane.DEFAULT_LAYER);
        
        pnlImages = new JPanel();
        pnlImages.setBounds(1374, 0, 546, 751);
        pnlImages.setBackground(new Color(0xBED7DC));
        pnlImages.setLayout(null);
        layerDefault.add(pnlImages, JLayeredPane.DEFAULT_LAYER);
        
        pnlBot = new JPanel();
        pnlBot.setBounds(0, 751, 1920, 329);
        pnlBot.setBackground(Color.WHITE);
        pnlBot.setLayout(null);
        layerDefault.add(pnlBot, JLayeredPane.DEFAULT_LAYER);
        
    }
    
    
    public void configBtns() {
        
        btnHome = new RoundedButtonRadius("LeilõesTDS", 0, null);
        btnHome.addActionListener(this);
        btnHome.setBounds(132, 75, 186, 52);
        btnHome.setForeground(Color.BLACK);
        btnHome.setFont(new Font("Trirong", Font.BOLD, 30));
        btnHome.setBorder(null);
        layerDefault.add(btnHome, JLayeredPane.DRAG_LAYER);
        
        btnCadastro = new RoundedButtonRadius("Cadastro", 0, null);
        btnCadastro.addActionListener(this);
        btnCadastro.setBounds(405, 79, 211, 38);
        btnCadastro.setForeground(Color.BLACK);
        btnCadastro.setFont(new Font("Trispace", Font.PLAIN, 25));
        btnCadastro.setBorder(null);
        layerDefault.add(btnCadastro, JLayeredPane.DRAG_LAYER);
        
        btnProdutos = new RoundedButtonRadius("Produtos", 0, null);
        btnProdutos.addActionListener(this);
        btnProdutos.setBounds(616, 79, 211, 38);
        btnProdutos.setForeground(Color.BLACK);
        btnProdutos.setFont(new Font("Trispace", Font.PLAIN, 25));
        btnProdutos.setBorder(null);
        layerDefault.add(btnProdutos, JLayeredPane.DRAG_LAYER);
        
        btnVendas = new RoundedButtonRadius("Vendas", 0, null);
        btnVendas.addActionListener(this);
        btnVendas.setBounds(827, 79, 211, 38);
        btnVendas.setForeground(Color.BLACK);
        btnVendas.setFont(new Font("Trispace", Font.PLAIN, 25));
        btnVendas.setBorder(null);
        layerDefault.add(btnVendas, JLayeredPane.DRAG_LAYER);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnHome) {
            configFrame.getMainFrame().remove(layerDefault);
            configTelaDefault();
            configFrame.getManager().getTelas().getTelaInicial().configTelaInicial();
            configFrame.getMainFrame().repaint();
            
        } else if(e.getSource() == btnCadastro) {
            configFrame.getMainFrame().remove(layerDefault);
            configTelaDefault();
            configFrame.getManager().getTelas().getTelaCadastro().configTelaCadastro();
            configFrame.getMainFrame().repaint();
            
        } else if(e.getSource() == btnProdutos) {
            configFrame.getMainFrame().remove(layerDefault);
            configTelaDefault();
            configFrame.getManager().getTelas().getTelaProdutos().configTelaProdutos();
            configFrame.getMainFrame().repaint();
            
        } else if(e.getSource() == btnVendas) {
            configFrame.getMainFrame().remove(layerDefault);
            configTelaDefault();
            configFrame.getManager().getTelas().getTelaVendas().configTelaVendas();
            configFrame.getMainFrame().repaint();
            
        }
        
    }
    
    
}
