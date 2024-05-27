
package leiloestds.ferramentas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import leiloestds.classes.ConfigFrame;
import leiloestds.dados.Produto;
import leiloestds.dados.ProdutoDAO;
import leiloestds.layouts.CustomTableCellRenderer;
import leiloestds.layouts.LayoutTableHeader;

public class TableProdutos extends JPanel {

    private final ConfigFrame configFrame;
    private JTable tabelaProdutos;
    private DefaultTableModel model;
    
    
    public TableProdutos(ConfigFrame configFrame) {
        this.configFrame = configFrame;
    }

    
    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }
    
    
    public void gerarTabela() {
        
        // Cria o modelo da tabela
        model = new DefaultTableModel() {
            
            // Deixa a tabela não editável
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        
        // Cria a tabela
        tabelaProdutos = new JTable(model);
        tabelaProdutos.setBackground(new Color(0xE5DDC5));
        tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelaProdutos.setRowHeight(23);
        tabelaProdutos.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        tabelaProdutos.setShowGrid(false);
        tabelaProdutos.setIntercellSpacing(new Dimension(-1, -1));
        tabelaProdutos.setBorder(null);
        
        
        // Adiciona as colunas
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Status");
        
        // Define o tamanho de cada coluna
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(64);
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(182);
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(154);
        
        // Modifica o cabeçalho da tabela
        changeColorsHeader(new Color(0xF1EEDC));
        
        // Atualiza as informações da tabela
        atualizarTabela();
        
        // Config ScrollPane
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBounds(0, 0, this.getWidth(), this.getHeight());
        scrollPane.getViewport().setBackground(new Color(0xE5DDC5));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setOpaque(true);
        this.add(scrollPane);
        
    }
    
    
    public void limparTabela() {
        model.setNumRows(0);
    }
    
    
    public void atualizarTabela() {
        
        // Limpa as informações antigas
        limparTabela();
        
        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> listaProdutos = dao.listarProdutos();
        
        // Adiciona todos os produtos da lista na tabela
        for(Produto p : listaProdutos) {
            Object[] object = {
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getStatus()
            };
            model.addRow(object);
        }
        
    }
    
    
    public void tabelaPersonalizada(ArrayList<Produto> listaProdutos) {
        
        // Limpa as informações antigas
        limparTabela();
        
        // Adiciona todos os produtos da lista na tabela
        for(Produto p : listaProdutos) {
            Object[] object = {
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getStatus()
            };
            model.addRow(object);
        }
        
    }
    
    
    private void changeColorsHeader(Color colorDefault) {
        
        for(int i = 0; i < tabelaProdutos.getModel().getColumnCount(); i++) {
            
            // Customização do cabeçalho das colunas
            if(i < tabelaProdutos.getModel().getColumnCount()) {
                DefaultTableCellRenderer headerRendererDefault = new LayoutTableHeader();
                headerRendererDefault.setBackground(colorDefault);
                tabelaProdutos.getColumnModel().getColumn(i).setHeaderRenderer(headerRendererDefault);
            }
        }
        
    }
    
    
    
}
