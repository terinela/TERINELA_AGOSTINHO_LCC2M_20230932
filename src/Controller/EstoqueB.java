/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteA;
import Model.EstoqueA;
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
public class EstoqueB {
     private final Connection conn;
    
    public EstoqueB(){
    this.conn = new ConexaoBanco().getpegarConexao();
    }

    public void Guardar(EstoqueA  c){
     
       try{
            // criar o SQL
            String sql= " INSERT INTO estoque ( descricao, categoria, quantidade, data )"
                    + " VALUES(?, ?, ?, ?)";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
               
                stmt.setString(1,c.getDescricao());
                stmt.setString(2,c.getCategoria());
                stmt.setString(3,c.getQuantidade());
               stmt.setString(4,c.getData());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Dadod guardar com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao guardar dados" + erro); 
        }
 
       
    }
            
  public EstoqueA Pesquisa(String descricao) {
    String sql = "SELECT * FROM estoque WHERE descricao = ?";
    PreparedStatement sp = null;
    ResultSet rs = null;

    try {
        sp = conn.prepareStatement(sql);
        sp.setString(1, descricao);
        rs = sp.executeQuery();

        if (rs.next()) {
            EstoqueA obj = new EstoqueA();
            obj.setIdestoque(rs.getInt("Idestoque"));
            obj.setDescricao(rs.getString("Descricao"));
            obj.setCategoria(rs.getString("Categoria"));
            obj.setQuantidade(rs.getString("Quantidade"));
            obj.setData(rs.getString("Data"));
            
            return obj;
        }else{
            JOptionPane.showMessageDialog(null, "Estoque, não encontrado");
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
  
  public List<EstoqueA>listar(){
  
  List<EstoqueA> lista = new ArrayList<>();
  try{
  String sql= "select * from estoque";
  PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  EstoqueA obj = new EstoqueA();
       obj.setIdestoque(rs.getInt("idestoque"));
       obj.setDescricao(rs.getString("descricao"));
       obj.setCategoria(rs.getString("categoria"));
       obj.setQuantidade(rs.getString("quantidade"));
       obj.setData(rs.getString("data"));
            
            lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
 
   public void Atualizar(EstoqueA obj){
     
       try{
            // criar o SQL
            String sql= " update estoque set descricao=?, categoria=?, quantidade=?, data=? where idestoque=?";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getDescricao());
                stmt.setString(2, obj.getCategoria());
                stmt.setString(3, obj.getQuantidade());
                stmt.setString(4, obj.getData());
                stmt.setInt(5, obj.getIdestoque());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Estoque editado com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao editar Estoque" + erro); 
        }
 
       
    }
  
   public void Remover(EstoqueA obj){
   try{
   String sql="delete from estoque where idestoque=?";
   PreparedStatement stmt = conn.prepareStatement(sql);
   stmt.setInt(1, obj.getIdestoque());
   stmt.execute();
   stmt.close();
   JOptionPane.showMessageDialog(null, "Dados de Estoque removido com sucesso");
   }catch(SQLException erro){
   JOptionPane.showMessageDialog(null, "Erro, ao remover dadados de estoque" + erro);
   
   }
   
   }
   
   
      
}


       
 
           