/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import Model.Usuario;
import View.Tela;
import View.TelaLogin;
import View.TelaPrincipal;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class Cadastro {
    private final Connection conn;
    
    public Cadastro(){
    this.conn = new ConexaoBanco().getpegarConexao();
    
    
    }

    public Cadastro(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

     public void Salvar(Usuario obj){
     
       try{
            // criar o SQL
            String sql= " INSERT INTO usuario ( nome, senha, email ) VALUES(?, ?, ?)";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2, obj.getSenha());
                stmt.setString(3, obj.getEmail());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao salvar usuário" + erro); 
        }
 
       
    }
    
  public Usuario Pesquisa(String nome) {
    String sql = "SELECT * FROM usuario WHERE nome = ?";
    PreparedStatement sp = null;
    ResultSet rs = null;

    try {
        sp = conn.prepareStatement(sql);
        sp.setString(1, nome);
        rs = sp.executeQuery();

        if (rs.next()) {
            Usuario obj = new Usuario();
            obj.setIdusuario(rs.getInt("Idusuario"));
            obj.setNome(rs.getString("Nome"));
            obj.setSenha(rs.getString("Senha"));
            obj.setEmail(rs.getString("Email"));
            
            return obj;
        }else{
            JOptionPane.showMessageDialog(null, "Usuário, não encontrado");
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

    private static class Conexao {

        private static Connection getConexao() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Conexao() {
        }
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
  
  public List<Usuario>listar(){
  
  List<Usuario> lista = new ArrayList<>();
  try{
  String sql= "SELECT * FROM usuario";
  PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  while(rs.next()){
  Usuario obj = new Usuario();
              obj.setIdusuario(rs.getInt("Idusuario"));
            obj.setNome(rs.getString("Nome"));
            obj.setSenha(rs.getString("Senha"));
            obj.setEmail(rs.getString("Email"));
            lista.add(obj);
  }
  return lista;
  }catch (SQLException e){
  JOptionPane.showMessageDialog(null, "Erro, ao criar a lista" + e); 
  } 
  return null;
  }
 
   public void Atualizar(Usuario obj){
     
       try{
            // criar o SQL
            String sql= " update usuario set nome=?, senha=?, email=? where idusuario=?";
            
            try ( //preparar a conexao SQL para a se conectar com o banco
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2, obj.getSenha());
                stmt.setString(3, obj.getEmail());
                stmt.setInt(4, obj.getIdusuario());
                
                // executar sql
                stmt.execute();
                // fechar conexao
                stmt.close();
                JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
            }
            
        } catch (SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro, ao atualizar usuario" + erro); 
        }
 
       
    }
  
   public void Remover(Usuario obj){
   try{
   String sql="delete from usuario where idusuario=?";
   PreparedStatement stmt = conn.prepareStatement(sql);
   stmt.setInt(1, obj.getIdusuario());
   stmt.execute();
   stmt.close();
   JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
   }catch(SQLException erro){
   JOptionPane.showMessageDialog(null, "Erro, ao remover usuario" + erro);
   
   }
   
   }
   
       public void gerarRelatorioCSV(String caminhoArquivo) throws SQLException, IOException {

           String sql= "SELECT * FROM usuario";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
  ResultSet rs= stmt.executeQuery();
  FileWriter writer = new FileWriter(caminhoArquivo)){
            
            writer.append("Idusuario, Nome, Senha, Email\n");
            
            
  while(rs.next()){
                writer.append(rs.getInt("Idusuario") + ",");
                writer.append(rs.getString("Nome") + ",");
                writer.append(rs.getString("Senha") + ",");
                writer.append(rs.getString("Email") + "\n");
  }
             writer.flush();
            System.out.println("Relatório CSV gerado com sucesso!");
                
            } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
       
       public void efectuarLogin (String nome, String senha) {
           try{
                   String sql = "SELECT * FROM usuario WHERE nome = ? and senha=?";
         PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nome);
    stmt.setString(2, senha);
    
    ResultSet rs= stmt.executeQuery();
    if(rs.next()){
    
    JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema FalCor");
     TelaPrincipal t = new TelaPrincipal();
        t.setVisible(true);
            }       else {
    TelaLogin l = new TelaLogin();
    JOptionPane.showMessageDialog(null, " Nome ou senha, inválido!");
   
    }       
    
   
    }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"erro:"+ erro);
       
           }
           }

       }
