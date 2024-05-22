
package leiloestds.ferramentas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoBar extends JPanel {


    public InfoBar() {
        
        setOpaque(false);
        setLayout(null);
        
        // Configura os itens da barra de informações
        configItens();
        
        // Configura as imagens
        configImages();
        
    }
    
    
    public final void configItens() {
        
        // High Quality
        JLabel lblHighQuality = new JLabel("High Quality");
        lblHighQuality.setBounds(86, 16, 115, 42);
        lblHighQuality.setForeground(Color.BLACK);
        lblHighQuality.setFont(new Font("Poppins", Font.BOLD, 18));
        this.add(lblHighQuality);
        
        JLabel lblHighInfo = new JLabel("Confiabilidade garantida");
        lblHighInfo.setBounds(86, 50, 205, 24);
        lblHighInfo.setForeground(new Color(0x898989));
        lblHighInfo.setFont(new Font("Poppins", Font.PLAIN, 16));
        this.add(lblHighInfo);
        
        // Verified Sales
        JLabel lblVerified = new JLabel("Verified Sales");
        lblVerified.setBounds(467, 16, 130, 42);
        lblVerified.setForeground(Color.BLACK);
        lblVerified.setFont(new Font("Poppins", Font.BOLD, 18));
        this.add(lblVerified);
        
        JLabel lblVerifiedInfo = new JLabel("Vendas Verificadas");
        lblVerifiedInfo.setBounds(467, 50, 158, 24);
        lblVerifiedInfo.setForeground(new Color(0x898989));
        lblVerifiedInfo.setFont(new Font("Poppins", Font.PLAIN, 16));
        this.add(lblVerifiedInfo);
        
        // Support
        JLabel lblSupport = new JLabel("24 / 7 Support");
        lblSupport.setBounds(799, 16, 130, 42);
        lblSupport.setForeground(Color.BLACK);
        lblSupport.setFont(new Font("Poppins", Font.BOLD, 18));
        this.add(lblSupport);
        
        JLabel lblSupportInfo = new JLabel("Suporte Diário");
        lblSupportInfo.setBounds(799, 50, 115, 24);
        lblSupportInfo.setForeground(new Color(0x898989));
        lblSupportInfo.setFont(new Font("Poppins", Font.PLAIN, 16));
        this.add(lblSupportInfo);
        
    }
    
    
    public final void configImages() {
        
        // Imagem troféu
        ImageIcon imgTrophy = new ImageIcon(getClass().getResource("/images/Trophy.png"));
        JLabel lblTrophy = new JLabel();
        lblTrophy.setBounds(22, 22, imgTrophy.getIconWidth(), imgTrophy.getIconHeight());
        lblTrophy.setIcon(imgTrophy);
        this.add(lblTrophy);
        
        // Imagem selo de verificação
        ImageIcon imgGuarantee = new ImageIcon(getClass().getResource("/images/Guarantee.png"));
        JLabel lblGuarantee = new JLabel();
        lblGuarantee.setBounds(403, 22, imgGuarantee.getIconWidth(), imgGuarantee.getIconHeight());
        lblGuarantee.setIcon(imgGuarantee);
        this.add(lblGuarantee);
        
        // Imagem atendente do suporte
        ImageIcon imgCustumerSupport = new ImageIcon(getClass().getResource("/images/CustumerSupport.png"));
        JLabel lblCustumerSupport = new JLabel();
        lblCustumerSupport.setBounds(735, 22, imgCustumerSupport.getIconWidth(), imgCustumerSupport.getIconHeight());
        lblCustumerSupport.setIcon(imgCustumerSupport);
        this.add(lblCustumerSupport);
        
    }
    
    
}
