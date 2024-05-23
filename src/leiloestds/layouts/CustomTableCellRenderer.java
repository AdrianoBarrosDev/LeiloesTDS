
package leiloestds.layouts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
        
        setForeground(Color.BLACK);
        setFont(new Font("Poppins", Font.PLAIN, 12));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
        
        if(!isSelected) {
            
            setForeground(Color.BLACK);
            
            // Se a linha for par
            if(row % 2 == 0){
                setBackground(new Color(0xE5DDC5));
                setBorder(BorderFactory.createLineBorder(new Color(0xE5DDC5)));
                
            }else{ // Se a linha for ímpar
                setBackground(new Color(0xF1EEDC));
                setBorder(BorderFactory.createLineBorder(new Color(0xF1EEDC)));
                
            }
           
        } else {
            setBackground(new Color(0xBBB091));
            setBorder(BorderFactory.createLineBorder(new Color(0xBBB091)));
        }
        
        return this;
        
    }
    
}
