
package leiloestds.ferramentas;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class ImageSlider extends JLayeredPane implements ActionListener {

    private ImageIcon iconSelected;
    private ImageIcon iconNoSelected;
    private JLabel lblFirstImage;
    private JLabel lblSecondImage;
    private JLabel lblThirdImage;
    private JLabel lblFourthImage;
    private JButton firstBtn;
    private JButton secondBtn;
    private JButton thirdBtn;
    private JButton fourthBtn;
    private JButton btnSelected;
    private Timer timer;
    
    public ImageSlider() {
        
        setLayout(null);
        
        // Imagens de cada botão
        iconSelected = new ImageIcon(getClass().getResource("/images/ImgBtnSelectedBlue.png"));
        iconNoSelected = new ImageIcon(getClass().getResource("/images/ImgBtnGray.png"));
        
        // Configura as imagens iniciais
        configImages();
        
        // Configura os botões
        configBtns();
        
    }
    
    
    public final void configImages() {
        
        ImageIcon imgFirst = new ImageIcon(getClass().getResource("/images/ImgShopping.png"));
        lblFirstImage = new JLabel();
        lblFirstImage.setBounds(0, 0, 546, 751);
        lblFirstImage.setIcon(imgFirst);
        this.add(lblFirstImage, JLayeredPane.DEFAULT_LAYER);
        
        ImageIcon imgSecond = new ImageIcon(getClass().getResource("/images/ImgSneaker.png"));
        lblSecondImage = new JLabel();
        lblSecondImage.setBounds(546, 0, 546, 751);
        lblSecondImage.setIcon(imgSecond);
        this.add(lblSecondImage, JLayeredPane.DEFAULT_LAYER);
        
        ImageIcon imgThird = new ImageIcon(getClass().getResource("/images/ImgNovoProduto.png"));
        lblThirdImage = new JLabel();
        lblThirdImage.setBounds(1092, 0, 546, 751);
        lblThirdImage.setIcon(imgThird);
        this.add(lblThirdImage, JLayeredPane.DEFAULT_LAYER);
        
        ImageIcon imgFourth = new ImageIcon(getClass().getResource("/images/ImgBuilding.png"));
        lblFourthImage = new JLabel();
        lblFourthImage.setBounds(1638, 0, 546, 751);
        lblFourthImage.setIcon(imgFourth);
        this.add(lblFourthImage, JLayeredPane.DEFAULT_LAYER);
        
    }
    
    
    public final void configBtns() {
        
        firstBtn = new JButton();
        firstBtn.addActionListener(this);
        firstBtn.setBounds(209, 700, 27, 27);
        firstBtn.setIcon(iconSelected);
        firstBtn.setBorder(null);
        firstBtn.setFocusable(false);
        firstBtn.setContentAreaFilled(false);
        firstBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(firstBtn, JLayeredPane.PALETTE_LAYER);
        
        secondBtn = new JButton();
        secondBtn.addActionListener(this);
        secondBtn.setBounds(251, 708, 11, 11);
        secondBtn.setIcon(iconNoSelected);
        secondBtn.setBorder(null);
        secondBtn.setFocusable(false);
        secondBtn.setContentAreaFilled(false);
        secondBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(secondBtn, JLayeredPane.PALETTE_LAYER);
        
        thirdBtn = new JButton();
        thirdBtn.addActionListener(this);
        thirdBtn.setBounds(285, 708, 11, 11);
        thirdBtn.setIcon(iconNoSelected);
        thirdBtn.setBorder(null);
        thirdBtn.setFocusable(false);
        thirdBtn.setContentAreaFilled(false);
        thirdBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(thirdBtn, JLayeredPane.PALETTE_LAYER);
        
        fourthBtn = new JButton();
        fourthBtn.addActionListener(this);
        fourthBtn.setBounds(319, 708, 11, 11);
        fourthBtn.setIcon(iconNoSelected);
        fourthBtn.setBorder(null);
        fourthBtn.setFocusable(false);
        fourthBtn.setContentAreaFilled(false);
        fourthBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(fourthBtn, JLayeredPane.PALETTE_LAYER);
        
        btnSelected = firstBtn;
        
    }
    
    
    public void trocarImage(JButton btn) {
        
        timer = new Timer(1, this);
        timer.start();
        
    }
    
    
    public void trocarIcon(JButton btn) {
        if(btn.getIcon() == iconNoSelected) {
            btnSelected.setBounds(btnSelected.getX() + 8, btnSelected.getY() + 8, iconNoSelected.getIconWidth(), iconNoSelected.getIconHeight());
            btnSelected.setIcon(iconNoSelected);
            
            btn.setIcon(iconSelected);
            btn.setBounds(btn.getX() - 8, btn.getY() - 8, iconSelected.getIconWidth(), iconSelected.getIconHeight());
            
            btnSelected = btn;
        }
        this.repaint();
    }
    
    
    public void resizeImage(int number) {
        
        if(number > 0) {
            lblFourthImage.setBounds(lblFourthImage.getX() - 26, lblFourthImage.getY(), lblFourthImage.getWidth(), lblFourthImage.getHeight());
            lblThirdImage.setBounds(lblThirdImage.getX() - 26, lblThirdImage.getY(), lblThirdImage.getWidth(), lblThirdImage.getHeight());
            lblSecondImage.setBounds(lblSecondImage.getX() - 26, lblSecondImage.getY(), lblSecondImage.getWidth(), lblSecondImage.getHeight());
            lblFirstImage.setBounds(lblFirstImage.getX() - 26, lblFirstImage.getY(), lblFirstImage.getWidth(), lblFirstImage.getHeight());
        } else if(number < 0) {
            lblFourthImage.setBounds(lblFourthImage.getX() + 26, lblFourthImage.getY(), lblFourthImage.getWidth(), lblFourthImage.getHeight());
            lblThirdImage.setBounds(lblThirdImage.getX() + 26, lblThirdImage.getY(), lblThirdImage.getWidth(), lblThirdImage.getHeight());
            lblSecondImage.setBounds(lblSecondImage.getX() + 26, lblSecondImage.getY(), lblSecondImage.getWidth(), lblSecondImage.getHeight());
            lblFirstImage.setBounds(lblFirstImage.getX() + 26, lblFirstImage.getY(), lblFirstImage.getWidth(), lblFirstImage.getHeight());
        } else {
            timer.stop();
        }
        this.repaint();
        
    }
    
    
    public void pausarTimer() {
        if(timer != null) {
            timer.stop();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == firstBtn) {
            pausarTimer();
            trocarIcon(firstBtn);
            trocarImage(firstBtn);
            
        } else if(e.getSource() == secondBtn) {
            pausarTimer();
            trocarIcon(secondBtn);
            trocarImage(secondBtn);
            
        } else if(e.getSource() == thirdBtn) {
            pausarTimer();
            trocarIcon(thirdBtn);
            trocarImage(thirdBtn);
            
        } else if(e.getSource() == fourthBtn) {
            pausarTimer();
            trocarIcon(fourthBtn);
            trocarImage(fourthBtn);
            
        } else if(e.getSource() == timer) {
            
            if(btnSelected == firstBtn) {
                resizeImage(lblFirstImage.getX());

            } else if(btnSelected == secondBtn) {
                resizeImage(lblSecondImage.getX());

            } else if(btnSelected == thirdBtn) {
                resizeImage(lblThirdImage.getX());

            } else if(btnSelected == fourthBtn) {
                resizeImage(lblFourthImage.getX());

            }
            
        }
        
    }
    
    
}
