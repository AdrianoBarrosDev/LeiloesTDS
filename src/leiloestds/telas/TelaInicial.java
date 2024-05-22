
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import leiloestds.classes.ConfigFrame;
import leiloestds.ferramentas.ImageSlider;
import leiloestds.ferramentas.InfoBar;
import leiloestds.ferramentas.LinesComponent;
import leiloestds.ferramentas.TextSlider;
import leiloestds.layouts.RoundedButtonRadius;
import leiloestds.shadows.PanelShadow;
import leiloestds.shadows.ShadowType;

public class TelaInicial implements ActionListener {

    private final ConfigFrame configFrame;
    private JLayeredPane layerDefault;
    private JLayeredPane layeredPane;
    private PanelShadow pnlInicial;
    private PanelShadow pnlSobre;
    private PanelShadow pnlSobreTema;
    private JPanel pnlSobreInfo;
    private RoundedButtonRadius btnProdutos;
    
    public TelaInicial(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }
    
    
    public void configTelaInicial() {
        
        // Configura as layers
        configLayers();
        
        // Configura os painéis
        configPanels();
        
        // Configura os textos da tela
        configText();
        
        // Configura as imagens da tela
        configImages();
        
        // Configura os botões
        configBtns();
        
        configFrame.getMainFrame().repaint();
        
    }
    
    
    public void configLayers() {
        
        layerDefault = configFrame.getManager().getTelas().getTelaDefault().getLayerDefault();
        
        // Configurações da JLayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1920, 1080);
        layeredPane.setLayout(null);
        layerDefault.add(layeredPane, JLayeredPane.PALETTE_LAYER);
        
    }
    
    
    public void configPanels() {
        
        pnlInicial = new PanelShadow(60);
        pnlInicial.setBounds(130, 235, 531, 725);
        pnlInicial.setBackground(new Color(0xF1EEDC));
        pnlInicial.setShadowType(ShadowType.BOT);
        pnlInicial.setShadowSize(3);
        pnlInicial.setLayout(null);
        layeredPane.add(pnlInicial, JLayeredPane.DEFAULT_LAYER);
        
        pnlSobre = new PanelShadow(60);
        pnlSobre.setBounds(769, 353, 498, 327);
        pnlSobre.setBackground(Color.WHITE);
        pnlSobre.setShadowSize(0);
        pnlSobre.setLayout(null);
        layeredPane.add(pnlSobre, JLayeredPane.DEFAULT_LAYER);
        
        pnlSobreTema = new PanelShadow(60);
        pnlSobreTema.setBounds(769, 353, 498, 297);
        pnlSobreTema.setBackground(new Color(0xE2E2E2));
        pnlSobreTema.setShadowSize(0);
        pnlSobreTema.setLayout(null);
        layeredPane.add(pnlSobreTema, JLayeredPane.PALETTE_LAYER);
        
        pnlSobreInfo = new JPanel();
        pnlSobreInfo.setBounds(0, 92, 498, 205);
        pnlSobreInfo.setBackground(Color.WHITE);
        pnlSobreInfo.setLayout(null);
        pnlSobreTema.add(pnlSobreInfo);
        
    }
    
    
    public void configText() {
        
        // Alinhamento dos parágrafos
        SimpleAttributeSet leftAlign = new SimpleAttributeSet();
        SimpleAttributeSet centerAlign = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(leftAlign, (float) 0.2);
        StyleConstants.setAlignment(leftAlign, StyleConstants.ALIGN_LEFT);
        StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
        
        // Texto "Encontre Grandes Oportunidades"
        JTextPane txaEncontre = new JTextPane();
        txaEncontre.setText("Encontre Grandes Oportunidades");
        txaEncontre.setBounds(52, 65, 421, 280);
        txaEncontre.setBackground(null);
        txaEncontre.setForeground(Color.BLACK);
        txaEncontre.setFont(new Font("Trocchi", Font.PLAIN, 56));
        txaEncontre.setParagraphAttributes(leftAlign, false);
        txaEncontre.setEditable(false);
        pnlInicial.add(txaEncontre);
        
        // Texto de boas vindas
        JTextPane txaInicial = new JTextPane();
        txaInicial.setText("Bem vindo ao software Leilões TDS! Tenha um gerenciamento completo de seus produtos cadastrando e vendendo-os quando forem leiloados. Consulte suas vendas e administre da forma que desejar.");
        txaInicial.setBounds(59, 388, 410, 180);
        txaInicial.setBackground(null);
        txaInicial.setForeground(Color.BLACK);
        txaInicial.setFont(new Font("Poppins", Font.PLAIN, 20));
        txaInicial.setParagraphAttributes(centerAlign, false);
        txaInicial.setEditable(false);
        pnlInicial.add(txaInicial);
        
        // Texto "Sobre"
        JLabel lblSobre = new JLabel("Sobre");
        lblSobre.setBounds(803, 302, 178, 51);
        lblSobre.setForeground(Color.BLACK);
        lblSobre.setFont(new Font("Poppins", Font.PLAIN, 35));
        layeredPane.add(lblSobre, JLayeredPane.PALETTE_LAYER);
        
        TextSlider textSlider = new TextSlider();
        textSlider.setBounds(769, 300, 498, 380);
        layeredPane.add(textSlider, JLayeredPane.MODAL_LAYER);
        
    }
    
    
    public void configImages() {
        
        LinesComponent lines = new LinesComponent();
        lines.setBounds(0, 0, 525, 365);
        lines.addLine(62, 359, 462, 359, 2, new Color(0x000000));
        pnlInicial.add(lines);
        
        ImageSlider imageSlider = new ImageSlider();
        imageSlider.setBounds(1374, 0, 546, 751);
        layeredPane.add(imageSlider, JLayeredPane.PALETTE_LAYER);
        
        InfoBar infoBar = new InfoBar();
        infoBar.setBounds(761, 834, 925, 85);
        layeredPane.add(infoBar, JLayeredPane.PALETTE_LAYER);
        
    }
    
    
    public void configBtns() {
        
        btnProdutos = new RoundedButtonRadius("Produtos", 15, new Color(0xE5DDC5));
        btnProdutos.setBounds(145, 605, 235, 58);
        btnProdutos.setBackground(new Color(0xE5DDC5));
        btnProdutos.setForeground(Color.BLACK);
        btnProdutos.setFont(new Font("Poppins", Font.BOLD, 23));
        btnProdutos.configBackgroundBtn();
        pnlInicial.add(btnProdutos.getPnlBackground());
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnProdutos) {
            layerDefault.remove(layeredPane);
            configFrame.getManager().getTelas().getTelaProdutos().configTelaProdutos();
        }
        
    }
    
    
}
