
package leiloes.layouts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class RoundedTextField extends JTextField{

    @Override 
    protected void paintComponent(Graphics g) {
        if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
          Graphics2D g2 = (Graphics2D) g.create();
          g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override 
    public void updateUI() {
      super.updateUI();
      setOpaque(false);
      setBorder(new RoundedCornerBorder(new Color(0xFEF4E8))); // Deixa a borda do JTextField arredondada
      UIManager.put("TextField.inactiveForeground", new Color(0xEEC7A3)); // Muda a cor do JTextField quanto ele está inativo
    }
    
}
