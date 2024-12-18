/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteA;
import Model.ProdutoA;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class ProdutoB {
     private final Connection conn;
    
    public ProdutoB(){
    this.conn = new ConexaoBanco().getpegarConexao();
    }

    public void Guardar(ProdutoA c){
     
       try{
            // criar o SQL
            String sql= " INSERT INTO produto ( nome, descricao, categoria, preco, quantidade, codbarra, fornecedor )"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
               
                stmt.setString(1,c.getNome());
                stmt.setString(2,c.getDescricao());
                stmt.setString(3,c.getCategoria());
                stmt.setString(4,c.getPreco());
                stmt.setString(5,c.getQuantidade());
               stmt.setString(6,c.getCodbarra());
               stmt.setString(7,c.getFornecedor());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao salvar Produto" + erro); 
        }
 
       
    }
            
  public ProdutoA Pesquisa(String nome) {
    String sql = "SELECT * FROM produto WHERE nome = ?";
    PreparedStatement sp = null;
    ResultSet rs = null;

    try {
        sp = conn.prepareStatement(sql);
        sp.setString(1, nome);
        rs = sp.executeQuery();

        if (rs.next()) {
            ProdutoA obj = new ProdutoA();
            obj.setIdproduto(rs.getInt("Idproduto"));
            obj.setNome(rs.getString("Nome"));
            obj.setDescricao(rs.getString("Descricao"));
            obj.setCategoria(rs.getString("Categoria"));
            obj.setPreco(rs.getString("Preco"));
            obj.setQuantidade(rs.getString("Quantidade"));
            
            
            //return obj;
        }else{
            JOptionPane.showMessageDialog(null, "Produto, não encontrado");
        }
    } catch (Exception e) {
        System.out.println("Erro ao pesquisar: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (sp != null) {
                sp.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar os recursos: " + ex.getMessage());
        }
    }
    return null;
}
  public class Limpar {
          public void LimparTela(JPanel container){
Component conponents[] = container.getComponents();


for(Component Component : conponents){
    if(Component instanceof JTextField){
        ( (JTextField)Component).setText(null);
    }
}
}
} 
  
  public List<ProdutoA>listar(){
  
  List<ProdutoA> lista = new ArrayList<>();
  try{
  String sql= "select * from produto";
  PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  ProdutoA obj = new ProdutoA();
       obj.setIdproduto(rs.getInt("idproduto"));
       obj.setNome(rs.getString("nome"));
       obj.setDescricao(rs.getString("descricao"));
       obj.setCategoria(rs.getString("categoria"));
       obj.setPreco(rs.getString("preco"));
       obj.setQuantidade(rs.getString("quantidade"));
       obj.setCodbarra(rs.getString("codbarra"));
       obj.setFornecedor(rs.getString("fornecedor"));
            
            lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
 
   public void Atualizar(ProdutoA obj){
     
       try{
            // criar o SQL
            String sql= " update produto set nome=?, descricao=?, categoria=?, preco=?, quantidade=? where idproduto=?";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2, obj.getDescricao());
                stmt.setString(3, obj.getCategoria());
                stmt.setString(4, obj.getPreco());
                stmt.setString(5, obj.getQuantidade());
                stmt.setInt(6, obj.getIdproduto());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao atualizar Produto" + erro); 
        }
 
       
    }
  
   public void Remover(ProdutoA obj){
   try{
   String sql="delete from produto where idproduto=?";
   PreparedStatement stmt = conn.prepareStatement(sql);
   stmt.setInt(1, obj.getIdproduto());
   stmt.execute();
   stmt.close();
   JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
   }catch(SQLException erro){
   JOptionPane.showMessageDialog(null, "Erro, ao remover Produto" + erro);
   
   }
   
   }
   
      
}


       
 
           