
package leiloestds.layouts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class LayoutTableHeader extends DefaultTableCellRenderer{
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Configurações da tabela
        setForeground(Color.BLACK);
        setFont(new Font("Poppins", Font.PLAIN, 14));
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        return this;
        
    }
    
    
    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = 28;
        return d;
    }
    
    
}
