/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.ClienteA;
import Model.FornecedorA;
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
public class FornecedorB {
    private final Connection conn;
    
    public FornecedorB(){
    this.conn = new ConexaoBanco().getpegarConexao();
    }

    public void Guardar(FornecedorA c){
     
       try{
            // criar o SQL
            String sql= " INSERT INTO fornecedor ( nome, contacto,  email, endereco, data, representante )"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
               
                stmt.setString(1,c.getNome());
                stmt.setString(2,c.getContacto());
                stmt.setString(3,c.getEmail());
                stmt.setString(4,c.getEndereco());
                stmt.setString(5,c.getData());
                stmt.setString(6,c.getRepresentante());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao salvar Fornecedor" + erro); 
        }
 
       
    }

            
  public FornecedorA Pesquisa(String nome) {
    String sql = "SELECT * FROM fornecedor WHERE nome = ?";
    PreparedStatement sp = null;
    ResultSet rs = null;

    try {
        sp = conn.prepareStatement(sql);
        sp.setString(1, nome);
        rs = sp.executeQuery();

        if (rs.next()) {
            FornecedorA obj = new FornecedorA();
            obj.setIdfornecedor(rs.getInt("Idfornecedor"));
            obj.setNome(rs.getString("Nome"));
            obj.setRepresentante(rs.getString("Representante"));
            obj.setEmail(rs.getString("Email"));
            obj.setContacto(rs.getString("Contacto"));
            obj.setEndereco(rs.getString("Endereco"));
            obj.setData(rs.getString("Data"));
         
            
            return obj;
        }else{
            JOptionPane.showMessageDialog(null, "Fornecedor, não encontrado");
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
          public void LimparFornecedor(JPanel container){
Component conponents[] = container.getComponents();


for(Component Component : conponents){
    if(Component instanceof JTextField){
        ( (JTextField)Component).setText(null);
    }
}
}
} 
  
  public List<FornecedorA>listar(){
  
  List<FornecedorA> lista = new ArrayList<>();
  try{
  String sql= "select * from fornecedor";
  PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  FornecedorA obj = new FornecedorA();
       obj.setIdfornecedor(rs.getInt("Idfornecedor"));
       obj.setNome(rs.getString("nome"));
       obj.setContacto(rs.getString("contacto"));
       obj.setEmail(rs.getString("email"));
       obj.setEndereco(rs.getString("endereco"));
       obj.setData(rs.getString("data"));
       obj.setRepresentante(rs.getString("representante"));
       
       lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
 
   public void Atualizar(FornecedorA obj){
     
       try{
            // criar o SQL
            String sql= " update fornecedor set nome=?, contacto=?, email=?, Endereco=?, data=?, representante=? where idfornecedor=?";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2, obj.getContacto());
                stmt.setString(3, obj.getEmail());
                stmt.setString(4, obj.getEndereco());
                stmt.setString(5, obj.getData());
                stmt.setString(6, obj.getRepresentante());
                stmt.setInt(7, obj.getIdfornecedor());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao atualizar Fornecedor" + erro); 
        }
 
       
    }
  
   public void Remover(FornecedorA obj){
   try{
   String sql="delete from fornecedor where idfornecedor=?";
   PreparedStatement stmt = conn.prepareStatement(sql);
   stmt.setInt(1, obj.getIdfornecedor());
   stmt.execute();
   stmt.close();
   JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");
   }catch(SQLException erro){
   JOptionPane.showMessageDialog(null, "Erro, ao remover Fornecedor" + erro);
   
   }
   
   }
   
   

}
