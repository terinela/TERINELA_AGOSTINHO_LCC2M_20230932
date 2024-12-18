/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteA;
import View.Tela;
import View.TelaLogin;
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
public class ClienteB {
     private final Connection conn;
    
    public ClienteB(){
    this.conn = new ConexaoBanco().getpegarConexao();
    }

    public void Guardar(ClienteA c){
     
       try{
            // criar o SQL
            String sql= " INSERT INTO cliente ( nome, email, contacto, endereco, data )"
                    + " VALUES(?, ?, ?, ?, ?)";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
               
                stmt.setString(1,c.getNome());
                stmt.setString(2,c.getEmail());
                stmt.setString(3,c.getContacto());
                stmt.setString(4,c.getEndereco());
                stmt.setString(5,c.getData());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao salvar Cliente" + erro); 
        }
 
       
    }
            
  public ClienteA Pesquisa(String nome) {
    String sql = "SELECT * FROM cliente WHERE nome = ?";
    PreparedStatement sp = null;
    ResultSet rs = null;

    try {
        sp = conn.prepareStatement(sql);
        sp.setString(1, nome);
        rs = sp.executeQuery();

        if (rs.next()) {
            ClienteA obj = new ClienteA();
            obj.setIdcliente(rs.getInt("Idcliente"));
            obj.setNome(rs.getString("Nome"));
            obj.setEmail(rs.getString("Email"));
            obj.setContacto(rs.getString("Contacto"));
            obj.setEndereco(rs.getString("Endereco"));
            obj.setData(rs.getString("Data"));
            
            return obj;
        }else{
            JOptionPane.showMessageDialog(null, "Cliente, não encontrado");
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
          public void LimparCliente(JPanel container){
Component conponents[] = container.getComponents();


for(Component Component : conponents){
    if(Component instanceof JTextField){
        ( (JTextField)Component).setText(null);
    }
}
}
} 
  
  public List<ClienteA>listar(){
  
  List<ClienteA> lista = new ArrayList<>();
  try{
  String sql= "select * from cliente";
  PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  ClienteA obj = new ClienteA();
       obj.setIdcliente(rs.getInt("idcliente"));
       obj.setNome(rs.getString("nome"));
       obj.setEmail(rs.getString("email"));
       obj.setContacto(rs.getString("contacto"));
       obj.setEndereco(rs.getString("endereco"));
       obj.setData(rs.getString("data"));
              //obj.setIdcliente(rs.getInt("Idcliente"));
            //obj.setNome(rs.getString("Nome"));
            //obj.setEmail(rs.getString("Email"));
            //obj.setContacto(rs.getString("Contacto"));
            //obj.setEndereco(rs.getString("Endereco"));
            //obj.setData(rs.getString("Data"));
            
            lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
 
   public void Atualizar(ClienteA obj){
     
       try{
            // criar o SQL
            String sql= " update cliente set nome=?, email=?, contacto=?, Endereco=?, data=? where idcliente=?";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getContacto());
                stmt.setString(4, obj.getEndereco());
                stmt.setString(5, obj.getData());
                stmt.setInt(6, obj.getIdcliente());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao atualizar Cliente" + erro); 
        }
 
       
    }
  
   public void Remover(ClienteA obj){
   try{
   String sql="delete from cliente where idcliente=?";
   PreparedStatement stmt = conn.prepareStatement(sql);
   stmt.setInt(1, obj.getIdcliente());
   stmt.execute();
   stmt.close();
   JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
   }catch(SQLException erro){
   JOptionPane.showMessageDialog(null, "Erro, ao remover Cliente" + erro);
   
   }
   
   }
   
    public List<ClienteA>filtrar(String nome){
  
  List<ClienteA> lista = new ArrayList<>();
  try{
  String sql= "select * from cliente where nome like?";
  PreparedStatement stmt = conn.prepareStatement(sql);
  stmt.setString(1, nome);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  ClienteA obj = new ClienteA();
       obj.setIdcliente(rs.getInt("idcliente"));
       obj.setNome(rs.getString("nome"));
       obj.setEmail(rs.getString("email"));
       obj.setContacto(rs.getString("contacto"));
       obj.setEndereco(rs.getString("endereco"));
       obj.setData(rs.getString("data"));
            
            lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
   
}


       
 
           