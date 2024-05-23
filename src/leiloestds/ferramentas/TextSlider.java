
package leiloestds.ferramentas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import leiloestds.shadows.CircleButtonShadow;

public class TextSlider extends JLayeredPane implements ActionListener {
    
    private final ImageIcon imgArrow;
    private JLabel lblFirstTitle;
    private JLabel lblSecondTitle;
    private JLabel lblThirdTitle;
    private JTextPane lblFirstText;
    private JTextPane lblSecondText;
    private JTextPane lblThirdText;
    private CircleButtonShadow leftBtn;
    private CircleButtonShadow rightBtn;
    private CircleButtonShadow btnSelecionado;
    private Timer timer;
    
    public TextSlider() {
        
        setLayout(null);
        
        imgArrow = new ImageIcon(getClass().getResource("/images/Arrow.png"));
        
        // Configura as imagens iniciais
        configTexts();
        
        // Configura os botões
        configBtns();
        
    }
    
    
    public final void configTexts() {
        
        // Título "Cadastro de Produtos"
        lblFirstTitle = new JLabel("Cadastro de Produtos");
        lblFirstTitle.setBounds(0, 81, 498, 38);
        lblFirstTitle.setForeground(Color.BLACK);
        lblFirstTitle.setFont(new Font("Poppins", Font.PLAIN, 30));
        lblFirstTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblFirstTitle, JLayeredPane.DEFAULT_LAYER);
        
        // Título "Gerenciamento de Produtos"
        lblSecondTitle = new JLabel("Gerenciamento de Produtos");
        lblSecondTitle.setBounds(498, 81, 498, 38);
        lblSecondTitle.setForeground(Color.BLACK);
        lblSecondTitle.setFont(new Font("Poppins", Font.PLAIN, 30));
        lblSecondTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblSecondTitle, JLayeredPane.DEFAULT_LAYER);
        
        // Título "Vendas dos Produtos"
        lblThirdTitle = new JLabel("Vendas de Produtos");
        lblThirdTitle.setBounds(996, 81, 498, 38);
        lblThirdTitle.setForeground(Color.BLACK);
        lblThirdTitle.setFont(new Font("Poppins", Font.PLAIN, 30));
        lblThirdTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblThirdTitle, JLayeredPane.DEFAULT_LAYER);
        
        SimpleAttributeSet atributo = new SimpleAttributeSet();
        StyleConstants.setAlignment(atributo, StyleConstants.ALIGN_CENTER);
        
        // Texto sobre a funcionalidade de cadastro de produtos
        lblFirstText = new JTextPane();
        lblFirstText.setText("A funcionalidade de cadastro de produtos é designada para o gerenciamento dos seus produtos, sendo possível cadastra-los para verificar as informações e disponibilidade de cada um.");
        lblFirstText.setBounds(0, 170, 498, 180);
        lblFirstText.setForeground(Color.BLACK);
        lblFirstText.setFont(new Font("Poppins", Font.PLAIN, 20));
        lblFirstText.setParagraphAttributes(atributo, false);
        lblFirstText.setEditable(false);
        this.add(lblFirstText, JLayeredPane.DEFAULT_LAYER);
        
        // Texto sobre a funcionalidade de visualização dos produtos
        lblSecondText = new JTextPane();
        lblSecondText.setText("A funcionalidade de gerenciamento de produtos foi desenvolvida em busca de uma melhor visualização e confiabilidade das informações sobre os produtos guardadas no banco de dados.");
        lblSecondText.setBounds(498, 170, 498, 180);
        lblSecondText.setForeground(Color.BLACK);
        lblSecondText.setFont(new Font("Poppins", Font.PLAIN, 20));
        lblSecondText.setParagraphAttributes(atributo, false);
        lblSecondText.setEditable(false);
        this.add(lblSecondText, JLayeredPane.DEFAULT_LAYER);
        
        // Texto sobre a funcionalidade lista de vendas
        lblThirdText = new JTextPane();
        lblThirdText.setText("A funcionalidade lista de vendas está sendo desenvolvida e será adicionada na próxima versão do software para a Atividade 3 da UC11 do curso Técnico em Desenvolvimento de Sistemas. Portanto, não está disponível no momento.");
        lblThirdText.setBounds(996, 170, 498, 180);
        lblThirdText.setForeground(Color.BLACK);
        lblThirdText.setFont(new Font("Poppins", Font.PLAIN, 20));
        lblThirdText.setParagraphAttributes(atributo, false);
        lblThirdText.setEditable(false);
        this.add(lblThirdText, JLayeredPane.DEFAULT_LAYER);
        
    }
    
    
    public final void configBtns() {
        
        // Create a bufferedImage
        BufferedImage bi = new BufferedImage(imgArrow.getIconWidth(), imgArrow.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        imgArrow.paintIcon(null, g, 0, 0);
        g.dispose();
        
        // Flip the arrow
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-bi.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bi = op.filter(bi, null);
        
        // Imagem da seta invertida
        ImageIcon leftArrow = new ImageIcon(bi);
        
        // Botão para a esquerda
        leftBtn = new CircleButtonShadow("");
        leftBtn.addActionListener(this);
        leftBtn.setBounds(381, 9, 36, 36);
        leftBtn.setBackground(new Color(0xCAD9DD));
        leftBtn.setIcon(leftArrow);
        leftBtn.setShadowSize(0);
        this.add(leftBtn, JLayeredPane.PALETTE_LAYER);
        
        // Botão para a direita
        rightBtn = new CircleButtonShadow("");
        rightBtn.addActionListener(this);
        rightBtn.setBounds(423, 9, 36, 36);
        rightBtn.setBackground(new Color(0xE5DDC5));
        rightBtn.setIcon(imgArrow);
        rightBtn.setShadowSize(0);
        this.add(rightBtn, JLayeredPane.PALETTE_LAYER);
        
    }
    
    
    public void trocarText() {
        
        timer = new Timer(1, this);
        timer.start();
        
    }
    
    
    public void resizeText(int position) {
        
        if(position > 0) {
            lblThirdTitle.setBounds(lblThirdTitle.getX() - 6, lblThirdTitle.getY(), lblThirdTitle.getWidth(), lblThirdTitle.getHeight());
            lblSecondTitle.setBounds(lblSecondTitle.getX() - 6, lblSecondTitle.getY(), lblSecondTitle.getWidth(), lblSecondTitle.getHeight());
            lblFirstTitle.setBounds(lblFirstTitle.getX() - 6, lblFirstTitle.getY(), lblFirstTitle.getWidth(), lblFirstTitle.getHeight());
            lblThirdText.setBounds(lblThirdText.getX() - 6, lblThirdText.getY(), lblThirdText.getWidth(), lblThirdText.getHeight());
            lblSecondText.setBounds(lblSecondText.getX() - 6, lblSecondText.getY(), lblSecondText.getWidth(), lblSecondText.getHeight());
            lblFirstText.setBounds(lblFirstText.getX() - 6, lblFirstText.getY(), lblFirstText.getWidth(), lblFirstText.getHeight());
        } else if(position < 0) {
            lblThirdTitle.setBounds(lblThirdTitle.getX() + 6, lblThirdTitle.getY(), lblThirdTitle.getWidth(), lblThirdTitle.getHeight());
            lblSecondTitle.setBounds(lblSecondTitle.getX() + 6, lblSecondTitle.getY(), lblSecondTitle.getWidth(), lblSecondTitle.getHeight());
            lblFirstTitle.setBounds(lblFirstTitle.getX() + 6, lblFirstTitle.getY(), lblFirstTitle.getWidth(), lblFirstTitle.getHeight());
            lblThirdText.setBounds(lblThirdText.getX() + 6, lblThirdText.getY(), lblThirdText.getWidth(), lblThirdText.getHeight());
            lblSecondText.setBounds(lblSecondText.getX() + 6, lblSecondText.getY(), lblSecondText.getWidth(), lblSecondText.getHeight());
            lblFirstText.setBounds(lblFirstText.getX() + 6, lblFirstText.getY(), lblFirstText.getWidth(), lblFirstText.getHeight());
        }
        this.repaint();
        
    }
    
    
    public void pausarTimer() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == leftBtn) {
            pausarTimer();
            trocarText();
            btnSelecionado = leftBtn;
            
        } else if(e.getSource() == rightBtn) {
            pausarTimer();
            trocarText();
            btnSelecionado = rightBtn;
            
        } else if(e.getSource() == timer) {
            
            if(btnSelecionado == leftBtn) {
                if(lblFirstTitle.getX() <= -492 && lblFirstTitle.getX() >= -996) {
                    resizeText(lblFirstTitle.getX() - 498);
                    if(lblFirstTitle.getX() == -498) {
                        pausarTimer();
                    }
                }
                if(lblFirstTitle.getX() <= 0 && lblFirstTitle.getX() >= -492) {
                    resizeText(lblFirstTitle.getX() - 996);
                    if(lblFirstTitle.getX() == 0) {
                        pausarTimer();
                    }
                }
                
            } else if(btnSelecionado == rightBtn) {
                if(lblFirstTitle.getX() <= 0 && lblFirstTitle.getX() >= -492) {
                    resizeText(lblFirstTitle.getX() + 492);
                    if(lblFirstTitle.getX() == -492) {
                        pausarTimer();
                    }
                }
                if(lblFirstTitle.getX() <= -492 && lblFirstTitle.getX() >= -998) {
                    resizeText(lblFirstTitle.getX() + 996);
                    if(lblFirstTitle.getX() == -996) {
                        pausarTimer();
                    }
                }
                
            }
            
        }
        
    }
    
    
}
