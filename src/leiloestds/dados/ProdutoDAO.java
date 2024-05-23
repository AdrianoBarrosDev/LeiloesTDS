package leiloestds.dados;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Produto> listagem = new ArrayList<>();
    
    public void cadastrarProduto (Produto produto){
        
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void venderProduto(int id) {
        
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            prep.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erro ao vender produto no banco de dados!");
        }
        
    }
    
    
    public ArrayList<Produto> listarProdutos(){
        
        String sql = "SELECT * FROM produtos";
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            while(resultset.next()) {
                Produto produto = new Produto();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listagem;
    }
    
    
    
        
}

