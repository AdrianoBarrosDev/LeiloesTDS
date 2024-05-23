
package leiloestds.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import leiloestds.classes.ConfigFrame;
import leiloestds.dados.Produto;
import leiloestds.dados.ProdutoDAO;
import leiloestds.ferramentas.InfoBar;
import leiloestds.shadows.ButtonShadow;
import leiloestds.shadows.PanelShadow;
import leiloestds.shadows.ShadowType;
import leiloestds.shadows.TextFieldShadow;

public class TelaCadastro implements ActionListener {

    private final ConfigFrame configFrame;
    private JLayeredPane layerDefault;
    private JLayeredPane layeredPane;
    private PanelShadow pnlNovoProduto;
    private PanelShadow pnlCadastro;
    private ButtonShadow btnCadastrar;
    private TextFieldShadow txtNome;
    private TextFieldShadow txtValor;
    
    public TelaCadastro(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }
    
    public void configTelaCadastro() {
        
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
        pnlNovoProduto = new PanelShadow(60);
        pnlNovoProduto.setBounds(-50, 208, 866, 202);
        pnlNovoProduto.setBackground(new Color(0xF1EEDC));
        pnlNovoProduto.setShadowType(ShadowType.BOT);
        pnlNovoProduto.setShadowSize(3);
        pnlNovoProduto.setLayout(null);
        layeredPane.add(pnlNovoProduto, JLayeredPane.DEFAULT_LAYER);
        
        // Painel para o cadastro
        pnlCadastro = new PanelShadow(60);
        pnlCadastro.setBounds(-50, 462, 1195, 392);
        pnlCadastro.setBackground(new Color(0xF1EEDC));
        pnlCadastro.setShadowType(ShadowType.BOT);
        pnlCadastro.setShadowSize(3);
        pnlCadastro.setLayout(null);
        layeredPane.add(pnlCadastro, JLayeredPane.DEFAULT_LAYER);
        
    }
    
    
    public void configText() {
        
        // Texto "Novo Produto"
        JLabel lblNovoProduto = new JLabel("Novo Produto");
        lblNovoProduto.setBounds(50, 23, 815, 145);
        lblNovoProduto.setForeground(Color.BLACK);
        lblNovoProduto.setFont(new Font("Trocchi", Font.PLAIN, 100));
        lblNovoProduto.setHorizontalAlignment(JLabel.CENTER);
        pnlNovoProduto.add(lblNovoProduto);
        
        // Texto "Nome"
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(384, 52, 210, 34);
        lblNome.setForeground(Color.BLACK);
        lblNome.setFont(new Font("Poppins", Font.PLAIN, 25));
        pnlCadastro.add(lblNome);
        
        // Texto "Valor"
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(384, 160, 210, 34);
        lblValor.setForeground(Color.BLACK);
        lblValor.setFont(new Font("Poppins", Font.PLAIN, 25));
        pnlCadastro.add(lblValor);
        
    }
    
    
    public void configImages() {
        
        // Imagem da tela
        ImageIcon imgNovoProduto = new ImageIcon(getClass().getResource("/images/ImgNovoProduto.png"));
        JLabel lblImgProduto = new JLabel();
        lblImgProduto.setBounds(1374, 0, 546, 751);
        lblImgProduto.setIcon(imgNovoProduto);
        layeredPane.add(lblImgProduto, JLayeredPane.DEFAULT_LAYER);
        
        // Barra de informações do software
        InfoBar infoBar = new InfoBar();
        infoBar.setBounds(84, 935, 925, 85);
        layeredPane.add(infoBar, JLayeredPane.PALETTE_LAYER);
        
    }
    
    
    public void configTxt() {
        
        // Campo de texto para o nome do produto
        txtNome = new TextFieldShadow(50);
        txtNome.setBounds(362, 86, 422, 53);
        txtNome.setBackground(Color.WHITE);
        txtNome.setForeground(Color.BLACK);
        txtNome.setShadowSize(1);
        txtNome.setFont(new Font("Poppins", Font.PLAIN, 18));
        pnlCadastro.add(txtNome);
        
        // Campo de texto para o valor do produto
        txtValor = new TextFieldShadow(50);
        txtValor.setBounds(362, 194, 422, 53);
        txtValor.setBackground(Color.WHITE);
        txtValor.setForeground(Color.BLACK);
        txtValor.setShadowSize(1);
        txtValor.setFont(new Font("Poppins", Font.PLAIN, 18));
        pnlCadastro.add(txtValor);
        
    }
    
    
    public void configBtns() {
        
        // Botão para cadastrar os produtos
        btnCadastrar = new ButtonShadow("Cadastrar", 25);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setBounds(456, 296, 235, 58);
        btnCadastrar.setBackground(new Color(0xE5DDC5));
        btnCadastrar.setForeground(Color.BLACK);
        btnCadastrar.setShadowType(ShadowType.BOT);
        btnCadastrar.setShadowSize(1);
        btnCadastrar.setFont(new Font("Poppins", Font.BOLD, 23));
        btnCadastrar.changeColors(new Color(0xE5DDC5), new Color(0xBBB091));
        pnlCadastro.add(btnCadastrar);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnCadastrar) {
            
            try {
                
                Produto produto = new Produto();
                produto.setNome(txtNome.getText());
                produto.setValor(Integer.parseInt(txtValor.getText()));
                produto.setStatus("À venda");
                
                ProdutoDAO dao = new ProdutoDAO();
                dao.cadastrarProduto(produto);
                
                TelaContinuar telaContinuar = new TelaContinuar(configFrame);
                telaContinuar.configTelaContinuar();
                
                txtNome.setText("");
                txtValor.setText("");
                configFrame.getMainFrame().repaint();
                
            } catch(NumberFormatException ex) {
                System.out.println("Erro ao adicionar produto no banco de dados!");
            }
            
        }
        
    }
    
}
