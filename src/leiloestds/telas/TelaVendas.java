
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import leiloestds.classes.ConfigFrame;
import leiloestds.dados.ProdutoDAO;
import leiloestds.ferramentas.InfoBar;
import leiloestds.ferramentas.TableProdutos;
import leiloestds.shadows.PanelShadow;
import leiloestds.shadows.ShadowType;

public class TelaVendas {

    private final ConfigFrame configFrame;
    private JLayeredPane layerDefault;
    private JLayeredPane layeredPane;
    private PanelShadow pnlTitle;
    private PanelShadow pnlListaProdutos;
    private TableProdutos tabelaProdutos;
    
    
    public TelaVendas(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }
    
    
    public void configTelaVendas() {
        
        // Configura as layers
        configLayers();
        
        // Configura os painéis
        configPanels();
        
        // Configura os textos da tela
        configText();
        
        // Configura a tabela de produtos
        configTable();
        
        // Configura as imagens da tela
        configImages();
        
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
        
        // Painel título da tela
        pnlTitle = new PanelShadow(60);
        pnlTitle.setBounds(-50, 208, 866, 202);
        pnlTitle.setBackground(new Color(0xF1EEDC));
        pnlTitle.setShadowType(ShadowType.BOT);
        pnlTitle.setShadowSize(3);
        pnlTitle.setLayout(null);
        layeredPane.add(pnlTitle, JLayeredPane.DEFAULT_LAYER);
        
        // Painel para a lista de produtos
        pnlListaProdutos = new PanelShadow(60);
        pnlListaProdutos.setBounds(-50, 462, 1089, 392);
        pnlListaProdutos.setBackground(new Color(0xE5DDC5));
        pnlListaProdutos.setShadowType(ShadowType.BOT);
        pnlListaProdutos.setShadowSize(3);
        pnlListaProdutos.setLayout(null);
        layeredPane.add(pnlListaProdutos);
        
    }
    
    
    public void configText() {
        
        // Texto "Lista Vendas"
        JLabel lblListaProduto = new JLabel("Lista Vendas");
        lblListaProduto.setBounds(50, 23, 815, 145);
        lblListaProduto.setForeground(Color.BLACK);
        lblListaProduto.setFont(new Font("Trocchi", Font.PLAIN, 100));
        lblListaProduto.setHorizontalAlignment(JLabel.CENTER);
        pnlTitle.add(lblListaProduto);
        
    }
    
    
    public void configImages() {
        
        // Imagem da tela
        ImageIcon imgListaProduto = new ImageIcon(getClass().getResource("/images/ImgListaProdutos.png"));
        JLabel lblImgProduto = new JLabel();
        lblImgProduto.setBounds(1374, 0, 546, 751);
        lblImgProduto.setIcon(imgListaProduto);
        layeredPane.add(lblImgProduto, JLayeredPane.DEFAULT_LAYER);
        
        // Barra de informações do software
        InfoBar infoBar = new InfoBar();
        infoBar.setBounds(84, 935, 925, 85);
        layeredPane.add(infoBar, JLayeredPane.PALETTE_LAYER);
        
    }
    
    
    public void configTable() {
        
        ProdutoDAO dao = new ProdutoDAO();
        
        // Tabela de produtos
        tabelaProdutos = new TableProdutos(configFrame);
        tabelaProdutos.setBounds(50, 32, 1038, 328);
        tabelaProdutos.gerarTabela();
        tabelaProdutos.tabelaPersonalizada(dao.listarProdutosVendidos());
        pnlListaProdutos.add(tabelaProdutos);
        
    }
    
}
