
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import leiloestds.classes.ConfigFrame;
import leiloestds.dados.ProdutoDAO;
import leiloestds.ferramentas.InfoBar;
import leiloestds.ferramentas.TableProdutos;
import leiloestds.shadows.ButtonShadow;
import leiloestds.shadows.PanelShadow;
import leiloestds.shadows.ShadowType;
import leiloestds.shadows.TextFieldShadow;

public class TelaProdutos implements ActionListener {

    private final ConfigFrame configFrame;
    private JLayeredPane layerDefault;
    private JLayeredPane layeredPane;
    private PanelShadow pnlTitle;
    private PanelShadow pnlVender;
    private PanelShadow pnlListaProdutos;
    private PanelShadow pnlTitleVender;
    private ButtonShadow btnVender;
    private TextFieldShadow txtId;
    private TableProdutos tabelaProdutos;
    
    
    public TelaProdutos(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }
    
    
    public void configTelaProdutos() {
        
        // Configura as layers
        configLayers();
        
        // Configura os painéis
        configPanels();
        
        // Configura os textos da tela
        configText();
        
        // Configura os campos de texto
        configTxt();
        
        // Configura os botões
        configBtns();
        
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
        
        // Painel principal para a venda dos produtos
        pnlVender = new PanelShadow(60);
        pnlVender.setBounds(-50, 462, 1089, 392);
        pnlVender.setBackground(new Color(0xF1EEDC));
        pnlVender.setShadowType(ShadowType.BOT);
        pnlVender.setShadowSize(3);
        pnlVender.setLayout(null);
        layeredPane.add(pnlVender, JLayeredPane.DEFAULT_LAYER);
        
        // Painel para o título "Vender Produtos"
        pnlTitleVender = new PanelShadow(30);
        pnlTitleVender.setBounds(92, 44, 440, 78);
        pnlTitleVender.setBackground(new Color(0xE5DDC5));
        pnlTitleVender.setShadowType(ShadowType.BOT);   
        pnlTitleVender.setShadowSize(1);
        pnlTitleVender.setLayout(null);
        pnlVender.add(pnlTitleVender);
        
        // Painel para a lista de produtos
        pnlListaProdutos = new PanelShadow(60);
        pnlListaProdutos.setBounds(571, 0, 518, 392);
        pnlListaProdutos.setBackground(new Color(0xE5DDC5));
        pnlListaProdutos.setShadowType(ShadowType.BOT);
        pnlListaProdutos.setShadowSize(3);
        pnlListaProdutos.setLayout(null);
        pnlVender.add(pnlListaProdutos);
        
    }
    
    
    public void configText() {
        
        // Texto "Novo Produto"
        JLabel lblListaProduto = new JLabel("Novo Produto");
        lblListaProduto.setBounds(50, 23, 815, 145);
        lblListaProduto.setForeground(Color.BLACK);
        lblListaProduto.setFont(new Font("Trocchi", Font.PLAIN, 100));
        lblListaProduto.setHorizontalAlignment(JLabel.CENTER);
        pnlTitle.add(lblListaProduto);
        
        // Texto "Vender Produtos"
        JLabel lblVenderProdutos = new JLabel("Vender Produtos");
        lblVenderProdutos.setBounds(30, 14, 381, 50);
        lblVenderProdutos.setForeground(Color.BLACK);
        lblVenderProdutos.setFont(new Font("Trocchi", Font.BOLD, 35));
        lblVenderProdutos.setHorizontalAlignment(JLabel.CENTER);
        pnlTitleVender.add(lblVenderProdutos);
        
        // Texto "ID do Produto"
        JLabel lblNome = new JLabel("ID do Produto");
        lblNome.setBounds(132, 179, 197, 34);
        lblNome.setForeground(Color.BLACK);
        lblNome.setFont(new Font("Poppins", Font.PLAIN, 25));
        pnlVender.add(lblNome);
        
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
    
    
    public void configTxt() {
        
        // Campo de texto para o valor do produto
        txtId = new TextFieldShadow(40);
        txtId.setBounds(338, 174, 155, 44);
        txtId.setBackground(Color.WHITE);
        txtId.setForeground(Color.BLACK);
        txtId.setShadowSize(1);
        txtId.setFont(new Font("Poppins", Font.PLAIN, 18));
        pnlVender.add(txtId);
        
    }
    
    
    public void configBtns() {
        
        // Botão para vender os produtos
        btnVender = new ButtonShadow("Vender", 25);
        btnVender.addActionListener(this);
        btnVender.setBounds(221, 279, 182, 45);
        btnVender.setBackground(new Color(0xE5DDC5));
        btnVender.setForeground(Color.BLACK);
        btnVender.setShadowType(ShadowType.BOT);
        btnVender.setShadowSize(1);
        btnVender.setFont(new Font("Poppins", Font.BOLD, 23));
        btnVender.changeColors(new Color(0xE5DDC5), new Color(0xBBB091));
        pnlVender.add(btnVender);
        
    }
    
    
    public void configTable() {
        
        // Tabela de produtos
        tabelaProdutos = new TableProdutos(configFrame);
        tabelaProdutos.setBounds(1, 32, 514, 328);
        tabelaProdutos.gerarTabela();
        pnlListaProdutos.add(tabelaProdutos);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnVender) {
            
            try {
                
                ProdutoDAO dao = new ProdutoDAO();
                dao.venderProduto(Integer.parseInt(txtId.getText()));
                
                tabelaProdutos.atualizarTabela();
                
                txtId.setText("");
                configFrame.getMainFrame().repaint();
                
            } catch(NumberFormatException ex) {
                System.out.println("Erro ao vender o produto com este ID!");
            }
            
        }
        
    }
    
}
